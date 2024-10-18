package com.kingg.api_vacunas_panama.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Generic interface for the response format of the API
 * Extends {@link Serializable} to ensure serialization of object.
 * Designed for error codes or status or warnings are for the programmer (client) and the messages for the end user.
 *
 * @param <S> tipo de dato para los códigos o key (e.g. status code, error code).
 * @param <T> tipo de dato para mensajes complejos (e.g. status message, data value). Recommend using serializable data type
 */
public interface IApiResponse<S, T> extends Serializable {
    void addStatusCode(HttpStatus message);

    void addStatus(S key, T value);

    void addStatus(S key, String message);

    void addStatus(String message);

    void addMetadata(String key, T value);

    void addData(String key, T value);

    void addData(Map<S, T> data);

    void addError(S code, String message);

    void addError(ApiResponseCode code, String message);

    /**
     * Add an error with a specific property.
     *
     * @param code     Code of the error.
     * @param property Property associated with the error.
     * @param message  Useful message for the user/client.
     */
    void addError(S code, String property, String message);

    void addError(ApiResponseCode code, String property, String message);

    void addErrors(List<?> errors);

    void addWarning(S code, String message);

    void addWarning(ApiResponseCode code, String message);

    void addWarning(ApiResponseCode apiResponseCode, String property, String message);

    void addWarnings(List<?> warnings);

    @JsonIgnore
    int getStatusCode();

    boolean hasErrors();

    boolean hasWarnings();

}
