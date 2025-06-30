package com.clinic.notificacionesservice.domain.DTO;

import com.clinic.notificacionesservice.domain.enums.NotificationStatus;
import com.clinic.notificacionesservice.domain.enums.NotificationType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class NotificationDto {
    private UUID id;
    private String recipient;
    private NotificationType type;
    private String subject;
    private String message;
    private NotificationStatus status;
    private int attempts;
    private LocalDateTime createdAt;
    private LocalDateTime sentAt;
}