package com.kingg.api_vacunas_panama.util.mapper;

import com.kingg.api_vacunas_panama.persistence.entity.Paciente;
import com.kingg.api_vacunas_panama.web.dto.PacienteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = PersonaMapper.class)
public interface PacienteMapper {

    @Mapping(target = "dosis", ignore = true)
    Paciente toEntity(PacienteDto pacienteDto);

    PacienteDto toDto(Paciente paciente);

}
