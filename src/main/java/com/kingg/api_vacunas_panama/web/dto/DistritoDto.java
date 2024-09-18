package com.kingg.api_vacunas_panama.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

/**
 * DTO for {@link com.kingg.api_vacunas_panama.persistence.entity.Distrito}
 */
@Validated
public record DistritoDto(@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) Short id,
                          @Size(max = 100) @NotBlank(message = "El nombre del distrito es requerido") String nombre,
                          @JsonProperty(access = JsonProperty.Access.READ_ONLY) String provincia) implements Serializable {
}