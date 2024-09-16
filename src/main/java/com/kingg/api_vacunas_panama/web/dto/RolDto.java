package com.kingg.api_vacunas_panama.web.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.kingg.api_vacunas_panama.persistence.entity.Rol}
 */
@Validated
public record RolDto(Short id,
                     @NotBlank(message = "El nombre del rol es requerido")
                     String nombreRol,
                     String descripcionRol,
                     @Valid
                     Set<PermisoDto> permisos) implements Serializable {

}