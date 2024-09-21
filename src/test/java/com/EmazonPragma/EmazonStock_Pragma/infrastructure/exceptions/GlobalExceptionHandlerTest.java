package com.EmazonPragma.EmazonStock_Pragma.infrastructure.exceptions;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.ResponseError;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class GlobalExceptionHandlerTest {

    @Test
    void handleConflict() {
        GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();
        IllegalArgumentException argumentException = new IllegalArgumentException("Conflict error");

        ResponseEntity<ResponseError> errorResponseEntity = globalExceptionHandler.handleConflict(argumentException);

        assertEquals(HttpStatus.CONFLICT, errorResponseEntity.getStatusCode());
        assertEquals(409, errorResponseEntity.getBody().getStatusCode());
        assertEquals("Conflict error", errorResponseEntity.getBody().getErrors().get("description"));
    }

}