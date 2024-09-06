package com.EmazonPragma.EmazonStock_Pragma.application.DTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
class CategoryRequestTest {

    private ResponseError responseError;

    @BeforeEach
    void setUp() {
        responseError = new ResponseError();
        responseError.setErrors(new HashMap<>());
    }

    @Test
    void messageError(){
        responseError.messageError("nombre", "El nombre de la categoría es obligatorio");
        assertEquals("El nombre de la categoría es obligatorio", responseError.getErrors().get("nombre"));
    }
  
}