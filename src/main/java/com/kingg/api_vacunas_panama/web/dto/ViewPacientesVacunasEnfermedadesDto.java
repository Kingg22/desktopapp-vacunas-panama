package com.kingg.api_vacunas_panama.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.kingg.api_vacunas_panama.persistence.entity.ViewPacientesVacunasEnfermedades}
 */
public record ViewPacientesVacunasEnfermedadesDto(@NotNull @Size(max = 20) String cedula,
                                                  @NotNull @Size(max = 50) String nombre,
                                                  @NotNull @Size(max = 50) String apellido1,
                                                  @Size(max = 50) String apellido2,
                                                  @NotNull LocalDateTime fecha_nacimiento, Integer edad,
                                                  @NotNull Character sexo, @Size(max = 15) String telefono,
                                                  @Size(max = 50) String email,
                                                  @Size(max = 150) String direccion_residencial,
                                                  @Size(max = 100) String distrito, @Size(max = 30) String provincia,
                                                  @NotNull @Size(max = 100) String vacuna,
                                                  @NotNull @Size(max = 2) String numero_dosis,
                                                  @Size(max = 100) String enfermedad_previene,
                                                  Short edad_min_recomendada_meses,
                                                  @NotNull LocalDateTime fecha_aplicacion,
                                                  Double intervalo_recomendado_dosis_meses,
                                                  @Size(max = 100) String sede,
                                                  @Size(max = 13) String dependencia) implements Serializable {
}