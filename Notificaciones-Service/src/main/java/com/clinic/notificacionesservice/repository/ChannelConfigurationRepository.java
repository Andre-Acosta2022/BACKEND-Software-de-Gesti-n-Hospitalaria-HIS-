package com.clinic.notificacionesservice.repository;


import com.clinic.notificacionesservice.domain.enums.NotificationType;
import com.clinic.notificacionesservice.domain.model.ChannelConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public interface ChannelConfigurationRepository extends JpaRepository<ChannelConfiguration, Long> {
    Optional<ChannelConfiguration> findByChannelTypeAndProviderName(NotificationType channelType, String providerName);
}