package com.kingg.api_vacunas_panama.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

/**
 * DTO for {@link com.kingg.api_vacunas_panama.persistence.entity.Permiso}
 */
@Validated
public record PermisoDto(@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) Short id,
                         @NotBlank(message = "El nombre del permiso es requerido") String nombre) implements Serializable {
}