package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.Permiso;
import com.kingg.api_vacunas_panama.persistence.entity.Rol;
import com.kingg.api_vacunas_panama.persistence.entity.Usuario;
import com.kingg.api_vacunas_panama.persistence.repository.PermisoRepository;
import com.kingg.api_vacunas_panama.persistence.repository.RolRepository;
import com.kingg.api_vacunas_panama.persistence.repository.UsuarioRepository;
import com.kingg.api_vacunas_panama.util.RolEnum;
import com.kingg.api_vacunas_panama.util.mapper.MapStructMapper;
import com.kingg.api_vacunas_panama.web.dto.PermisoDto;
import com.kingg.api_vacunas_panama.web.dto.RolDto;
import com.kingg.api_vacunas_panama.web.dto.UsuarioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service for {@link Usuario}, {@link Rol} and {@link Permiso}
 */

@Service
@RequiredArgsConstructor
public class UsuarioManagementService {
    private final MapStructMapper mapper;
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PermisoRepository permisoRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario createUser(UsuarioDto usuarioDto) {
        Set<Rol> role = usuarioDto.roles().stream()
                .map(this::convertToRoleExisting)
                .collect(Collectors.toSet());

        Usuario usuario = Usuario.builder()
                .cedula(usuarioDto.cedula())
                .username(usuarioDto.username())
                .correoUsuario(usuarioDto.correoUsuario())
                .claveHash(passwordEncoder.encode(usuarioDto.clave()))
                .fechaNacimiento(usuarioDto.fechaNacimiento())
                .disabled(usuarioDto.disabled())
                .createdAt(LocalDateTime.now())
                .roles(role)
                .build();
        return usuarioRepository.save(usuario);
    }

    public Rol createRol(RolDto rolDto) {
        return rolRepository.save(mapper.rolDtoToRol(rolDto));
    }

    public Permiso createPermiso(PermisoDto permisoDto) {
        return permisoRepository.save(mapper.permisoDtoToPermiso(permisoDto));
    }

    @Transactional
    public void changePassword(Usuario user, String newPassword) {
        user.setClaveHash(passwordEncoder.encode(newPassword));
        usuarioRepository.save(user);
    }

    public Usuario getUsuario(String id) {
        return usuarioRepository.findByCedulaOrCorreoUsuarioOrUsername(id, id, id).orElseThrow();
    }

    public boolean isCedulaRegistered(String cedula) {
        return cedula != null && usuarioRepository.findByCedula(cedula).isPresent();
    }

    public boolean isUsernameRegistered(String username) {
        return username != null && usuarioRepository.findByUsername(username).isPresent();
    }

    public boolean isCorreoRegistered(String correo) {
        return correo != null && usuarioRepository.findByCorreoUsuario(correo).isPresent();
    }

    public boolean equalsPassword(Usuario user, String newPassword) {
        return passwordEncoder.matches(newPassword, user.getClaveHash());
    }

    public boolean canRegisterRole(RolDto rolDto, List<RolEnum> authenticatedRoles) {
        int maxRolPriority = authenticatedRoles.stream()
                .mapToInt(RolEnum::getPriority)
                .max()
                .orElse(0);

        return RolEnum.valueOf(rolDto.nombreRol().toUpperCase()).getPriority() <= maxRolPriority;
    }

    public boolean hasUserManagementPermissions(List<String> authenticatedAuthorities) {
        return authenticatedAuthorities.contains("ADMINISTRATIVO_WRITE")
                || authenticatedAuthorities.contains("AUTORIDAD_WRITE")
                || authenticatedAuthorities.contains("USER_MANAGER_WRITE");
    }

    public Usuario canRestore(String username, LocalDateTime fechaNacimiento) {
        return usuarioRepository.findByCedulaOrCorreoUsuarioOrUsername(username, username, username)
                .filter(user -> user.getFechaNacimiento().equals(fechaNacimiento))
                .orElseThrow(() -> new UsernameNotFoundException("username not found or birthdate don't match to restore"));
    }

    private Rol convertToRoleExisting(RolDto rolDto) {
        return rolRepository.findByNombreRolOrId(rolDto.nombreRol(), rolDto.id()).orElseThrow();
    }

    private Permiso convertToPermisoExisting(PermisoDto permisoDto) {
        return permisoRepository.findByNombrePermisoOrId(permisoDto.nombrePermiso(), permisoDto.id()).orElseThrow();
    }
}
