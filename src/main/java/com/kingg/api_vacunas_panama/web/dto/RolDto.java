package com.kingg.api_vacunas_panama.web.dto;

import com.kingg.api_vacunas_panama.persistence.entity.Rol;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * DTO for {@link Rol}
 */
public record RolDto(Short id,
                     @NotNull @Size(max = 100) @NotBlank(message = "El nombre del rol es requerido") String nombre,
                     @Size(max = 100) String descripcion, Set<PermisoDto> permisos,
                     @Nullable @PastOrPresent LocalDateTime created_at,
                     @PastOrPresent LocalDateTime updated_at) implements Serializable {
}