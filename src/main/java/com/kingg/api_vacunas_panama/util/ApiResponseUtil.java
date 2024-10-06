package com.kingg.api_vacunas_panama.util;

import io.github.wimdeblauwe.errorhandlingspringbootstarter.ApiErrorResponse;
import io.github.wimdeblauwe.errorhandlingspringbootstarter.ApiFieldError;
import io.github.wimdeblauwe.errorhandlingspringbootstarter.ApiGlobalError;
import io.github.wimdeblauwe.errorhandlingspringbootstarter.ApiParameterError;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.ServletWebRequest;

import java.time.Instant;

@Slf4j
public class ApiResponseUtil {

    private ApiResponseUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static void setMetadata(IApiResponse<?, Object> apiResponse, ServletWebRequest servletWebRequest) {
        log.debug("servletWebRequest: {}", servletWebRequest);
        log.debug("locale: {}", servletWebRequest.getLocale());
        apiResponse.addMetadata("path", servletWebRequest.getRequest().getRequestURI());
        apiResponse.addMetadata("timestamp", Instant.now().toString());
    }

    public static ResponseEntity<Object> sendResponse(IApiResponse<?, Object> apiResponse, ServletWebRequest webRequest) {
        setMetadata(apiResponse, webRequest);
        log.debug(apiResponse.toString());
        return ResponseEntity.status(apiResponse.getStatusCode()).body(apiResponse);
    }

    public static IApiResponse<?, Object> transformApiErrorResponse(ApiErrorResponse apiErrorResponse, Object request) {
        IApiResponse<String, Object> response = new ApiResponse();
        response.addStatus("code", apiErrorResponse.getHttpStatus().value());
        if (!apiErrorResponse.getMessage().contains("Dto") && !apiErrorResponse.getMessage().contains("api_vacunas_panama")) {
            response.addError(apiErrorResponse.getCode(), apiErrorResponse.getMessage());
        } else {
            response.addError(apiErrorResponse.getCode(), "Intente nuevamente");
        }
        for (ApiFieldError fieldError : apiErrorResponse.getFieldErrors()) {
            response.addError(
                    fieldError.getCode(),
                    fieldError.getProperty(),
                    fieldError.getMessage()
            );
        }
        for (ApiGlobalError globalError : apiErrorResponse.getGlobalErrors()) {
            response.addError(
                    globalError.getCode(),
                    globalError.getMessage()
            );
        }
        for (ApiParameterError parameterError : apiErrorResponse.getParameterErrors()) {
            response.addError(
                    parameterError.getCode(),
                    parameterError.getParameter(),
                    parameterError.getMessage()
            );
        }
        switch (request) {
            case ServletWebRequest servletWebRequest -> setMetadata(response, servletWebRequest);
            case HttpServletRequest httpServletRequest ->
                    setMetadata(response, new ServletWebRequest(httpServletRequest));
            default -> response.addMetadata("timestamp", Instant.now().toString());
        }
        log.debug(response.toString());
        log.debug("ErrorResponse(code: {}, message: {}, properties {})",apiErrorResponse.getCode(), apiErrorResponse.getMessage(), apiErrorResponse.getProperties());
        return response;
    }

}
