package com.kingg.api_vacunas_panama.services;

import com.kingg.api_vacunas_panama.entity.Permiso;
import com.kingg.api_vacunas_panama.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TokenService {
    private final JwtEncoder jwtEncoder;
    @Value("${security.jwt.issuer}")
    private String issuer;
    @Value("${security.jwt.expiration-time}")
    private Integer expirationTime;

    @Autowired
    public TokenService(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public String generateToken(Usuario usuario) {
        Collection<String> rolesPermisos = usuario.getRoles().stream()
                    .flatMap(role -> Stream.concat(
                            Stream.of("ROLE_" + role.getNombreRol().toUpperCase()),
                            role.getPermisos().stream().map(Permiso::getNombrePermiso))
                    ).toList();

        return createToken(usuario.getCedula(), rolesPermisos);
    }

    public String generateToken(Authentication authentication) {
        Collection<String> rolesPermisos = authentication.getAuthorities().stream()
                                        .map(GrantedAuthority::getAuthority)
                                        .toList();
        return createToken(authentication.getName(), rolesPermisos);
    }

    public String getSubject(Jwt token) {
        return token.getSubject();
    }

    public String getSpecificClaim(Jwt token, String claimName) {
        return token.getClaim(claimName);
    }

    public Map<String, Object> getAllClaims(Jwt token) {
        return token.getClaims();
    }

    private String createToken(String subject, Collection<String> rolesPermisos) {
        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer(issuer)
                .issuedAt(now)
                .notBefore(now)
                .expiresAt(now.plusSeconds(expirationTime))
                .subject(subject)
                .claim("scope", rolesPermisos)
                .id(UUID.randomUUID().toString())
                .build();
        JwsHeader header = JwsHeader.with(SignatureAlgorithm.RS256).type("JWT").build();
        return this.jwtEncoder.encode(JwtEncoderParameters.from(header, claims)).getTokenValue();
    }

}
