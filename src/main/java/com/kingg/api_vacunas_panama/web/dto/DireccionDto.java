package com.kingg.api_vacunas_panama.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.kingg.api_vacunas_panama.persistence.entity.Direccion}
 */
@Validated
public record DireccionDto(@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) UUID id,
                           @NotBlank(message = "La descripción de la dirección es requerida") String direccion,
                           @NotNull(message = "El distrito no puede ser null") DistritoDto distrito) implements Serializable {
}