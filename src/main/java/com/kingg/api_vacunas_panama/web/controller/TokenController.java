package com.kingg.api_vacunas_panama.web.controller;

import com.kingg.api_vacunas_panama.service.UsuarioManagementService;
import com.kingg.api_vacunas_panama.util.ApiResponse;
import com.kingg.api_vacunas_panama.util.ApiResponseUtil;
import com.kingg.api_vacunas_panama.util.IApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.Serializable;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/vacunacion/v1/token", produces = MediaType.APPLICATION_JSON_VALUE)
public class TokenController {
    private final RedisTemplate<String, Object> redisTemplate;
    private final UsuarioManagementService usuarioManagementService;

    /**
     * Handles refreshing of tokens.
     * The validation is not performed here as a security filter and OAuth ensures access to this endpoint only if a
     * valid refresh token is provided.
     * The used refresh token is removed from memory.
     *
     * @param jwt     The {@link Jwt} containing user ID.
     * @param request The {@link ServletWebRequest} used for building the response.
     * @return {@link IApiResponse} with new access_token and refresh_token.
     */
    @PostMapping("/refresh")
    public ResponseEntity<IApiResponse<String, Serializable>> refreshToken(@AuthenticationPrincipal Jwt jwt, ServletWebRequest request) {
        IApiResponse<String, Serializable> apiResponse = new ApiResponse();
        String userId = jwt.getSubject();
        String tokenId = jwt.getId();

        String key = "token:refresh:".concat(userId).concat(":").concat(tokenId);
        redisTemplate.delete(key);

        apiResponse.addData(this.usuarioManagementService.generateTokens(UUID.fromString(userId), null));
        apiResponse.addStatusCode(HttpStatus.OK);
        return ApiResponseUtil.sendResponse(apiResponse, request);
    }
}
