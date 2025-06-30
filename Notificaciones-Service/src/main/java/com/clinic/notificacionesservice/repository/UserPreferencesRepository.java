package com.clinic.notificacionesservice.repository;

import com.clinic.notificacionesservice.domain.model.UserPreferences;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserPreferencesRepository extends JpaRepository<UserPreferences, Long> {
    Optional<UserPreferences> findByUserId(String userId);
}