package com.kingg.api_vacunas_panama.web.controller;

import com.kingg.api_vacunas_panama.web.dto.LoginDto;
import com.kingg.api_vacunas_panama.web.dto.UsuarioDto;
import com.kingg.api_vacunas_panama.persistence.entity.Usuario;
import com.kingg.api_vacunas_panama.service.TokenService;
import com.kingg.api_vacunas_panama.service.UsuarioManagementService;
import com.kingg.api_vacunas_panama.util.RolEnum;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.authentication.password.CompromisedPasswordException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/vacunacion/v1/account", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {
    private final TokenService tokenService;
    private final UsuarioManagementService usuarioManagementService;
    private final AuthenticationManager authenticationManager;
    private final CompromisedPasswordChecker compromisedPasswordChecker;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody @Valid UsuarioDto usuarioDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken) {
            if (!usuarioDto.roles().stream().allMatch(rolDto -> rolDto.nombreRol().equalsIgnoreCase("Paciente"))) {
                return ResponseEntity.badRequest().body("Only patients can register without authentication");
            }
        } else {
            List<String> authenticatedAuthorities = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .toList();
            List<RolEnum> authenticatedRoles = authenticatedAuthorities.stream()
                    .map(RolEnum::valueOf)
                    .toList();

            if (!usuarioDto.roles().stream()
                    .allMatch(rolDto -> usuarioManagementService.canRegisterRole(rolDto, authenticatedRoles))) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You cannot assign roles higher than your own role");
            }

            if (!usuarioManagementService.hasUserManagementPermissions(authenticatedAuthorities)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You don't have permission to register other roles");
            }
        }

        if (usuarioManagementService.isCedulaRegistered(usuarioDto.cedula())) {
            return ResponseEntity.badRequest().body("Cédula is already registered");
        }
        if (usuarioManagementService.isUsernameRegistered(usuarioDto.username())) {
            return ResponseEntity.badRequest().body("Username is already used");
        }
        if (usuarioManagementService.isCorreoRegistered(usuarioDto.correoUsuario())) {
            return ResponseEntity.badRequest().body("Email is already registered");
        }
        if (compromisedPasswordChecker.check(usuarioDto.clave()).isCompromised()) {
            throw new CompromisedPasswordException("The password you provided is compromised. Please use another one");
        }

        Usuario saveUser = usuarioManagementService.createUser(usuarioDto);

        Map<String, Object> response = new HashMap<>();
        response.put("Token", tokenService.generateToken(saveUser));
        response.put("User", saveUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.username(),
                loginDto.password()
        ));
        Map<String, Object> response = new HashMap<>();
        response.put("Token", tokenService.generateToken(authentication));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Object> profile(Authentication authentication) {
        Map<String, Object> response = new HashMap<>();

        response.put("Username", authentication.getName());
        response.put("Authorities", authentication.getAuthorities());
        response.put("User", usuarioManagementService.getUsuario(authentication.getName()));
        return ResponseEntity.ok(response);
    }

}
