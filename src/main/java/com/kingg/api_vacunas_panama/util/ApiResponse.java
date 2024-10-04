package com.kingg.api_vacunas_panama.util;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder({"status", "data", "errors", "warnings", "metadata"})
public class ApiResponse extends ApiContentResponse implements IApiResponse<Map<String, Object>, String, Object> {
    private Map<String, Object> status = new LinkedHashMap<>();
    private Map<String, Object> metadata = new LinkedHashMap<>();

    public ApiResponse(ApiContentResponse apiContentResponse) {
        super(apiContentResponse);
    }

    public void addStatus(String code, HttpStatus httpStatus) {
        this.status.put(code, httpStatus.value());
    }

    public void addMetadata(String key, Object value) {
        this.metadata.put(key, value);
    }

}
