package com.clinic.notificacionesservice.service.Impl;

import com.clinic.notificacionesservice.domain.enums.NotificationType;
import com.clinic.notificacionesservice.domain.model.NotificationTemplate;
import com.clinic.notificacionesservice.repository.NotificationTemplateRepository;
import com.clinic.notificacionesservice.service.NotificationTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationTemplateServiceImpl implements NotificationTemplateService {
    private final NotificationTemplateRepository templateRepository;

    @Override
    public Optional<NotificationTemplate> findTemplate(String name, NotificationType type, String language) {
        return templateRepository.findByNameAndTypeAndLanguage(name, type, language);
    }
}