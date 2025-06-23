package com.clinic.notificacionesservice.events;

import com.clinic.notificacionesservice.domain.enums.EstadoNotificacion;

public class CitaEvent {

    private String orderNumber;
    private EstadoNotificacion notificacionEstado;
    private int itemsCount; // Asegúrate de tener este campo

    // Constructor, getters y setters

    public String orderNumber() {
        return orderNumber;
    }

    public EstadoNotificacion notificacionEstado() {
        return notificacionEstado;
    }

    public int getItemsCount() { // Método getter
        return itemsCount;
    }

    // Setters, constructors o cualquier otro método que necesites.
}