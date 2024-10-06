package com.kingg.api_vacunas_panama.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class ApiResponse extends ApiContentResponse implements IApiResponse<String, Object> {
    private Map<String, Object> status = new LinkedHashMap<>();
    private Map<String, Object> metadata = new LinkedHashMap<>();

    public ApiResponse(ApiContentResponse apiContentResponse) {
        super(apiContentResponse);
    }

    public void addStatusCode(HttpStatus httpStatus) {
        this.status.put("code", httpStatus.value());
    }

    public void addStatus(String key, Object value) {
        this.status.put(key, value);
    }

    public void addStatus(String key, String message) {
        this.status.put(key, message);
    }

    public void addStatus(String message) {
        this.status.put("message", message);
    }

    public void addMetadata(String key, Object value) {
        this.metadata.put(key, value);
    }

    @JsonIgnore
    public int getStatusCode() {
        return Integer.parseInt(this.status.get("code").toString());
    }

}
