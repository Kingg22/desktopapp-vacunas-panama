package com.kingg.api_vacunas_panama.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.kingg.api_vacunas_panama.entity.Rol}
 */
@Validated
public record RolDto(Integer id,
                     @NotBlank(message = "El nombre del rol es requerido")
                     String nombreRol,
                     String descripcionRol,
                     @NotNull(message = "Los permisos del rol no puede ser null") @Valid
                     Set<PermisoDto> permisos) implements Serializable {

    /**
     * DTO for {@link com.kingg.api_vacunas_panama.entity.Permiso}
     */
    @Validated
    public record PermisoDto(Integer id,
                             @NotBlank(message = "El nombre del permiso es requerido")
                             String nombrePermiso,
                             String descripcionPermiso) implements Serializable {
    }
}