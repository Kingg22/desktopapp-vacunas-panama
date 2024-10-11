package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.Sede;
import com.kingg.api_vacunas_panama.persistence.repository.SedeRepository;
import com.kingg.api_vacunas_panama.web.dto.UUIDNombreDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for {@link Sede}.
 */
@Service
@RequiredArgsConstructor
public class SedeService {
    private final SedeRepository sedeRepository;

    public List<UUIDNombreDto> getIdNombreSedes() {
        return sedeRepository.findAllIdAndNombre();
    }
}
