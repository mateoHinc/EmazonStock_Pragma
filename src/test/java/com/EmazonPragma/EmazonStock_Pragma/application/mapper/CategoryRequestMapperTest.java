package com.EmazonPragma.EmazonStock_Pragma.application.mapper;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.CategoryRequest;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryRequestMapperTest {

    private CategoryRequestMapper mapper = Mappers.getMapper(CategoryRequestMapper.class);

    @Test
    void toCategory(){
        CategoryRequest categoryRequest = new CategoryRequest();
        categoryRequest.setName("Audio");
        categoryRequest.setDescription("Equipos de sonido y música");

        Category category = mapper.toCategory(categoryRequest);

        assertEquals(categoryRequest.getName(), category.getName());
        assertEquals(categoryRequest.getDescription(), category.getDescription());
    }


}