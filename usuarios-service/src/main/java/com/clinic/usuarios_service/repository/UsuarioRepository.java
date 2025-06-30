package com.clinic.usuarios_service.repository;

import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.clinic.usuarios_service.entities.Usuario;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    @Query(value = "SELECT * FROM tbl_usuarios WHERE username = :username LIMIT 1", nativeQuery = true)
    Optional<Usuario> findByUsername(@Param("username") String username);
    Optional<Usuario> findByKeycloakId(String keycloakId);
}
