package com.clinic.notificacionesservice.service;

import com.clinic.notificacionesservice.domain.model.UserPreferences;

import java.util.Optional;

public interface UserPreferencesService {
    Optional<UserPreferences> getPreferencesByUserId(String userId);
}