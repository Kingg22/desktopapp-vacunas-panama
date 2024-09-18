package com.kingg.api_vacunas_panama.util.mapper;

import com.kingg.api_vacunas_panama.persistence.entity.Permiso;
import com.kingg.api_vacunas_panama.persistence.entity.Rol;
import com.kingg.api_vacunas_panama.persistence.entity.Usuario;
import com.kingg.api_vacunas_panama.web.dto.PermisoDto;
import com.kingg.api_vacunas_panama.web.dto.RolDto;
import com.kingg.api_vacunas_panama.web.dto.UsuarioDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.util.Set;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface AccountMapper {

    @Mapping(target = "nombrePermiso", source = "nombre")
    @Mapping(target = "descripcionPermiso", ignore = true)
    @Mapping(target = "roles", ignore = true)
    Permiso permisoDtoToPermiso(PermisoDto permisoDto);

    @Mapping(target = "nombre", source = "nombrePermiso")
    PermisoDto permisoToDto(Permiso permiso);

    Set<Permiso> permisosDtoToPermisos(Set<PermisoDto> permisoDtoSet);

    @Mapping(target = "nombreRol", source = "nombre")
    @Mapping(target = "descripcionRol", ignore = true)
    @Mapping(target = "usuarios", ignore = true)
    Rol rolDtoToRol(RolDto rolDto);

    @Mapping(target = "nombre", source = "nombreRol")
    RolDto rolToDto(Rol rol);

    Set<Rol> rolesDtoToRoles(Set<RolDto> rolDtoSet);

    @Mapping(target = "last_used", source = "lastUsed")
    @Mapping(target = "fecha_nacimiento_usuario", source = "fechaNacimiento")
    @Mapping(target = "email", source = "correoUsuario")
    @Mapping(target = "created_at", source = "createdAt")
    @Mapping(target = "password", source = "claveHash")
    UsuarioDto usuarioToDto(Usuario usuario);

}
