package com.kingg.api_vacunas_panama.web.controller;

import com.kingg.api_vacunas_panama.service.VacunaService;
import com.kingg.api_vacunas_panama.util.ApiResponse;
import com.kingg.api_vacunas_panama.util.ApiResponseCode;
import com.kingg.api_vacunas_panama.util.ApiResponseUtil;
import com.kingg.api_vacunas_panama.util.IApiResponse;
import com.kingg.api_vacunas_panama.web.dto.InsertDosisDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.Serializable;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/vacunacion/v1/vaccines/", produces = MediaType.APPLICATION_JSON_VALUE)
public class VacunaController {
    private final VacunaService vacunaService;

    @PostMapping("/create-dosis")
    public ResponseEntity<IApiResponse<String, Serializable>> createDosis(@RequestBody @Valid InsertDosisDto insertDosisDto,
                                                                          ServletWebRequest servletWebRequest) {
        IApiResponse<String, Serializable> apiResponse = new ApiResponse();
        try {
            apiResponse.addData("dosis", vacunaService.createDosis(insertDosisDto));
            apiResponse.addStatusCode(HttpStatus.CREATED);
        } catch (IllegalStateException | IllegalArgumentException illegalException) {
            apiResponse.addError(ApiResponseCode.VALIDATION_FAILED, illegalException.getMessage());
            apiResponse.addStatusCode(HttpStatus.BAD_REQUEST);
        } catch (NoSuchElementException noSuchElementException) {
            apiResponse.addError(ApiResponseCode.NOT_FOUND, noSuchElementException.getMessage());
            apiResponse.addStatusCode(HttpStatus.NOT_FOUND);
        }
        return ApiResponseUtil.sendResponse(apiResponse, servletWebRequest);
    }

}
