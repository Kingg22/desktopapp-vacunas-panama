package com.kingg.api_vacunas_panama.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseUtil {

    private ResponseUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static Map<String, Object> createResponse(Map<String, Object> status, Map<String, Object> data, MultiValueMap<String, Object> errors, MultiValueMap<String, Object> warnings, HttpServletRequest request) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", status);
        response.put("data", data);
        if (errors == null) {
            errors = new LinkedMultiValueMap<>();
        }
        response.put("errors", errors);
        if (warnings == null) {
            warnings = new LinkedMultiValueMap<>();
        }
        response.put("warnings", warnings);
        Map<String, Object> metadata = new LinkedHashMap<>();
        metadata.put("path", request.getRequestURI());
        metadata.put("timestamp", Instant.now().toString());

        response.put("meta", metadata);
        return response;
    }

}
