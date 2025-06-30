package com.clinic.usuarios_service.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;
    private String nombres;
    private String apellidos;
    private String dni;
    private String telefono;
    private char isActive='A';

    @OneToOne(mappedBy = "persona")
    @JsonIgnore
    private Usuario usuario;

}
