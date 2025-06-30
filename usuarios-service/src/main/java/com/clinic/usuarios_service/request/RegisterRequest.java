package com.clinic.usuarios_service.request;

import com.clinic.usuarios_service.entities.Persona;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    private Persona persona;
}
