package com.kingg.api_vacunas_panama.web.dto;

import com.kingg.api_vacunas_panama.persistence.entity.Rol;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link Rol}
 */
@Validated
public record RolDto(Short id,
                     @NotBlank(message = "El nombre del rol es requerido") String nombre,
                     String descripcion,
                     @Nullable @Valid Set<PermisoDto> permisos) implements Serializable {
}