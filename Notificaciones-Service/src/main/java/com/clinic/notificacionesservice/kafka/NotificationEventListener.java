package com.clinic.notificacionesservice.kafka;

import com.clinic.notificacionesservice.Client.PacienteClient;
import com.clinic.notificacionesservice.domain.DTO.NotificationEventDto;
import com.clinic.notificacionesservice.domain.DTO.PacienteDto;
import com.clinic.notificacionesservice.domain.enums.NotificationStatus;
import com.clinic.notificacionesservice.domain.enums.NotificationType;
import com.clinic.notificacionesservice.domain.enums.ProviderType;
import com.clinic.notificacionesservice.domain.model.Notification;
import com.clinic.notificacionesservice.domain.model.NotificationEventLog;
import com.clinic.notificacionesservice.service.NotificationEventLogService;
import com.clinic.notificacionesservice.service.NotificationService;
import com.clinic.notificacionesservice.service.NotificationTemplateService;
import com.clinic.notificacionesservice.service.UserPreferencesService;
import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationEventListener {

    private final PacienteClient pacienteClient;
    private final UserPreferencesService userPreferencesService;
    private final NotificationTemplateService notificationTemplateService;
    private final NotificationService notificationService;
    private final NotificationEventLogService notificationEventLogService;

    @KafkaListener(topics = "notification-events", groupId = "notification-group")
    public void listen(NotificationEventDto event) {
        log.info("📨 Evento recibido en Kafka: {}", event);

        // 1. Obtener datos de la persona
        PacienteDto persona = pacienteClient.getPacienteById(event.getPacienteId());
        String fullName = persona.getNombres() + " " + persona.getApellidos();

        // 2. Definir correo destino (hasta que Persona tenga el campo real)
        String recipientEmail = event.getRecipient(); // o algún correo fijo de prueba

        // 3. Validar preferencias del usuario
        userPreferencesService.getPreferencesByUserId(event.getPacienteId().toString()).ifPresent(prefs -> {
            ProviderType provider = mapProvider(event.getProvider());
            if (provider == ProviderType.GMAIL && !prefs.isEmailEnabled()) return;
            if (provider == ProviderType.TWILIO && !prefs.isSmsEnabled()) return;
        });

        // 4. Definir tipo de notificación
        NotificationType type = NotificationType.EMAIL;
        ProviderType provider = mapProvider(event.getProvider());

        // 5. Buscar plantilla
        var templateOpt = notificationTemplateService.findTemplate(
                event.getTemplateName(), type, event.getLanguage());

        if (templateOpt.isEmpty()) {
            log.warn("⚠️ No se encontró plantilla para '{}'", event.getTemplateName());
            return;
        }

        var template = templateOpt.get();
        String personalizedMessage = template.getBodyTemplate().replace("{{nombre}}", fullName);

        // 6. Crear notificación
        Notification notification = Notification.builder()
                .recipient(recipientEmail)
                .type(type)
                .provider(provider)
                .subject(template.getSubjectTemplate())
                .message(personalizedMessage)
                .status(NotificationStatus.PENDING)
                .build();

        // 7. Enviar notificación
        notificationService.sendNotification(notification);

        // 8. Guardar log del evento
        NotificationEventLog logEntry = NotificationEventLog.builder()
                .eventType(event.getEventType())
                .notification(notification)
                .build();

        notificationEventLogService.saveEventLog(logEntry);
        log.info("✅ Notificación procesada y log guardado.");
    }

    private ProviderType mapProvider(String rawProvider) {
        if (rawProvider == null) return ProviderType.GMAIL;

        return switch (rawProvider.toUpperCase()) {
            case "SENDGRID", "GMAIL" -> ProviderType.GMAIL;
            case "TWILIO" -> ProviderType.TWILIO;
            default -> throw new IllegalArgumentException("❌ Proveedor no soportado: " + rawProvider);
        };
    }
}