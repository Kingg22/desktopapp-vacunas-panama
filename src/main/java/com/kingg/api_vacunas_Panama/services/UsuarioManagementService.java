package com.kingg.api_vacunas_panama.services;

import com.kingg.api_vacunas_panama.dto.RolDto;
import com.kingg.api_vacunas_panama.dto.UsuarioDto;
import com.kingg.api_vacunas_panama.entity.Permiso;
import com.kingg.api_vacunas_panama.entity.Rol;
import com.kingg.api_vacunas_panama.entity.Usuario;
import com.kingg.api_vacunas_panama.repositories.PermisoRepository;
import com.kingg.api_vacunas_panama.repositories.RolRepository;
import com.kingg.api_vacunas_panama.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service for {@link com.kingg.api_vacunas_panama.entity.Usuario}
 * , {@link com.kingg.api_vacunas_panama.entity.Rol}
 * and {@link com.kingg.api_vacunas_panama.entity.Permiso}
 */

@Service
public class UsuarioManagementService {
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PermisoRepository permisoRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioManagementService(UsuarioRepository usuarioRepository, RolRepository rolRepository, PermisoRepository permisoRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.permisoRepository = permisoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario createUser(UsuarioDto usuarioDto) {
            Set<Rol> role = usuarioDto.roles().stream()
            .map(this::convertToRole)
            .collect(Collectors.toSet());

            Usuario usuario = new Usuario(
                    usuarioDto.id(),
                    usuarioDto.cedula(),
                    usuarioDto.username(),
                    usuarioDto.correoElectronicoUsuario(),
                    passwordEncoder.encode(usuarioDto.clave()),
                    usuarioDto.fechaNacimiento(),
                    usuarioDto.disabled(),
                    LocalDateTime.now(),
                    usuarioDto.lastUsed(),
                    role
            );
            return usuarioRepository.save(usuario);
    }

    public Rol createRol(RolDto rolDto) {
        return rolRepository.save(new Rol(
                rolDto.id(), rolDto.nombreRol(), rolDto.descripcionRol(),
                rolDto.permisos().stream()
                        .map(this::convertToPermiso)
                        .collect(Collectors.toSet())
        ));
    }

    public Permiso createPermiso(RolDto.PermisoDto permisoDto) {
        return permisoRepository.save(new Permiso(
                permisoDto.id(),
                permisoDto.nombrePermiso(),
                permisoDto.descripcionPermiso()
        ));
    }


    public Rol convertToRole(RolDto rolDto) {
        return rolRepository.findByNombreRolOrId(rolDto.nombreRol(), rolDto.id()).orElseThrow();
    }

    public Permiso convertToPermiso(RolDto.PermisoDto permisoDto) {
        return permisoRepository.findByNombrePermisoOrId(permisoDto.nombrePermiso(), permisoDto.id()).orElseThrow();
    }
}
