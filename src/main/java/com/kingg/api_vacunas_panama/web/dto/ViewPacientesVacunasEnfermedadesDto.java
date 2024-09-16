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
                                                  @NotNull LocalDateTime fechaDeNacimiento, Integer edad,
                                                  @NotNull Character sexo, @Size(max = 15) String telefono,
                                                  @Size(max = 50) String correoElectronico,
                                                  @Size(max = 150) String direccionResidencial,
                                                  @Size(max = 100) String distrito, @Size(max = 30) String provincia,
                                                  @NotNull @Size(max = 100) String nombreVacuna,
                                                  @NotNull @Size(max = 2) String numDeDosis,
                                                  @Size(max = 100) String enfermedadPreviene,
                                                  Short edadMinRecomendadaEnMeses,
                                                  @NotNull LocalDateTime fechaDeAplicacion,
                                                  Double intervaloRecomendadoEntreDosisEnMeses,
                                                  @Size(max = 100) String sede,
                                                  @Size(max = 13) String dependencia) implements Serializable {
}