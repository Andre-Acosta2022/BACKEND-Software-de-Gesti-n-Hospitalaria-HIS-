package com.clinic.notificacionesservice.service;

import com.clinic.notificacionesservice.domain.enums.NotificationType;



import java.util.Map;
import java.util.Optional;

public interface ChannelConfigurationService {
    Optional<Map<String, String>> getConfig(NotificationType channelType, String providerName);
}