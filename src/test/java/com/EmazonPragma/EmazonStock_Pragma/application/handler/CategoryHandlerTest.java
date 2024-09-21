package com.EmazonPragma.EmazonStock_Pragma.application.handler;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.CategoryRequest;
import com.EmazonPragma.EmazonStock_Pragma.application.mapper.CategoryRequestMapper;
import com.EmazonPragma.EmazonStock_Pragma.domain.api.ICategoryServicePort;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CategoryHandlerTest {

    @Mock
    private ICategoryServicePort categoryServicePort;

    @Mock
    private CategoryRequestMapper categoryRequestMapper;

    @InjectMocks
    private CategoryHandler categoryHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveCategory() {
        CategoryRequest categoryRequest = new CategoryRequest();
        categoryRequest.setName("Audio");
        categoryRequest.setDescription("Equipos de sonido y música");

        Category category = new Category();
        category.setName("Audio");
        category.setDescription("Equipos de sonido y música");

        when(categoryRequestMapper.toCategory(categoryRequest)).thenReturn(category);

        categoryHandler.saveCategory(categoryRequest);

        verify(categoryRequestMapper).toCategory(categoryRequest);
        verify(categoryServicePort).saveCategory(category);
    }

}