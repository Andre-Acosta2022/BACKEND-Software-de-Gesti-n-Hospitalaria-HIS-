package com.clinic.notificacionesservice.domain.DTO;

import lombok.Data;


@Data
public class NotificationEventDto {
    private Long idPaciente;
    private String eventType;     // Ej: "ORDER_CONFIRMED"
    private Long pacienteId;       // ← ID para consultar vía Feign
    private String templateName;  // Nombre del template a usar
    private String language;      // Ej: "es", "en"
    private String provider;      // Ej: "GMAIL", "SendGrid"
    private String recipient;  // correo del destinatario
}