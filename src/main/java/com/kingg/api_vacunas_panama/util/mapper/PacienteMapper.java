package com.kingg.api_vacunas_panama.util.mapper;

import com.kingg.api_vacunas_panama.persistence.entity.Paciente;
import com.kingg.api_vacunas_panama.persistence.entity.ViewPacientesVacunasEnfermedades;
import com.kingg.api_vacunas_panama.web.dto.PacienteDto;
import com.kingg.api_vacunas_panama.web.dto.ViewPacientesVacunasEnfermedadesDto;
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

    @Mapping(target = "vacuna", source = "nombreVacuna")
    @Mapping(target = "numero_dosis", source = "numDeDosis")
    @Mapping(target = "intervalo_recomendado_dosis_meses", source = "intervaloRecomendadoEntreDosisEnMeses")
    @Mapping(target = "fecha_nacimiento", source = "fechaDeNacimiento")
    @Mapping(target = "fecha_aplicacion", source = "fechaDeAplicacion")
    @Mapping(target = "enfermedad_previene", source = "enfermedadPreviene")
    @Mapping(target = "email", source = "correoElectronico")
    @Mapping(target = "edad_min_recomendada_meses", source = "edadMinRecomendadaEnMeses")
    @Mapping(target = "direccion_residencial", source = "direccionResidencial")
    ViewPacientesVacunasEnfermedadesDto viewPacienteVacunaEnfermedadToDto(ViewPacientesVacunasEnfermedades viewPacientesVacunasEnfermedades);

}
