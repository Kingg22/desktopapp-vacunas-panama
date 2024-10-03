package com.kingg.api_vacunas_panama.web.dto;

import com.kingg.api_vacunas_panama.persistence.entity.Permiso;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

/**
 * DTO for {@link Permiso}
 */
@Validated
public record PermisoDto(Short id,
                         @NotBlank(message = "El nombre del permiso es requerido") String nombre,
                         String descripcion) implements Serializable {
}