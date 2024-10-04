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
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
public class ApiResponseUtil {

    private ApiResponseUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static Map<String, Object> setMetadata(ServletWebRequest webRequest) {
        Map<String, Object> metadata = new LinkedHashMap<>();
        log.debug("webRequest: {}", webRequest);
        log.debug("locale: {}", webRequest.getLocale());
        metadata.put("path", webRequest.getRequest().getRequestURI());
        metadata.put("timestamp", Instant.now().toString());
        return metadata;
    }

    public static ResponseEntity<Object> sendResponse(Map<String, Object> status, ApiContentResponse apiContentResponse, ServletWebRequest request) {
        IApiResponse<Map<String, Object>, String, Object> response = new ApiResponse(apiContentResponse);
        response.setStatus(status);
        response.setMetadata(setMetadata(request));
        log.debug(response.toString());
        log.debug(apiContentResponse.toString());
        return ResponseEntity.status((Integer) status.get("code")).body(response);
    }

    public static ResponseEntity<Object> sendResponse(IApiResponse<Map<String, Object>, ?, ?> apiResponse, ServletWebRequest webRequest) {
        apiResponse.setMetadata(setMetadata(webRequest));
        log.debug(apiResponse.toString());
        return ResponseEntity.status((Integer) apiResponse.getStatus().get("code")).body(apiResponse);
    }

    public static IApiResponse<?, ?, ?> transformApiErrorResponse(ApiErrorResponse apiErrorResponse, Object request) {
        IApiResponse<Map<String, Object>, String, Object> response = new ApiResponse();
        Map<String, Object> status = new LinkedHashMap<>();
        status.put("status", apiErrorResponse.getHttpStatus().value());
        if (!apiErrorResponse.getMessage().contains("Dto")) {
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
        response.setStatus(status);
        switch (request) {
            case ServletWebRequest servletWebRequest -> response.setMetadata(setMetadata(servletWebRequest));
            case HttpServletRequest httpServletRequest -> response.setMetadata(setMetadata(new ServletWebRequest(httpServletRequest)));
            default -> response.addMetadata("timestamp", Instant.now().toString());
        }
        log.debug(response.toString());
        log.debug("ErrorResponse(code: {}, message: {}, properties {})",apiErrorResponse.getCode(), apiErrorResponse.getMessage(), apiErrorResponse.getProperties());
        return response;
    }

}
