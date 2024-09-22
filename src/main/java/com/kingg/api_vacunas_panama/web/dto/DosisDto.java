package com.kingg.api_vacunas_panama.web.dto;

import com.kingg.api_vacunas_panama.util.NumDosisEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO for {@link com.kingg.api_vacunas_panama.persistence.entity.Dosis}
 */
public record DosisDto(
        @NotBlank @Pattern(regexp = "^((RN(\\d{1,2}?)?-)?(PE|E|N|[23456789](?:AV|PI)?|1[0123]?(?:AV|PI)?))-(\\d{1,4})-(\\d{1,6})$|^NI-(\\d*)$|^[A-Z0-9]{5,20}$",
                flags = {Pattern.Flag.CASE_INSENSITIVE, Pattern.Flag.MULTILINE},
                message = "El formato de la cédula u alias no es válido") String cedula,
        @NotNull LocalDateTime fecha_aplicacion,
        @NotNull NumDosisEnum numero_dosis, UUID id_vacuna, @Size(max = 100) String nombre_vacuna, UUID id_sede,
        @Size(max = 100) String nombre_sede,
        @Size(max = 50) String lote) implements Serializable {
}