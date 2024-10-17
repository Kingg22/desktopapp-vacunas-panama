package com.kingg.api_vacunas_panama.web.controller;

import com.kingg.api_vacunas_panama.service.PacienteService;
import com.kingg.api_vacunas_panama.service.UsuarioManagementService;
import com.kingg.api_vacunas_panama.util.*;
import com.kingg.api_vacunas_panama.web.dto.PacienteDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.Serializable;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/vacunacion/v1/bulk", produces = MediaType.APPLICATION_JSON_VALUE)
public class BulkController {
    private final UsuarioManagementService usuarioManagementService;
    private final PacienteService pacienteService;

    @PostMapping("/create/paciente-usuario")
    public ResponseEntity<IApiResponse<String, Serializable>> createPacienteUsuario(@RequestBody @Valid PacienteDto pacienteDto,
                                                                                    ServletWebRequest request) {
        IApiResponse<String, Serializable> apiResponse = new ApiResponse();
        if (pacienteDto.getUsuario() == null) {
            apiResponse.addError(ApiResponseCode.MISSING_INFORMATION, "Esta función necesita el usuario para el paciente");
            apiResponse.addStatusCode(HttpStatus.BAD_REQUEST);
        }
        if ((pacienteDto.getUsuario().roles().stream().anyMatch(rolDto -> rolDto.id() != null && !RolesEnum.getByPriority(rolDto.id()).equals(RolesEnum.PACIENTE))) ||
        (pacienteDto.getUsuario().roles().stream().anyMatch(rolDto -> rolDto.nombre() != null && !rolDto.nombre().isBlank() && !rolDto.nombre().equalsIgnoreCase("Paciente")))) {
            apiResponse.addError(ApiResponseCode.VALIDATION_FAILED, "Esta función es solo para pacientes, utilice otra operación");
        }
        if (pacienteDto.getSexo().toString().equalsIgnoreCase("X")) {
            apiResponse.addWarning(ApiResponseCode.DEPRECATION_WARNING, "Pacientes no deben tener sexo no definido. Reglas de vacunación no se podrán aplicar");
        }
        if (pacienteDto.getDireccion().id() == null) {
            apiResponse.addWarning(ApiResponseCode.NON_IDEMPOTENCE, "Debe trabajar con ID");
        }

        if (!apiResponse.hasErrors()) {
            try {
                PacienteDto paciente = this.pacienteService.createPaciente(pacienteDto);
                this.usuarioManagementService.createUser(pacienteDto.getUsuario());

                apiResponse.addData("paciente", this.pacienteService.getPacienteDtoById(paciente.getId()));
                apiResponse.addStatusCode(HttpStatus.CREATED);
            } catch (RuntimeException exception) {
                log.error("Error en createPacienteUsuario: ".concat(exception.getMessage()), exception);
                apiResponse.addError("BAD_REQUEST", exception.getMessage());
                apiResponse.addStatusCode(HttpStatus.BAD_REQUEST);
            }
        }
        return ApiResponseUtil.sendResponse(apiResponse, request);
    }

}
