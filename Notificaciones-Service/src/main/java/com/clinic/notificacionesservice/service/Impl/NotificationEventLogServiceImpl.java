package com.clinic.notificacionesservice.service.Impl;
import com.clinic.notificacionesservice.domain.model.NotificationEventLog;
import com.clinic.notificacionesservice.repository.NotificationEventLogRepository;
import com.clinic.notificacionesservice.service.NotificationEventLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class NotificationEventLogServiceImpl implements NotificationEventLogService {
    private final NotificationEventLogRepository eventLogRepository;

    @Override
    public void saveEventLog(NotificationEventLog log) {
        eventLogRepository.save(log);
    }
}