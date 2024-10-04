package com.kingg.api_vacunas_panama.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiContentResponse implements Serializable {
    private Map<String, Object> data = new LinkedHashMap<>();
    private List<ApiFailed> errors = new ArrayList<>();
    private List<ApiFailed> warnings = new ArrayList<>();

    public ApiContentResponse(ApiContentResponse apiContentResponse) {
        this.data = apiContentResponse.getData();
        this.errors = apiContentResponse.getErrors();
        this.warnings = apiContentResponse.getWarnings();
    }

    public void addData(String key, Object value) {
        this.data.put(key, value);
    }

    public void addError(String code, String message) {
        this.errors.add(new ApiFailed(code, message));
    }

    public void addError(String code, String property, String message) {
        this.errors.add(new ApiFailed(code, property, message));
    }

    public void addError(String code) {
        this.errors.add(new ApiFailed(code));
    }

    public void addWarning(String code, String message) {
        this.errors.add(new ApiFailed(code, message));
    }

    public boolean hasErrors() {
        return !this.errors.isEmpty();
    }

}
