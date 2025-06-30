package com.clinic.notificacionesservice.repository;
import com.clinic.notificacionesservice.domain.model.NotificationEventLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationEventLogRepository extends JpaRepository<NotificationEventLog, Long> {
}
