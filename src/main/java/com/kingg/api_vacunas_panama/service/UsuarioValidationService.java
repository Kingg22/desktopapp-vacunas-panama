package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.Fabricante;
import com.kingg.api_vacunas_panama.persistence.entity.Persona;
import com.kingg.api_vacunas_panama.persistence.repository.UsuarioRepository;
import com.kingg.api_vacunas_panama.util.ApiContentResponse;
import com.kingg.api_vacunas_panama.util.ApiResponseCode;
import com.kingg.api_vacunas_panama.util.FormatCedulaUtil;
import com.kingg.api_vacunas_panama.util.RolesEnum;
import com.kingg.api_vacunas_panama.web.dto.RolDto;
import com.kingg.api_vacunas_panama.web.dto.UsuarioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service for {@link UsuarioManagementService} validations.
 */
@Service
@RequiredArgsConstructor
class UsuarioValidationService {
    private final CompromisedPasswordChecker compromisedPasswordChecker;
    private final PersonaService personaService;
    private final FabricanteService fabricanteService;
    private final UsuarioRepository usuarioRepository;

    public void validateRegistration(UsuarioDto usuarioDto, ApiContentResponse apiContentResponse) {
        if (isUsernameRegistered(usuarioDto.username())) {
            apiContentResponse.addError("code", ApiResponseCode.ALREADY_TAKEN.toString());
            apiContentResponse.addError("message", "El nombre de usuario ya está en uso");
        }
        if (compromisedPasswordChecker.check(usuarioDto.password()).isCompromised()) {
            apiContentResponse.addError("code", ApiResponseCode.COMPROMISED_PASSWORD.toString());
            apiContentResponse.addError("message", "La contraseña proporcionada está comprometida. Por favor use otra contraseña");
        }
        if (usuarioDto.roles().stream().anyMatch(rolDto -> rolDto.nombre().equalsIgnoreCase("Fabricante"))) {
            if (usuarioDto.licencia_fabricante() == null) {
                apiContentResponse.addError("code", ApiResponseCode.MISSING_INFORMATION.toString());
                apiContentResponse.addError("message", "Los fabricantes requieren licencia autorizada por Dirección Nacional de Farmacia y Drogas del MINSA");
            } else {
                validateRegistrationFabricante(usuarioDto, apiContentResponse);
            }
        } else {
            if (usuarioDto.cedula() == null && usuarioDto.pasaporte() == null) {
                apiContentResponse.addError("code", ApiResponseCode.MISSING_INFORMATION.toString());
                apiContentResponse.addError("message", "Las personas requieren una identificación personal como cédula panameña o pasaporte");
            } else {
                validateRegistrationPersona(usuarioDto, apiContentResponse);
            }
        }
    }


    void validateRegistrationPersona(UsuarioDto usuarioDto, ApiContentResponse apiContentResponse) {
        String cedula = null;
        if (usuarioDto.cedula() != null) {
            cedula = FormatCedulaUtil.formatCedula(usuarioDto.cedula());
        }
        String identifier = cedula != null ? cedula : usuarioDto.pasaporte();
        Optional<Persona> optPersona = personaService.getPersona(identifier);
        if (optPersona.isEmpty()) {
            apiContentResponse.addError("code", ApiResponseCode.NOT_FOUND.toString());
            apiContentResponse.addError("message", "La persona con la identificación personal proporcionada no fue encontrado");
        }
    }

    void validateRegistrationFabricante(UsuarioDto usuarioDto, ApiContentResponse apiContentResponse) {
        Optional<Fabricante> optFabricante = fabricanteService.getFabricante(usuarioDto.licencia_fabricante());
        if (optFabricante.isEmpty()) {
            apiContentResponse.addError("code", ApiResponseCode.NOT_FOUND.toString());
            apiContentResponse.addError("message", "El fabricante con la licencia proporcionada no fue encontrado");
        }
    }

    boolean isCedulaRegistered(String cedula) {
        return cedula != null && usuarioRepository.findByCedula(cedula).isPresent();
    }

    boolean isUsernameRegistered(String username) {
        return username != null && usuarioRepository.findByUsername(username).isPresent();
    }

    boolean isCorreoRegistered(String correo) {
        return correo != null && (usuarioRepository.findByCorreoPersona(correo).isPresent() || usuarioRepository.findByCorreoEntidad(correo).isPresent());
    }

    boolean isLicenciaFabricanteRegistered(String licencia) {
        return licencia != null && usuarioRepository.findByLicencia(licencia).isPresent();
    }

    boolean canRegisterRole(RolDto rolDto, List<RolesEnum> authenticatedRoles) {
        int maxRolPriority = authenticatedRoles.stream()
                .mapToInt(RolesEnum::getPriority)
                .max()
                .orElse(0);

        return RolesEnum.valueOf(rolDto.nombre().toUpperCase()).getPriority() <= maxRolPriority;
    }

    boolean hasUserManagementPermissions(List<String> authenticatedAuthorities) {
        return authenticatedAuthorities.contains("ADMINISTRATIVO_WRITE")
                || authenticatedAuthorities.contains("AUTORIDAD_WRITE")
                || authenticatedAuthorities.contains("USER_MANAGER_WRITE");
    }
}
