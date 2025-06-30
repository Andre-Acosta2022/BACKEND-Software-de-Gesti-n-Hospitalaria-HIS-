package com.clinic.usuarios_service.service;

import com.clinic.usuarios_service.entities.Usuario;
import com.clinic.usuarios_service.request.RegisterRequest;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Usuario create(Usuario usuario);
    Usuario update(Usuario usuario);
    void delete(String keycloakId);
    Optional<Usuario> getById(String keycloakId);
    List<Usuario> getAll();
    Usuario findByKeycloakId(String keycloakId);
    void registrarUsuario(RegisterRequest req);
}


