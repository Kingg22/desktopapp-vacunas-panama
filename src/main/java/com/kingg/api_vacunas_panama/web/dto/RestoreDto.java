package com.kingg.api_vacunas_panama.web.dto;

import com.kingg.api_vacunas_panama.persistence.entity.Persona;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

/**
 * DTO for restore password only for {@link Persona}
 */
public record RestoreDto(@NotBlank(message = "La identificación es requerido") String username,
                         @NotBlank @Size(min = 8, max = 70, message = "La contraseña no es válida") String new_password,
                         @NotNull @PastOrPresent(message = "La fecha de nacimiento no puede ser futura") LocalDate fecha_nacimiento) {
    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "username: " + username + ", fecha_nacimiento: " + fecha_nacimiento + ")";
    }
}
