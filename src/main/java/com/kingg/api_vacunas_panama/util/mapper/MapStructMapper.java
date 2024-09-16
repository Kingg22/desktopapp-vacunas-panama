package com.kingg.api_vacunas_panama.util.mapper;

import com.kingg.api_vacunas_panama.persistence.entity.*;
import com.kingg.api_vacunas_panama.service.DireccionService;
import com.kingg.api_vacunas_panama.web.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.util.Set;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, uses = {DireccionService.class})
public interface MapStructMapper {
    @Mapping(target = "roles", ignore = true)
    Permiso permisoDtoToPermiso(PermisoDto permisoDto);

    PermisoDto permisoToPermisoDto(Permiso permiso);

    Set<Permiso> permisosDtoToPermisos(Set<PermisoDto> permisoDtoSet);

    @Mapping(target = "usuarios", ignore = true)
    Rol rolDtoToRol(RolDto rolDto);

    RolDto rolToRolDto(Rol rol);

    Set<Rol> rolesDtoToRoles(Set<RolDto> rolDtoSet);

    @Mapping(target = "dosis", ignore = true)
    Paciente pacienteDtoToPaciente(PacienteDto pacienteDto);

    PacienteDto pacienteToPacienteDto(Paciente paciente);

    @Mapping(target = "sedes", ignore = true)
    @Mapping(target = "pacientes", ignore = true)
    @Mapping(target = "idDistrito", source = "distrito.id")
    Direccion direccionDtoToDirecction(DireccionDto direccionDto);

    DistritoDto distritoToDistritoDto(Distrito distrito);

    @Mapping(target = "distrito", source = "idDistrito")
    @Mapping(target = "nombreDistrito", source = "idDistrito.nombreDistrito")
    @Mapping(target = "idProvincia", source = "idDistrito.idProvincia.id")
    @Mapping(target = "nombreProvincia", source = "idDistrito.idProvincia.nombreProvincia")
    DireccionDto direccionToDirecctionDto(Direccion direccion);

    ViewPacientesVacunasEnfermedadesDto viewPacienteVacunaEnfermedadToDto(ViewPacientesVacunasEnfermedades viewPacientesVacunasEnfermedades);
}
