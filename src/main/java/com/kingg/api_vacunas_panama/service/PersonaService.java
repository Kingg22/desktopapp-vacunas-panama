package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.Persona;
import com.kingg.api_vacunas_panama.persistence.repository.PersonaRepository;
import com.kingg.api_vacunas_panama.util.FormatCedulaUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Service for {@link Persona}.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PersonaService {
    private final PersonaRepository personaRepository;

    public Optional<Persona> getPersona(String identifier) {
        String cedula = null;
        try {
            cedula = FormatCedulaUtil.formatCedula(identifier);
        } catch (IllegalArgumentException argumentException) {
            log.info("identifier to get persona is not a cedula");
        }
        return personaRepository.findByCedulaOrPasaporteOrCorreoOrUsername(cedula, identifier, identifier, identifier);
    }

    public Optional<Persona> getPersona(UUID id) {
        return personaRepository.findById(id);
    }

}
