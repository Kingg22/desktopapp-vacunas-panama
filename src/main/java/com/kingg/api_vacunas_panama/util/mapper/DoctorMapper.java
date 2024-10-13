package com.kingg.api_vacunas_panama.util.mapper;

import com.kingg.api_vacunas_panama.persistence.entity.Doctor;
import com.kingg.api_vacunas_panama.web.dto.DoctorDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        uses = PersonaMapper.class)
public interface DoctorMapper {

    @Mapping(target = "sede", ignore = true)
    Doctor toEntity(DoctorDto doctorDto);

    DoctorDto toDto(Doctor doctor);

}