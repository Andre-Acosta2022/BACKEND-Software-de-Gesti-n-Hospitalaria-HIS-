package com.clinic.notificacionesservice.config;

import com.clinic.notificacionesservice.domain.DTO.NotificationEventDto;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer; // Importación faltante
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public ConsumerFactory<String, NotificationEventDto> citaEventConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                new JsonDeserializer<>(NotificationEventDto.class)
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, NotificationEventDto> citaEventListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, NotificationEventDto> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(citaEventConsumerFactory());
        return factory;
    }

    // Configuración similar para PagoEvent
}