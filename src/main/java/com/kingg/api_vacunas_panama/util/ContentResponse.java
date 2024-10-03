package com.kingg.api_vacunas_panama.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContentResponse {
    Map<String, Object> data = new LinkedHashMap<>();
    MultiValueMap<String, Object> errors = new LinkedMultiValueMap<>();
    MultiValueMap<String, Object> warnings = new LinkedMultiValueMap<>();

    public ContentResponse(MultiValueMap<String, Object> errors, MultiValueMap<String, Object> warnings) {
        this.errors = errors;
        this.warnings = warnings;
    }

    public ContentResponse(MultiValueMap<String, Object> errors) {
        this.errors = errors;
    }

    public void addData(String key, Object value) {
        this.data.put(key, value);
    }

    public void addError(String code, Object message) {
        this.errors.add(code, message);
    }

    public void addWarning(String code, Object message) {
        this.errors.add(code, message);
    }

    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

}
