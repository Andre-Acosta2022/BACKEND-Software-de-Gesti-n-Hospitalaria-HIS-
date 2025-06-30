package com.clinic.usuarios_service.service.Impl;
import com.clinic.usuarios_service.entities.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clinic.usuarios_service.repository.PersonaRepository;
import com.clinic.usuarios_service.service.PersonaService;
import java.util.List;
import java.util.Optional;
@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;
    @Override
    public Persona create(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona update(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void delete(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Optional<Persona> getById(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public List<Persona> getAll() {
        return personaRepository.findAll();
    }
}
