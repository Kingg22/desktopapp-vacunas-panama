package com.kingg.api_vacunas_panama.web.controller;

import com.kingg.api_vacunas_panama.persistence.entity.Usuario;
import com.kingg.api_vacunas_panama.service.TokenService;
import com.kingg.api_vacunas_panama.service.UsuarioManagementService;
import com.kingg.api_vacunas_panama.util.RolEnum;
import com.kingg.api_vacunas_panama.web.dto.LoginDto;
import com.kingg.api_vacunas_panama.web.dto.RestoreDto;
import com.kingg.api_vacunas_panama.web.dto.UsuarioDto;
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
        saveUser.setClaveHash("");
        Map<String, Object> response = new HashMap<>();
        response.put("Token", tokenService.generateToken(saveUser));
        response.put("User", saveUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid LoginDto loginDto) {
        Map<String, Object> response = new HashMap<>();
        if (compromisedPasswordChecker.check(loginDto.password()).isCompromised()) {
            response.put("status", 302);
            response.put("message", "The password you provided is compromised. Please reset your password in the given uri");
            response.put("errors", "compromised password");
            response.put("uri", "/vacunacion/account/restore");
            return ResponseEntity.badRequest().body(response);
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.username(),
                loginDto.password()
        ));
        Usuario user = usuarioManagementService.getUsuario(authentication.getName());
        user.setClaveHash("");
        response.put("User", user);
        response.put("Token", tokenService.generateToken(authentication));
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/restore")
    public ResponseEntity<Object> restore(@RequestBody @Valid RestoreDto restoreDto) {
        Usuario user = usuarioManagementService.canRestore(restoreDto.username(), restoreDto.fechaNacimientoUsuario());
        if (user != null && !usuarioManagementService.equalsPassword(user, restoreDto.newPassword()) && !compromisedPasswordChecker.check(restoreDto.newPassword()).isCompromised()) {
            usuarioManagementService.changePassword(user, restoreDto.newPassword());
            return ResponseEntity.ok("Password restored successfully");
        }
        return ResponseEntity.badRequest().body("Failed to restore password. Please verify your new password");
    }

    @GetMapping
    public ResponseEntity<Object> profile(Authentication authentication) {
        Usuario response = usuarioManagementService.getUsuario(authentication.getName());
        response.setClaveHash("");
        return ResponseEntity.ok(response);
    }

}
