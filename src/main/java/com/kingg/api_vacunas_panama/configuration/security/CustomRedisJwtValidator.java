package com.kingg.api_vacunas_panama.configuration.security;

import com.kingg.api_vacunas_panama.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;

@RequiredArgsConstructor
public class CustomRedisJwtValidator implements OAuth2TokenValidator<Jwt> {
    private final TokenService tokenService;

    @Override
    public OAuth2TokenValidatorResult validate(Jwt token) {
        String tokenId = token.getId();
        try {
            if (tokenService.isTokenRevoke(tokenId)) {
                return OAuth2TokenValidatorResult.failure(new OAuth2Error("invalid_token", "Token has been revoked", null));
            }
        } catch (IllegalStateException exception) {
            return OAuth2TokenValidatorResult.failure(new OAuth2Error("server_error", "Token validation failed due to server issue", null));
        }
        return OAuth2TokenValidatorResult.success();
    }

}
