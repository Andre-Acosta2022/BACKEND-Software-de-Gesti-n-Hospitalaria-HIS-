package com.clinic.notificacionesservice.domain.DTO;

import lombok.Data;

@Data
public class PacienteDto {
    private Long idPaciente;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String dni;
    private String email; // Agregar correo electrónico
    private char isActive;

}