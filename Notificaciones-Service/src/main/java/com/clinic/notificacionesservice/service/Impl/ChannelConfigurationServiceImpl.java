package com.clinic.notificacionesservice.service.Impl;

import java.util.Map;
import java.util.Optional;

import com.clinic.notificacionesservice.domain.enums.NotificationType;
import com.clinic.notificacionesservice.domain.model.ChannelConfiguration;
import com.clinic.notificacionesservice.repository.ChannelConfigurationRepository;
import com.clinic.notificacionesservice.service.ChannelConfigurationService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class ChannelConfigurationServiceImpl implements ChannelConfigurationService {
    private final ChannelConfigurationRepository configurationRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Optional<Map<String, String>> getConfig(NotificationType channelType, String providerName) {
        return configurationRepository
                .findByChannelTypeAndProviderName(channelType, providerName)
                .map(ChannelConfiguration::getConfig)
                .map(configObj -> objectMapper.convertValue(
                        configObj, new TypeReference<Map<String, String>>() {}));
    }
}