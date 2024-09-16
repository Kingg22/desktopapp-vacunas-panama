package com.kingg.api_vacunas_panama.web.dto;

import jakarta.validation.constraints.Null;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.kingg.api_vacunas_panama.persistence.entity.Direccion}
 */
public record DireccionDto(UUID id, String direccion, DistritoDto distrito, String nombreDistrito,
                           @Null Short idProvincia, @Null String nombreProvincia) implements Serializable {
}