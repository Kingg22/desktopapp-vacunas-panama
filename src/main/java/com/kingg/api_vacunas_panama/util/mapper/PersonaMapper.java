package com.kingg.api_vacunas_panama.util.mapper;

import com.kingg.api_vacunas_panama.persistence.entity.Persona;
import com.kingg.api_vacunas_panama.web.dto.PersonaDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = {DireccionMapper.class, AccountMapper.class})
public interface PersonaMapper {
    @Mapping(target = "fechaNacimiento", source = "fecha_nacimiento")
    Persona toEntity(PersonaDto personaDto);

    @Mapping(target = "fecha_nacimiento", source = "fechaNacimiento")
    PersonaDto toDto(Persona persona);

}