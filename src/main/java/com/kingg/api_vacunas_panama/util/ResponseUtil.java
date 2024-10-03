package com.kingg.api_vacunas_panama.util;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseUtil {

    private ResponseUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static Map<String, Object> createResponse(Map<String, Object> status, Map<String, Object> data,
                                                     MultiValueMap<String, Object> errors,
                                                     MultiValueMap<String, Object> warnings,
                                                     HttpServletRequest request) {
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
        response.put("meta", setMetadata(request));
        return response;
    }

    public static Map<String, Object> createResponse(Map<String, Object> status,
                                                     ContentResponse contentResponse, HttpServletRequest request) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", status);
        response.put("data", contentResponse.getData());
        response.put("errors", contentResponse.getErrors());
        response.put("warnings", contentResponse.getWarnings());
        response.put("meta", setMetadata(request));
        return response;
    }

    public static Map<String, Object> createResponse(Map<String, Object> status, HttpServletRequest request) {
        Map<String, Object> response = new LinkedHashMap<>();
        ContentResponse contentResponse = new ContentResponse();
        response.put("status", status);
        response.put("data", contentResponse.getData());
        response.put("errors", contentResponse.getErrors());
        response.put("warnings", contentResponse.getWarnings());
        response.put("meta", setMetadata(request));
        return response;
    }

    private static Map<String, Object> setMetadata(HttpServletRequest request) {
        Map<String, Object> metadata = new LinkedHashMap<>();
        metadata.put("path", request.getRequestURI());
        metadata.put("timestamp", Instant.now().toString());
        return metadata;
    }

    public static ResponseEntity<Object> sendResponse(Map<String, Object> status, ContentResponse contentResponse, HttpServletRequest request) {
        return ResponseEntity.status((Integer) status.get("code")).body(ResponseUtil.createResponse(status, contentResponse, request));
    }

}
