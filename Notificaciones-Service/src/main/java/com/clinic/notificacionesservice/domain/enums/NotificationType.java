package com.clinic.notificacionesservice.domain.enums;

public enum NotificationType {
    EMAIL,
    SMS,
    PUSH,
    CITA,   // Nueva opción
    REMINDER; // Nueva opción para recordatorios de citas

    // Opcional: Métodos útiles
    public boolean isEmail() {
        return this == EMAIL;
    }
}