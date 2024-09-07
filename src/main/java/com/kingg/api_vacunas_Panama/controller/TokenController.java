package com.kingg.api_vacunas_panama.controller;

import com.kingg.api_vacunas_panama.entity.Usuario;
import com.kingg.api_vacunas_panama.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/vacunacion/v1/token", produces = MediaType.APPLICATION_JSON_VALUE)
public class TokenController {
    private final TokenService tokenService;

    @Autowired
    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<String> getToken(Usuario usuario) {
        return ResponseEntity.ok(tokenService.generateToken(usuario));
    }


}
