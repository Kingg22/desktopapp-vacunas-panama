package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.Fabricante;
import com.kingg.api_vacunas_panama.persistence.repository.FabricanteRepository;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * Service for {@link Fabricante}.
 */
@Service
@RequiredArgsConstructor
public class FabricanteService {
    private final FabricanteRepository fabricanteRepository;

    public Optional<Fabricante> getFabricante(@NotNull UUID id) {
        return fabricanteRepository.findById(id);
    }

    public Optional<Fabricante> getFabricante(@NotNull String licencia) {
        return fabricanteRepository.findByLicencia(licencia);
    }

}
