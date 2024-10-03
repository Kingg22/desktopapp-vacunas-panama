package com.kingg.api_vacunas_panama.web.controller;

import com.kingg.api_vacunas_panama.service.SedeService;
import com.kingg.api_vacunas_panama.service.VacunaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/vacunacion/v1/vaccines/", produces = MediaType.APPLICATION_JSON_VALUE)
public class VacunaController {
    private final VacunaService vacunaService;
    private final SedeService sedeService;

}
