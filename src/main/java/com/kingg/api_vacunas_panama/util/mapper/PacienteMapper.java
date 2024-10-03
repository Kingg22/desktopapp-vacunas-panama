package com.kingg.api_vacunas_panama.util.mapper;

import com.kingg.api_vacunas_panama.persistence.entity.Paciente;
import com.kingg.api_vacunas_panama.web.dto.PacienteDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        config = PacienteMapperConfig.class)
public interface PacienteMapper {
    Paciente toEntity(PacienteDto pacienteDto);

    PacienteDto toDto(Paciente paciente);

    Paciente partialUpdate(PacienteDto pacienteDto, @MappingTarget Paciente paciente);

}
