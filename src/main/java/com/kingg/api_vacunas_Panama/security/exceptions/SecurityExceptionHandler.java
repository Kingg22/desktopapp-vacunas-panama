package com.kingg.api_vacunas_panama.security.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.wimdeblauwe.errorhandlingspringbootstarter.ApiErrorResponseAccessDeniedHandler;
import io.github.wimdeblauwe.errorhandlingspringbootstarter.UnauthorizedEntryPoint;
import io.github.wimdeblauwe.errorhandlingspringbootstarter.mapper.ErrorCodeMapper;
import io.github.wimdeblauwe.errorhandlingspringbootstarter.mapper.ErrorMessageMapper;
import io.github.wimdeblauwe.errorhandlingspringbootstarter.mapper.HttpStatusMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
public class SecurityExceptionHandler {

    @Bean
    public UnauthorizedEntryPoint unauthorizedEntryPoint(HttpStatusMapper httpStatusMapper,
                                                         ErrorCodeMapper errorCodeMapper,
                                                         ErrorMessageMapper errorMessageMapper,
                                                         ObjectMapper objectMapper) {
        return new UnauthorizedEntryPoint(httpStatusMapper, errorCodeMapper, errorMessageMapper, objectMapper);
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler(HttpStatusMapper httpStatusMapper,
                                                   ErrorCodeMapper errorCodeMapper,
                                                   ErrorMessageMapper errorMessageMapper,
                                                   ObjectMapper objectMapper) {
        return new ApiErrorResponseAccessDeniedHandler(objectMapper, httpStatusMapper, errorCodeMapper, errorMessageMapper);
    }
}
