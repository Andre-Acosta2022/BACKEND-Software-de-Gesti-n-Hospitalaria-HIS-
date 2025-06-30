package com.clinic.notificacionesservice.repository;

import com.clinic.notificacionesservice.domain.enums.NotificationType;
import com.clinic.notificacionesservice.domain.model.NotificationTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotificationTemplateRepository extends JpaRepository<NotificationTemplate, Long> {
    Optional<NotificationTemplate> findByNameAndTypeAndLanguage(String name, NotificationType type, String language);
}