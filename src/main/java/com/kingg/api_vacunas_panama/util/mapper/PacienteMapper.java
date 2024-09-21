package com.kingg.api_vacunas_panama.util.mapper;

import com.kingg.api_vacunas_panama.persistence.entity.Paciente;
import com.kingg.api_vacunas_panama.web.dto.PacienteDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, uses = DireccionMapper.class)
public interface PacienteMapper {

    @Mapping(target = "telefonoPaciente", source = "telefono")
    @Mapping(target = "nombrePaciente", source = "nombre")
    @Mapping(target = "fechaNacimiento", source = "fecha_nacimiento")
    @Mapping(target = "edadCalculada", source = "edad")
    @Mapping(target = "correoPaciente", source = "email")
    @Mapping(target = "apellido2Paciente", source = "apellido2")
    @Mapping(target = "apellido1Paciente", source = "apellido1")
    @Mapping(target = "dosis", ignore = true)
    Paciente pacienteDtoToPaciente(PacienteDto pacienteDto);

    @Mapping(target = "telefono", source = "telefonoPaciente")
    @Mapping(target = "nombre", source = "nombrePaciente")
    @Mapping(target = "fecha_nacimiento", source = "fechaNacimiento")
    @Mapping(target = "email", source = "correoPaciente")
    @Mapping(target = "edad", source = "edadCalculada")
    @Mapping(target = "apellido2", source = "apellido2Paciente")
    @Mapping(target = "apellido1", source = "apellido1Paciente")
    PacienteDto pacienteToDto(Paciente paciente);

}
