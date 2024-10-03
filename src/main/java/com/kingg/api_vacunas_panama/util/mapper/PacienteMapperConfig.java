package com.kingg.api_vacunas_panama.util.mapper;

import com.kingg.api_vacunas_panama.persistence.entity.Paciente;
import com.kingg.api_vacunas_panama.web.dto.PacienteDto;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@MapperConfig(componentModel = MappingConstants.ComponentModel.SPRING, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = PersonaMapper.class)
public interface PacienteMapperConfig {
    @Mapping(target = "identificacionTemporal", source = "identificacion_temporal")
    @Mapping(target = "correo", source = "email")
    @Mapping(target = "createdAt", source = "created_at")
    @Mapping(target = "updatedAt", source = "update_at")
    @Mapping(target = "dosis", ignore = true)
    Paciente toEntity(PacienteDto pacienteDto);

    @Mapping(target = "updated_at", source = "updateAt")
    @Mapping(target = "created_at", source = "createdAt")
    @Mapping(target = "identificacion_temporal", source = "identificacionTemporal")
    @Mapping(target = "email", source = "correo")
    PacienteDto toDto(Paciente paciente);

}
