package com.kingg.api_vacunas_panama.web.dto;

import com.kingg.api_vacunas_panama.persistence.entity.Permiso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Permiso}
 */
public record PermisoDto(Short id,
                         @NotNull @Size(max = 100) @NotBlank(message = "El nombre del permiso es requerido") String nombre,
                         @Size(max = 100) String descripcion, @NotNull @PastOrPresent LocalDateTime created_at,
                         @PastOrPresent LocalDateTime updated_at) implements Serializable {
}