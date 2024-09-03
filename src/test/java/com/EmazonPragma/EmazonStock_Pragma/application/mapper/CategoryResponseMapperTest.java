package com.EmazonPragma.EmazonStock_Pragma.application.mapper;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.CategoryResponse;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryResponseMapperTest {

    private CategoryResponseMapper mapper = Mappers.getMapper(CategoryResponseMapper.class);

    @Test
    void toResponse() {
        Category category = new Category();
        category.setName("Audio");
        category.setDescription("Equipos de sonido y música");

        CategoryResponse categoryResponse = mapper.toResponse(category);

        assertEquals(category.getName(), categoryResponse.getName());
        assertEquals(category.getDescription(), categoryResponse.getDescription());
    }

    @Test
    void toResponseList() {
        Category category1 = new Category();
        category1.setName("Audio");
        category1.setDescription("Equipos de sonido y música");

        Category category2 = new Category();
        category2.setName("Deportes");
        category2.setDescription("Equipos de todo los deportes");

        List<Category> categories = Arrays.asList(category1, category2);

        List<CategoryResponse> categoryResponseList = mapper.toResponseList(categories);

        assertEquals(2, categoryResponseList.size());
        assertEquals("Audio", categoryResponseList.get(0).getName());
        assertEquals("Deportes", categoryResponseList.get(1).getName());

    }

}