package com.kingg.api_vacunas_panama.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kingg.api_vacunas_panama.persistence.entity.Provincia;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

/**
 * DTO for {@link Provincia}
 */
@Validated
public record ProvinciaDto(Short id,
                           @NotNull
                           @Size(max = 30)
                           @JsonProperty(defaultValue = "Por registrar")
                           String nombre) implements Serializable {
}