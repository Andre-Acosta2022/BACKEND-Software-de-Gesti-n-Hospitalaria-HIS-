package com.clinic.Pagos_Service.repository;

import com.clinic.Pagos_Service.domain.Method;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MethodRepository extends JpaRepository<Method,Long> {
}