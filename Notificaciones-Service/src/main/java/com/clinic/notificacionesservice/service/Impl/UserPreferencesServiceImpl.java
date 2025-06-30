package com.clinic.notificacionesservice.service.Impl;

import java.util.Optional;

import com.clinic.notificacionesservice.domain.model.UserPreferences;
import com.clinic.notificacionesservice.repository.UserPreferencesRepository;
import com.clinic.notificacionesservice.service.UserPreferencesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class UserPreferencesServiceImpl implements UserPreferencesService {
    private final UserPreferencesRepository preferencesRepository;

    @Override
    public Optional<UserPreferences> getPreferencesByUserId(String userId) {
        return preferencesRepository.findByUserId(userId);
    }
}