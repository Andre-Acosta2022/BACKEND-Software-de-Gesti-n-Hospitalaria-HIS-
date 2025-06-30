package com.clinic.auth_service.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // Solo accesible con rol ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hello-1")
    public String helloAdmin() {
        return "Hello Spring Boot With Keycloak with ADMIN";
    }

    // Accesible con rol DOCTOR o ADMIN
    @PreAuthorize("hasAnyRole('DOCTOR', 'ADMIN')")
    @GetMapping("/hello-2")
    public String helloDoctor() {
        return "Hello Spring Boot With Keycloak with DOCTOR or ADMIN";
    }

    // Accesible con rol PACIENTE o ADMIN
    @PreAuthorize("hasAnyRole('PACIENTE', 'ADMIN')")
    @GetMapping("/hello-3")
    public String helloPaciente() {
        return "Hello Spring Boot With Keycloak with PACIENTE or ADMIN";
    }
}
