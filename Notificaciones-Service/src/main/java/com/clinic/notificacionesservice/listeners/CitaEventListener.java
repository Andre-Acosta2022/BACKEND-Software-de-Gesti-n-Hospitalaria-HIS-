package com.clinic.notificacionesservice.listeners;

import com.clinic.notificacionesservice.config.JsonUtils;
import com.clinic.notificacionesservice.domain.enums.EstadoNotificacion;
import com.clinic.notificacionesservice.events.CitaEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class CitaEventListener {

    @KafkaListener(topics = "orders-topic")
    public void handleOrdersNotifications(String message) {
        // Deserializar el mensaje a un objeto de tipo CitaEvent
        CitaEvent orderEvent = JsonUtils.fromJson(message, CitaEvent.class);

        // Aquí puedes acceder a los métodos no estáticos de CitaEvent a través de la instancia `orderEvent`
        var estadoNotificacion = JsonUtils.fromJson(message, EstadoNotificacion.class);

        // Send email to customer, send SMS to customer, etc.
        // Notify another service...

        // Usar la instancia `orderEvent` para acceder a los métodos
        log.info("Order {} event received for order: {} with {} items",
                orderEvent.notificacionEstado(),
                orderEvent.orderNumber(),
                orderEvent.getItemsCount()); // Llamada al nuevo getter
    }
}