package com.kingg.api_vacunas_panama.web.controller;

import com.kingg.api_vacunas_panama.util.ApiResponseUtil;
import io.github.wimdeblauwe.errorhandlingspringbootstarter.ApiErrorResponse;
import io.github.wimdeblauwe.errorhandlingspringbootstarter.ErrorHandlingFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(annotations = RestController.class)
public class CustomErrorHandlingController {
    private final ErrorHandlingFacade errorHandlingFacade;

    @ExceptionHandler
    public ResponseEntity<Object> handleException(Throwable exception, ServletWebRequest webRequest) {
        ApiErrorResponse errorResponse = errorHandlingFacade.handle(exception);
        return ResponseEntity.status(errorResponse.getHttpStatus()).body(ApiResponseUtil.transformApiErrorResponse(errorResponse, webRequest));
    }
}
