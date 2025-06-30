package com.clinic.notificacionesservice.repository;

import com.clinic.notificacionesservice.domain.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.UUID;

public interface NotificationRepository extends JpaRepository<Notification, UUID> {
}