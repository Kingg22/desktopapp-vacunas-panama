package com.kingg.api_vacunas_panama.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.UUID;

public record VacunaFabricanteDto(UUID id_vacuna,
                                  @NotNull @Size(max = 100) @NotBlank
                                  String nombre_vacuna,
                                  UUID id_fabricante,
                                  @NotNull
                                  @Size(max = 100)
                                  String nombre_fabricante) implements Serializable {
}
