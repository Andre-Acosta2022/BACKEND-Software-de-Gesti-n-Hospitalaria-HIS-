package com.clinic.Pagos_Service.service;
import com.clinic.Pagos_Service.domain.Method;

import java.util.List;
import java.util.Optional;

public interface MethodService {
    Method create(Method method);
    Method update(Method method);
    void delete(Long id);
    Optional<Method> getById(Long id);
    List<Method> getAll();
}