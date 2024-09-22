package com.kingg.api_vacunas_panama.web.controller;

import com.kingg.api_vacunas_panama.service.SedeService;
import com.kingg.api_vacunas_panama.service.VacunaService;
import com.kingg.api_vacunas_panama.util.ResponseUtil;
import com.kingg.api_vacunas_panama.web.dto.DosisDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/vacunacion/v1/vaccines/", produces = MediaType.APPLICATION_JSON_VALUE)
public class VacunaController {
    private final VacunaService vacunaService;
    private final SedeService sedeService;

    @PostMapping("/insert-dosis")
    public ResponseEntity<Object> insertarDosis(@RequestBody @Valid DosisDto dosisDto, HttpServletRequest request) {
        Map<String, Object> status = new LinkedHashMap<>();
        MultiValueMap<String, Object> errors = new LinkedMultiValueMap<>();
        MultiValueMap<String, Object> warnings = new LinkedMultiValueMap<>();
        UUID vacuna = validateGetId(dosisDto.id_vacuna(), dosisDto.nombre_vacuna(), warnings, errors, "vacuna", vacunaService::getIdVacuna);
        UUID sede = validateGetId(dosisDto.id_sede(), dosisDto.nombre_sede(), warnings, errors, "sede", sedeService::getIdSede);

        if (dosisDto.lote() == null || dosisDto.lote().isBlank()) {
            warnings.add("code", "MISSING_INFORMATION");
            warnings.add("lote", "Procure colocar el lote de la dosis para mayor control del inventario");
        }
        if (errors.isEmpty() && vacunaService.validNumDosis(dosisDto.cedula(), vacuna, dosisDto.numero_dosis())) {
            boolean inserted = vacunaService.insertDosis(dosisDto.cedula(), dosisDto.fecha_aplicacion(), dosisDto.numero_dosis(), vacuna, sede, dosisDto.lote());
            if (inserted) {
                status.put("code", HttpStatus.CREATED.value());
                status.put("message", "Dosis inserted successful");
            } else {
                status.put("code", HttpStatus.BAD_REQUEST.value());
                status.put("message", "Failed dosis insert");
            }
        } else {
            status.put("code", HttpStatus.BAD_REQUEST.value());
            status.put("message", "Validation failed");
        }
        return ResponseEntity.status((Integer) status.get("code")).body(ResponseUtil.createResponse(status, Map.of(), errors, warnings, request));
    }

    private UUID validateGetId(UUID id, String nombre, MultiValueMap<String, Object> warnings,
                               MultiValueMap<String, Object> errors, String tipo, Function<String, UUID> getIdFunction) {
        if (id == null && nombre == null) {
            errors.add(tipo, "El ID o nombre del ".concat(tipo).concat(" es requerido"));
        } else if (id == null) {
            warnings.add("code", "MISSING_IDENTIFIER");
            warnings.add(tipo, "Procure usar id y no nombres de ".concat(tipo));
            id = getIdFunction.apply(nombre);
            if (id == null) {
                errors.add(tipo, "Failed convert nombre to ID");
            }
        } else {
            warnings.add("code", "NAME_IGNORED_FOR_ID");
            warnings.add(tipo, "El nombre del ".concat(tipo).concat("proporcionado fue ignorado para la operación"));
        }
        return id;
    }

}
