package com.kingg.api_vacunas_panama.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDto(@NotBlank(message = "El usuario es requerido") String username,
                       @NotBlank(message = "La contraseña es requerida")
                       @Size(min = 8, max = 70, message = "La contraseña no es válida")
                       String password) {
    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                 "username: " + username + ")";
    }
}
