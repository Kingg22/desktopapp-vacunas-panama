package com.kingg.api_vacunas_panama.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

/**
 * DTO for {@link com.kingg.api_vacunas_panama.persistence.entity.Distrito}
 */
public record DistritoDto(Short id,
                          @NotNull @Size(max = 100) @NotBlank(message = "Distrito name is required") String nombreDistrito) implements Serializable {
}