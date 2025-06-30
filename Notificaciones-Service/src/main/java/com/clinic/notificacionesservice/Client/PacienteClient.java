package com.clinic.notificacionesservice.Client;


import com.clinic.notificacionesservice.config.FeignClientConfig;
import com.clinic.notificacionesservice.domain.DTO.PacienteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pacientes-service", configuration = FeignClientConfig.class, url = "http://localhost:8083/pacientes")
public interface PacienteClient {
    @GetMapping("/{id}")
    PacienteDto getPacienteById(@PathVariable("id") Long id);
}

