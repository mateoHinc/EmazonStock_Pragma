package com.EmazonPragma.EmazonStock_Pragma.application.DTO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryResponseTest {
    @Test
    void testGettersAndSetters() {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setName("Audio");
        categoryResponse.setDescription("Equipos de sonido y música");

        String name = categoryResponse.getName();
        String description = categoryResponse.getDescription();

        assertEquals("Audio", name, "El nombre de la categoría debería ser 'Audio'");
        assertEquals("Equipos de sonido y música",description, "La descripción debería ser 'Equipos de sonido y música'");
    }

}