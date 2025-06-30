package com.clinic.usuarios_service.service;

import com.clinic.usuarios_service.entities.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    Persona create(Persona persona);
    Persona update(Persona persona);
    void delete(Long id);
    Optional<Persona> getById(Long id);
    List<Persona> getAll();
}
