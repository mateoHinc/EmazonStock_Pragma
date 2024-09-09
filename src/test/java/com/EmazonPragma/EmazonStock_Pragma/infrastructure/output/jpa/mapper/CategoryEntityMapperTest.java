package com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.mapper;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.entity.CategoryEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

class CategoryEntityMapperTest {

    private final CategoryEntityMapper categoryEntityMapper = Mappers.getMapper(CategoryEntityMapper.class);

    @Test
    void toEntity() {
        Category category = new Category();
        category.setName("Audio");
        category.setDescription("Equipos de sonido y música");

        CategoryEntity categoryEntity = categoryEntityMapper.toEntity(category);

        assertEquals("Audio", categoryEntity.getName());
        assertEquals("Equipos de sonido y música", categoryEntity.getDescription());
    }

}