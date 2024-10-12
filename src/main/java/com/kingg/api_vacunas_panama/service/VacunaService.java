package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.Dosis;
import com.kingg.api_vacunas_panama.persistence.entity.PacientesDosis;
import com.kingg.api_vacunas_panama.persistence.entity.Vacuna;
import com.kingg.api_vacunas_panama.persistence.repository.VacunaRepository;
import com.kingg.api_vacunas_panama.web.dto.VacunaFabricanteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for {@link Vacuna}, {@link Dosis} and {@link PacientesDosis}.
 */
@Service
@RequiredArgsConstructor
public class VacunaService {
    private final VacunaRepository vacunaRepository;

    @Cacheable(cacheNames = "huge", key = "'vacunas'")
    public List<VacunaFabricanteDto> getVacunas() {
        return vacunaRepository.findAllIdAndNombreAndFabricante();
    }

}
