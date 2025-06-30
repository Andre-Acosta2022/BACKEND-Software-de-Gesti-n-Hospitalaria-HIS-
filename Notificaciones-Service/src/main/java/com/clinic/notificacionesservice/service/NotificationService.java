package com.clinic.notificacionesservice.service;

import com.clinic.notificacionesservice.domain.model.Notification;

import java.util.List;
import java.util.UUID;

public interface NotificationService {
    void sendNotification(Notification notification);
    Notification findById(UUID id);
    void retryNotification(UUID id);
    List<Notification> findAll();

}