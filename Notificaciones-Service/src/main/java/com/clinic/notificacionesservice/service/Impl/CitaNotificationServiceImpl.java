package com.clinic.notificacionesservice.service.Impl;


import com.clinic.notificacionesservice.domain.model.Notification;
import com.clinic.notificacionesservice.domain.enums.NotificationType;
import com.clinic.notificacionesservice.domain.enums.NotificationStatus;
import com.clinic.notificacionesservice.domain.DTO.PacienteDto;
import com.clinic.notificacionesservice.Client.PacienteClient;
import com.clinic.notificacionesservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CitaNotificationServiceImpl {

    private final NotificationService notificationService;
    private final PacienteClient pacienteClient;

    /**
     * Enviar un recordatorio de cita.
     * Este método se puede llamar para enviar un recordatorio previo a una cita médica.
     */
    public void sendRecordatorioCita(Long pacienteId) {
        // Obtener datos del paciente
        PacienteDto paciente = pacienteClient.getPacienteById(pacienteId);
        String recipient = paciente.getEmail(); // O teléfono si es SMS

        // Crear la notificación
        Notification notification = new Notification();
        notification.setRecipient(recipient);
        notification.setType(NotificationType.REMINDER);
        notification.setMessage("Recordatorio de tu cita médica");
        notification.setStatus(NotificationStatus.PENDING);

        // Enviar la notificación
        notificationService.sendNotification(notification);
    }

    /**
     * Enviar una notificación de cita.
     * Este método se puede llamar cuando se confirma una cita médica, con el tipo de evento.
     */
    public void sendCitaNotification(Long pacienteId, String eventType) {
        // Obtener datos del paciente
        PacienteDto paciente = pacienteClient.getPacienteById(pacienteId);
        String recipient = paciente.getEmail(); // O teléfono si es SMS

        // Crear la notificación
        Notification notification = new Notification();
        notification.setRecipient(recipient);
        notification.setType(NotificationType.CITA);
        notification.setMessage("Recordatorio de cita médica: " + eventType);
        notification.setStatus(NotificationStatus.PENDING);

        // Enviar la notificación
        notificationService.sendNotification(notification);
    }
}