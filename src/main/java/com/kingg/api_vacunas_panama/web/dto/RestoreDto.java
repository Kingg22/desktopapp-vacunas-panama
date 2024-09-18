package com.kingg.api_vacunas_panama.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record RestoreDto(@NotBlank(message = "El usuario es requerido") String username,
                         @Size(min = 8, max = 70, message = "La contraseña no es válida") String new_password,
                         @PastOrPresent(message = "La fecha de nacimiento no puede ser futura") LocalDate fecha_nacimiento_usuario) {
    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "username: " + username + ", fecha_nacimiento_usuario: " + fecha_nacimiento_usuario + ")";
    }
}
