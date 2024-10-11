package com.kingg.api_vacunas_panama.web.controller;

import com.kingg.api_vacunas_panama.service.DireccionService;
import com.kingg.api_vacunas_panama.service.SedeService;
import com.kingg.api_vacunas_panama.service.UsuarioManagementService;
import com.kingg.api_vacunas_panama.service.VacunaService;
import com.kingg.api_vacunas_panama.util.ApiResponse;
import com.kingg.api_vacunas_panama.util.ApiResponseUtil;
import com.kingg.api_vacunas_panama.util.IApiResponse;
import com.kingg.api_vacunas_panama.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.Serializable;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/vacunacion/v1/public", produces = MediaType.APPLICATION_JSON_VALUE)
public class PublicResourcesController {
    private final DireccionService direccionService;
    private final SedeService sedeService;
    private final VacunaService vacunaService;
    private final UsuarioManagementService usuarioManagementService;

    @GetMapping("/distritos")
    public ResponseEntity<IApiResponse<String, Serializable>> getDistritos(ServletWebRequest request) {
        IApiResponse<String, Serializable> response = new ApiResponse();
        ArrayList<DistritoDto> distritoDtos = new ArrayList<>(direccionService.getDistritosDto());
        response.addData("distritos", distritoDtos);
        response.addStatusCode(HttpStatus.OK);
        return ApiResponseUtil.sendResponse(response, request);
    }

    @GetMapping("/provincias")
    public ResponseEntity<IApiResponse<String, Serializable>> getProvincias(ServletWebRequest request) {
        IApiResponse<String, Serializable> response = new ApiResponse();
        ArrayList<ProvinciaDto> provinciaDtos = new ArrayList<>(direccionService.getProvinciasDto());
        response.addData("provincias", provinciaDtos);
        response.addStatusCode(HttpStatus.OK);
        return ApiResponseUtil.sendResponse(response, request);
    }

    @GetMapping("/sedes")
    public ResponseEntity<IApiResponse<String, Serializable>> getSedes(ServletWebRequest request) {
        IApiResponse<String, Serializable> response = new ApiResponse();
        ArrayList<UUIDNombreDto> sedesNombreDtos = new ArrayList<>(sedeService.getIdNombreSedes());
        response.addData("sedes", sedesNombreDtos);
        response.addStatusCode(HttpStatus.OK);
        return ApiResponseUtil.sendResponse(response, request);
    }

    @GetMapping("/vacunas")
    public ResponseEntity<IApiResponse<String, Serializable>> getVacunas(ServletWebRequest request) {
        IApiResponse<String, Serializable> response = new ApiResponse();
        ArrayList<VacunaFabricanteDto> vacunaFabricanteDtos = new ArrayList<>(vacunaService.getVacunas());
        response.addData("vacunas", vacunaFabricanteDtos);
        response.addStatusCode(HttpStatus.OK);
        return ApiResponseUtil.sendResponse(response, request);
    }

    @GetMapping("/roles")
    public ResponseEntity<IApiResponse<String, Serializable>> getRoles(ServletWebRequest request) {
        IApiResponse<String, Serializable> response = new ApiResponse();
        ArrayList<IdNombreDto> rolesNombreDtos = new ArrayList<>(usuarioManagementService.getRoles());
        response.addData("roles", rolesNombreDtos);
        response.addStatusCode(HttpStatus.OK);
        return ApiResponseUtil.sendResponse(response, request);
    }

    @GetMapping("/roles/permisos")
    public ResponseEntity<IApiResponse<String, Serializable>> getPermisos(ServletWebRequest request) {
        IApiResponse<String, Serializable> response = new ApiResponse();
        ArrayList<IdNombreDto> permisosNombreDtos = new ArrayList<>(usuarioManagementService.getPermisos());
        response.addData("permisos", permisosNombreDtos);
        response.addStatusCode(HttpStatus.OK);
        return ApiResponseUtil.sendResponse(response, request);
    }

}
