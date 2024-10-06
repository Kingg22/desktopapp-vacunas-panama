package com.kingg.api_vacunas_panama.web.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kingg.api_vacunas_panama.persistence.entity.Paciente;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * DTO for view_pacientes_vacunas_enfermedades, details about {@link Paciente} add separate of view.
 */
public record ViewPacienteVacunaEnfermedadDto(@JsonIgnore
                                              UUID id_paciente,
                                              UUID id_vacuna,
                                              @NotNull @Size(max = 100) String vacuna,
                                              @NotNull @Size(max = 2) String numero_dosis,
                                              List<Integer> ids_enfermedades,
                                              List<String> enfermedades_prevenidas,
                                              Short edad_min_recomendada_meses,
                                              @NotNull LocalDateTime fecha_aplicacion,
                                              Double intervalo_recomendado_dosis_meses,
                                              Integer intervalo_real_dosis_dias,
                                              @Size(max = 100) String sede,
                                              @Size(max = 13) String dependencia) implements Serializable {
    public ViewPacienteVacunaEnfermedadDto(String vacuna, String numero_dosis,
                                           String enfermedades_prevenidas, Short edad_minima,
                                           LocalDateTime fecha_aplicacion, Double intervalo_recomendado,
                                           Integer intervalo_real, String sede, String dependencia, UUID id, UUID id_vacuna, String ids_enfermedades) {
        this(id, id_vacuna, vacuna, numero_dosis.trim(),
                Arrays.stream(ids_enfermedades.split(", ")).map(Integer::parseInt).toList(),
                Arrays.asList(enfermedades_prevenidas.split(", ")),
                edad_minima, fecha_aplicacion, intervalo_recomendado, intervalo_real, sede, dependencia);
    }
}