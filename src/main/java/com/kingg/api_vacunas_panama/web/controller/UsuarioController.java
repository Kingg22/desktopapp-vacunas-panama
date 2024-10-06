package com.kingg.api_vacunas_panama.web.controller;

import com.kingg.api_vacunas_panama.persistence.entity.*;
import com.kingg.api_vacunas_panama.service.PersonaService;
import com.kingg.api_vacunas_panama.service.TokenService;
import com.kingg.api_vacunas_panama.service.UsuarioManagementService;
import com.kingg.api_vacunas_panama.util.ApiResponse;
import com.kingg.api_vacunas_panama.util.ApiResponseCode;
import com.kingg.api_vacunas_panama.util.ApiResponseUtil;
import com.kingg.api_vacunas_panama.util.IApiResponse;
import com.kingg.api_vacunas_panama.web.dto.LoginDto;
import com.kingg.api_vacunas_panama.web.dto.RestoreDto;
import com.kingg.api_vacunas_panama.web.dto.UsuarioDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.authentication.password.CompromisedPasswordException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.UUID;

/**
 * Controller for {@link Usuario} registration and management, {@link Rol} and {@link Permiso}.
 * <p>
 * This controller handles operations related to registering users and managing their roles and associated entities
 * (e.g., {@link Paciente}, {@link Doctor}, {@link Fabricante}). It ensures that users are linked to an existing {@link Persona} or {@link Entidad}
 * and properly assigned roles.
 *
 * <p><b>Response Format:</b> The response for registration and related endpoints typically includes:</p>
 * <ul>
 *   <li>User details (e.g., username, roles, etc.).</li>
 *   <li>Associated {@link Persona} or {@link Entidad} information (e.g., {@link Paciente}, {@link Doctor}, {@link Fabricante})
 *   if applicable.</li>
 *   <li>A JWT token, which is only generated if the associated persona or entity has an active (validated) status.</li>
 * </ul>
 * <p>
 * For cases where both the {@link Persona}/{@link Entidad} and the {@link Usuario} need to created in a single request,
 * a different endpoint should be used.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/vacunacion/v1/account", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {
    private final TokenService tokenService;
    private final UsuarioManagementService usuarioManagementService;
    private final PersonaService personaService;
    private final AuthenticationManager authenticationManager;
    private final CompromisedPasswordChecker compromisedPasswordChecker;

    /**
     * Handles user registration.
     * <p>
     * First, it checks if the current {@link Authentication} is for an authenticated user with sufficient permissions
     * to create users with lower {@link Rol}. If not authenticated, it allows registering a {@link Paciente}.
     * It also validates tha data to be registered (e.g., username, email) is not currently in use.
     * <p>
     * If all validations pass, the {@link Usuario} is created.
     * <p><b>Note:</b> The user must be assigned roles, and empty roles are not allowed.
     * If the associated entities is not created, the request will be rejected.</p>
     *
     * @param usuarioDto     the data transfer object containing the user registration details
     * @param authentication the authentication object representing the current user (if any)
     * @param request        the HTTP request object containing additional request data
     * @return a {@link ResponseEntity} containing the registration result, including user details, associated {@link Persona} or {@link Entidad}
     * information, and a token if the {@link Persona} or {@link Entidad} is validated and active.
     */
    @PostMapping({"/register"})
    public ResponseEntity<Object> register(@RequestBody @Valid UsuarioDto usuarioDto, Authentication authentication, ServletWebRequest request) {
        IApiResponse<String, Object> apiResponse = new ApiResponse();
        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            this.usuarioManagementService.validateAuthoritiesRegister(usuarioDto, apiResponse, authentication);
        } else if (!usuarioDto.roles().stream().allMatch(rolDto -> rolDto.nombre().equalsIgnoreCase("Paciente"))) {
            apiResponse.addError(ApiResponseCode.MISSING_ROLE_OR_PERMISSION, "Solo pacientes pueden registrarse sin autenticación");
        }

        if (!apiResponse.hasErrors()) {
            this.usuarioManagementService.createUser(usuarioDto, apiResponse);
        } else {
            apiResponse.addStatusCode(HttpStatus.FORBIDDEN);
            apiResponse.addStatus("Insufficient authorities");
        }

        return ApiResponseUtil.sendResponse(apiResponse, request);
    }

    @PostMapping({"/login"})
    public ResponseEntity<Object> login(@RequestBody @Valid LoginDto loginDto, ServletWebRequest request) {
        IApiResponse<?, Object> apiResponse = new ApiResponse();
        Authentication authentication = null;

        try {
            authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.username(), loginDto.password()));
        } catch (CompromisedPasswordException exception) {
            log.debug("CompromisedPassword: {}", exception.getMessage());
            apiResponse.addStatusCode(HttpStatus.TEMPORARY_REDIRECT);
            apiResponse.addStatus("Please reset your password in the given uri");
            apiResponse.addStatus("/vacunacion/v1/account/restore");
            apiResponse.addError(ApiResponseCode.COMPROMISED_PASSWORD, "Su contraseña está comprometida, por favor cambiarla lo más pronto posible");
        }

        if (authentication != null && authentication.isAuthenticated()) {
            this.usuarioManagementService.setLoginResponse(UUID.fromString(authentication.getName()), apiResponse);
        }

        return ApiResponseUtil.sendResponse(apiResponse, request);
    }

    @PatchMapping({"/restore"})
    public ResponseEntity<Object> restore(@RequestBody @Valid RestoreDto restoreDto, ServletWebRequest request) {
        IApiResponse<String, Object> apiResponse = new ApiResponse();
        this.usuarioManagementService.changePasswordPersona(apiResponse, restoreDto);
        return ApiResponseUtil.sendResponse(apiResponse, request);
    }

    @GetMapping
    public ResponseEntity<Object> profile(Authentication authentication, ServletWebRequest request) {
        IApiResponse<String, Object> apiResponse = new ApiResponse();
        usuarioManagementService.getProfile(UUID.fromString(authentication.getName()), apiResponse);
        return ApiResponseUtil.sendResponse(apiResponse, request);
    }

}
