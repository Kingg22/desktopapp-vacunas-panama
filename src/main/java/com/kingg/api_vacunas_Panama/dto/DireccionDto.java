package com.kingg.api_vacunas_panama.dto;

import jakarta.validation.constraints.Null;

import java.io.Serializable;

/**
 * DTO for {@link com.kingg.api_vacunas_panama.entity.Direccion}
 */
public record DireccionDto(Integer id, String direccion, Integer idDistrito, String nombreDistrito,
                           @Null Integer idProvincia, @Null String nombreProvincia) implements Serializable {
}