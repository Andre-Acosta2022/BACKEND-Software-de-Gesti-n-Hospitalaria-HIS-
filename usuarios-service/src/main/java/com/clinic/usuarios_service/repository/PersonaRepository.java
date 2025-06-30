package com.clinic.usuarios_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.clinic.usuarios_service.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
