package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.web.controller.UsuarioController;
import com.kingg.api_vacunas_panama.web.dto.PermisoDto;
import com.kingg.api_vacunas_panama.web.dto.UsuarioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Service for generating JWT tokens.
 * Encodes information from DTOs or entities previously fetched by {@link UsuarioController}.
 * Sets the issuer and time values based on configuration properties.
 * This service handles token creation only, without decoding or verification authorities.
 */
@Service
@RequiredArgsConstructor
public class TokenService {
    private final JwtEncoder jwtEncoder;
    @Value("${security.jwt.issuer}")
    private String issuer;
    @Value("${security.jwt.expiration-time}")
    private Integer expirationTime;

    public String generateToken(UsuarioDto usuario) {
        Collection<String> rolesPermisos = usuario.roles().stream()
                .flatMap(role -> Stream.concat(
                        Stream.of("ROLE_" + role.nombre().toUpperCase()),
                        role.permisos().stream().map(PermisoDto::nombre))
                ).toList();

        return createToken(usuario.id(), rolesPermisos);
    }

    public String generateToken(Authentication authentication) {
        Collection<String> rolesPermisos = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        return createToken(authentication.getName(), rolesPermisos);
    }

    private String createToken(Object subject, Collection<String> rolesPermisos) {
        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer(issuer)
                .issuedAt(now)
                .notBefore(now)
                .expiresAt(now.plusSeconds(expirationTime))
                .subject((String) subject)
                .claim("scope", rolesPermisos)
                .id(UUID.randomUUID().toString())
                .build();
        JwsHeader header = JwsHeader.with(SignatureAlgorithm.RS256).type("JWT").build();
        return this.jwtEncoder.encode(JwtEncoderParameters.from(header, claims)).getTokenValue();
    }

}
