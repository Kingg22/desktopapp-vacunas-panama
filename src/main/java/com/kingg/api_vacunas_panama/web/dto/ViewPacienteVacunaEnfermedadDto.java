package com.kingg.api_vacunas_panama.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * DTO for ViewPacientesVacunasEnfermedades
 */
public record ViewPacienteVacunaEnfermedadDto(@NotNull @Size(max = 100) String vacuna,
                                              @NotNull @Size(max = 2) String numero_dosis,
                                              List<String> enfermedades_prevenidas,
                                              Short edad_min_recomendada_meses,
                                              @NotNull LocalDateTime fecha_aplicacion,
                                              Double intervalo_recomendado_dosis_meses,
                                              @Size(max = 100) String sede,
                                              @Size(max = 13) String dependencia) implements Serializable {
    public ViewPacienteVacunaEnfermedadDto(String vacuna, String numero_dosis, String enfermedades_prevenidas, Short edad_min_recomendada_meses, LocalDateTime fecha_aplicacion, Double intervalo_recomendado_dosis_meses, String sede, String dependencia) {
        this(vacuna, numero_dosis, Arrays.asList(enfermedades_prevenidas.split(", ")), edad_min_recomendada_meses, fecha_aplicacion, intervalo_recomendado_dosis_meses, sede, dependencia);
    }
}