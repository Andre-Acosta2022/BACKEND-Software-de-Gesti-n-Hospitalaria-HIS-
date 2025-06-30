package com.clinic.notificacionesservice.service;



import com.clinic.notificacionesservice.domain.model.NotificationEventLog;



public interface NotificationEventLogService {
    void saveEventLog(NotificationEventLog log);
}