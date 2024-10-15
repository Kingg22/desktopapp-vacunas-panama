package com.kingg.api_vacunas_panama.events;

import com.kingg.api_vacunas_panama.service.UsuarioTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {
    private final UsuarioTransactionService usuarioTransactionService;

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        if (event.getAuthentication() != null && event.getAuthentication().isAuthenticated()) {
            String userId = event.getAuthentication().getName();
            usuarioTransactionService.updateLastUsed(UUID.fromString(userId));
        }
    }

}
