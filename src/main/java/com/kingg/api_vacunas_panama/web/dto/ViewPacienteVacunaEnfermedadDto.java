package com.kingg.api_vacunas_panama.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for ViewPacientesVacunasEnfermedades
 */
public record ViewPacienteVacunaEnfermedadDto(@NotNull @Size(max = 100) String vacuna,
                                              @NotNull @Size(max = 2) String numero_dosis,
                                              @Size(max = 100) String enfermedad_previene,
                                              Short edad_min_recomendada_meses,
                                              @NotNull LocalDateTime fecha_aplicacion,
                                              Double intervalo_recomendado_dosis_meses,
                                              @Size(max = 100) String sede,
                                              @Size(max = 13) String dependencia) implements Serializable {
}