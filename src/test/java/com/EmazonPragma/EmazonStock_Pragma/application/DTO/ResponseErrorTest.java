package com.EmazonPragma.EmazonStock_Pragma.application.DTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ResponseErrorTest {

    private ResponseError responseError;

    @BeforeEach
    void setUp() {
        responseError = new ResponseError();
        responseError.setErrors(new HashMap<>());
    }

    @Test
    void messageError() {
        responseError.messageError("nombre","El nombre es obligatorio");

        assertEquals("El nombre es obligatorio", responseError.getErrors().get("nombre"));
    }

}