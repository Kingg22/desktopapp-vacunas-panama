package com.kingg.api_vacunas_panama.service;

import com.kingg.api_vacunas_panama.persistence.entity.Direccion;
import com.kingg.api_vacunas_panama.persistence.entity.Distrito;
import com.kingg.api_vacunas_panama.persistence.entity.Provincia;
import com.kingg.api_vacunas_panama.persistence.repository.DireccionRepository;
import com.kingg.api_vacunas_panama.persistence.repository.DistritoRepository;
import com.kingg.api_vacunas_panama.persistence.repository.ProvinciaRepository;
import com.kingg.api_vacunas_panama.util.ContentResponse;
import com.kingg.api_vacunas_panama.util.ResponseCode;
import com.kingg.api_vacunas_panama.util.mapper.DireccionMapper;
import com.kingg.api_vacunas_panama.web.dto.DireccionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service for {@link Direccion}, {@link Distrito} and {@link Provincia}.
 */
@Service
@RequiredArgsConstructor
public class DireccionService {
    private final DireccionMapper mapper;
    private final DireccionRepository direccionRepository;
    private final DistritoRepository distritoRepository;
    private final ProvinciaRepository provinciaRepository;

    public void createDireccion(ContentResponse contentResponse, DireccionDto direccionDto) {
        Direccion direccion = mapper.direccionDtoToEntity(direccionDto);
        if (getDistrito(direccion.getDistrito().getId()) == null) {
            contentResponse.addWarning(ResponseCode.NOT_FOUND.toString(), "distrito not found, set default distrito");

        }
    }

    public Distrito getDistrito(Short id) {
        return distritoRepository.findById(id).orElse(null);
    }

    public Distrito getDistrito(String nombre) {
        return distritoRepository.findByNombre(nombre).orElse(null);
    }

}
