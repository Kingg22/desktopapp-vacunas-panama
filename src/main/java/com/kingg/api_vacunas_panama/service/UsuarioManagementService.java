package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.Permiso;
import com.kingg.api_vacunas_panama.persistence.entity.Rol;
import com.kingg.api_vacunas_panama.persistence.entity.Usuario;
import com.kingg.api_vacunas_panama.persistence.repository.PermisoRepository;
import com.kingg.api_vacunas_panama.persistence.repository.RolRepository;
import com.kingg.api_vacunas_panama.persistence.repository.UsuarioRepository;
import com.kingg.api_vacunas_panama.util.RolEnum;
import com.kingg.api_vacunas_panama.util.mapper.AccountMapper;
import com.kingg.api_vacunas_panama.web.dto.PermisoDto;
import com.kingg.api_vacunas_panama.web.dto.RolDto;
import com.kingg.api_vacunas_panama.web.dto.UsuarioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
    private final AccountMapper mapper;
    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PermisoRepository permisoRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UsuarioDto createUser(UsuarioDto usuarioDto) {
        Set<Rol> role = usuarioDto.roles().stream()
                .map(this::convertToRoleExisting)
                .collect(Collectors.toSet());

        Usuario usuario = Usuario.builder()
                .cedula(usuarioDto.cedula())
                .username(usuarioDto.username())
                .correoUsuario(usuarioDto.email())
                .claveHash(passwordEncoder.encode(usuarioDto.password()))
                .fechaNacimiento(usuarioDto.fecha_nacimiento_usuario())
                .disabled(usuarioDto.disabled())
                .createdAt(LocalDateTime.now())
                .roles(role)
                .build();
        return mapper.usuarioToDto(usuarioRepository.save(usuario));
    }

    public RolDto createRol(RolDto rolDto) {
        return mapper.rolToDto(rolRepository.save(mapper.rolDtoToRol(rolDto)));
    }

    public PermisoDto createPermiso(PermisoDto permisoDto) {
        return mapper.permisoToDto(permisoRepository.save(mapper.permisoDtoToPermiso(permisoDto)));
    }

    @Transactional
    public void changePassword(String username, String newPassword, LocalDate birthdate) {
        Usuario usuario = usuarioRepository.findByCedulaOrCorreoUsuarioOrUsername(username, username, username)
                .filter(user -> user.getFechaNacimiento().toLocalDate().equals(birthdate))
                .orElseThrow(() -> new UsernameNotFoundException("username not found or birthdate don't match to restore"));
        if (passwordEncoder.matches(newPassword, usuario.getClaveHash())) {
            throw new IllegalArgumentException("new password cannot be equals to last password");
        }
        usuario.setClaveHash(passwordEncoder.encode(newPassword));
        usuarioRepository.save(usuario);
    }

    public UsuarioDto getUsuario(String id) {
        Usuario usuario = usuarioRepository.findByCedulaOrCorreoUsuarioOrUsername(id, id, id).orElseThrow();
        return mapper.usuarioToDto(usuario);
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

    public boolean canRegisterRole(RolDto rolDto, List<RolEnum> authenticatedRoles) {
        int maxRolPriority = authenticatedRoles.stream()
                .mapToInt(RolEnum::getPriority)
                .max()
                .orElse(0);

        return RolEnum.valueOf(rolDto.nombre().toUpperCase()).getPriority() <= maxRolPriority;
    }

    public boolean hasUserManagementPermissions(List<String> authenticatedAuthorities) {
        return authenticatedAuthorities.contains("ADMINISTRATIVO_WRITE")
                || authenticatedAuthorities.contains("AUTORIDAD_WRITE")
                || authenticatedAuthorities.contains("USER_MANAGER_WRITE");
    }

    private Rol convertToRoleExisting(RolDto rolDto) {
        return rolRepository.findByNombreRolOrId(rolDto.nombre(), rolDto.id()).orElseThrow();
    }

    private Permiso convertToPermisoExisting(PermisoDto permisoDto) {
        return permisoRepository.findByNombrePermisoOrId(permisoDto.nombre(), permisoDto.id()).orElseThrow();
    }
}
