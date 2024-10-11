package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.web.controller.UsuarioController;
import com.kingg.api_vacunas_panama.web.dto.PermisoDto;
import com.kingg.api_vacunas_panama.web.dto.UsuarioDto;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Service for generating JWT tokens.
 * Encodes information from DTOs or entities previously fetched by {@link UsuarioController}.
 * Sets the issuer and time values based on configuration properties.
 * This service handles token creation only, without decoding or verification authorities.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TokenService {
    private final JwtEncoder jwtEncoder;
    @Value("${security.jwt.issuer}")
    private String issuer;
    @Value("${security.jwt.expiration-time}")
    private Integer expirationTime;

    public String generateToken(@NotNull UsuarioDto usuario, UUID uuidPersona, UUID uuidFabricante) {
        Collection<String> rolesPermisos = usuario.roles().stream()
                .flatMap(role -> role.permisos() != null ? Stream.concat(
                        Stream.of("ROLE_" + role.nombre().toUpperCase()),
                        role.permisos().stream().map(PermisoDto::nombre)) : null
                ).toList();
        List<Object> idAdiciones = new ArrayList<>();
        idAdiciones.add(uuidPersona);
        idAdiciones.add(uuidFabricante);
        return this.createToken(usuario.id().toString(), rolesPermisos, idAdiciones);
    }

    private String createToken(String subject, Collection<String> rolesPermisos, @NotNull List<Object> idsAdicionales) {
        Instant now = Instant.now();
        JwtClaimsSet.Builder builder = JwtClaimsSet.builder()
                .issuer(issuer)
                .issuedAt(now)
                .notBefore(now)
                .expiresAt(now.plusSeconds(expirationTime))
                .subject(subject)
                .claim("scope", rolesPermisos)
                .id(UUID.randomUUID().toString());
        if (idsAdicionales.get(0) != null) {
            builder.claim("persona", idsAdicionales.getFirst());
        }
        if (idsAdicionales.get(1) != null) {
            builder.claim("fabricante", idsAdicionales.get(1));
        }
        JwtClaimsSet claims = builder.build();
        JwsHeader header = JwsHeader.with(SignatureAlgorithm.RS256).type("JWT").build();
        log.debug("created a token for: {}, expires at: {}, id_token: {}", subject, claims.getExpiresAt(), claims.getId());
        return this.jwtEncoder.encode(JwtEncoderParameters.from(header, claims)).getTokenValue();
    }

}
