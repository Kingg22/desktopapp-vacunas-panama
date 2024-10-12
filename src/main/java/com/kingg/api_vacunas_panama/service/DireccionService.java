package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.Direccion;
import com.kingg.api_vacunas_panama.persistence.entity.Distrito;
import com.kingg.api_vacunas_panama.persistence.entity.Provincia;
import com.kingg.api_vacunas_panama.persistence.repository.DistritoRepository;
import com.kingg.api_vacunas_panama.persistence.repository.ProvinciaRepository;
import com.kingg.api_vacunas_panama.util.mapper.DireccionMapper;
import com.kingg.api_vacunas_panama.web.dto.DistritoDto;
import com.kingg.api_vacunas_panama.web.dto.ProvinciaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for {@link Direccion}, {@link Distrito} and {@link Provincia}.
 */
@Service
@RequiredArgsConstructor
public class DireccionService {
    private final DireccionMapper mapper;
    private final DistritoRepository distritoRepository;
    private final ProvinciaRepository provinciaRepository;

    List<Distrito> getDistritos() {
        return distritoRepository.findAll();
    }

    @Cacheable(cacheNames = "massive", key = "'distritosDto'")
    public List<DistritoDto> getDistritosDto() {
        return mapper.distritoListToDto(getDistritos());
    }

    List<Provincia> getProvincias() {
        return provinciaRepository.findAll();
    }

    @Cacheable(cacheNames = "massive", key = "'provinciasDto'")
    public List<ProvinciaDto> getProvinciasDto() {
        return mapper.provinciaListToDto(getProvincias());
    }
}
