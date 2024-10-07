package com.EmazonPragma.EmazonStock_Pragma.domain.usecase;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;
import com.EmazonPragma.EmazonStock_Pragma.domain.spi.ICategoryPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class CategoryUseCaseTest {

    @Mock
    private ICategoryPersistencePort categoryPersistencePort;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveCategory(){
        Category category = new Category();
        category.setName("Audio");
        category.setDescription("Equipos de sonido y musica");

        categoryUseCase.saveCategory(category);

        verify(categoryPersistencePort).saveCategory(category);
    }

}