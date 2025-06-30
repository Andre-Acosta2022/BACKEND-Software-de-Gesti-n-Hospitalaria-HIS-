package com.clinic.notificacionesservice.service;

import com.clinic.notificacionesservice.domain.enums.NotificationType;
import com.clinic.notificacionesservice.domain.model.NotificationTemplate;

import java.util.Optional;

public interface NotificationTemplateService {
    Optional<NotificationTemplate> findTemplate(String name, NotificationType type, String language);
}
