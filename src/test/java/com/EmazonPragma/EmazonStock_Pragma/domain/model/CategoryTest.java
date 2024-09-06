package com.EmazonPragma.EmazonStock_Pragma.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void testGettersAndSetters() {
        Category category = new Category();
        category.setId(1L);
        category.setName("Audio");
        category.setDescription("Equipos de sonido y música");

        Long id = category.getId();
        String name = category.getName();
        String description = category.getDescription();

        assertEquals(1L, id,"El Id debería ser 1");
        assertEquals("Audio", name, "El nombre debería ser 'Audio'");
        assertEquals("Equipos de sonido y música", description, "La descripción debería ser 'Equipos de sonido y música'");
    }

}