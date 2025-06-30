package com.clinic.usuarios_service.service.Impl;
import com.clinic.usuarios_service.client.KeycloakAdminClientService;
import com.clinic.usuarios_service.entities.Usuario;
import com.clinic.usuarios_service.request.RegisterRequest;
import com.clinic.usuarios_service.repository.UsuarioRepository;
import com.clinic.usuarios_service.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private KeycloakAdminClientService keycloakAdmin;
    @Override
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    @Override
    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    @Override
    public void delete(String keycloakId) {
        usuarioRepository.deleteById(keycloakId);
    }
    @Override
    public Optional<Usuario> getById(String keycloakId) {
        return usuarioRepository.findById(keycloakId);
    }
    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }
    @Override
    public Usuario findByKeycloakId(String keycloakId) {
        return usuarioRepository.findByKeycloakId(keycloakId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado: " + keycloakId));
    }

    @Override
    public void registrarUsuario(RegisterRequest req) {
        if (keycloakAdmin.isUsernameTaken(req.getUsername())) {
            throw new IllegalArgumentException("El usuario ya está registrado");
        }
        String keycloakId = keycloakAdmin.createUser(
                req.getUsername(),
                req.getPassword(),
                req.getEmail(),
                req.getPersona().getNombres(),
                req.getPersona().getApellidos()
        );
        Usuario usuario = new Usuario();
        usuario.setKeycloakId(keycloakId);
        usuario.setFechaRegistro(LocalDateTime.now());
        usuario.setAvatar("https://default-avatar.png");
        usuario.setPersona(req.getPersona());
        usuarioRepository.save(usuario);
    }

}
