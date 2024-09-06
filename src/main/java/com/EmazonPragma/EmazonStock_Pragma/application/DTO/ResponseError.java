package com.EmazonPragma.EmazonStock_Pragma.application.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ResponseError {
    private Map<String, String> errors;
    private int statusCode;

    public void messageError(String key, String message) {
        this.errors.put(key, message);
    }
}
