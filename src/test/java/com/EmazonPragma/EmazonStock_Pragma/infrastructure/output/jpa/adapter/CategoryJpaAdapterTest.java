package com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.adapter;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.entity.CategoryEntity;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.mapper.CategoryEntityMapper;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.repository.ICategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CategoryJpaAdapterTest {

    @Mock
    private ICategoryRepository categoryRepository;

    @Mock
    private CategoryEntityMapper categoryEntityMapper;

    @InjectMocks
    private CategoryJpaAdapter categoryJpaAdapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveCategoryWhenCategoryExist_ThrowsException(){
        Category category = new Category();
        category.setName("Audio");

        when(categoryRepository
                .existsByName("Audio"))
                .thenReturn(true);

        assertThrows(IllegalArgumentException.class,
                () -> categoryJpaAdapter.saveCategory(category));

    }

    @Test
    void saveCategoryWhenCategoryDoesNotExist() {
        Category category = new Category();
        category.setName("Audio");

        CategoryEntity categoryEntity = new CategoryEntity();
        when(categoryEntityMapper.toEntity(category)).thenReturn(categoryEntity);
        when(categoryRepository.existsByName("Audio")).thenReturn(false);

        categoryJpaAdapter.saveCategory(category);

        verify(categoryRepository).save(categoryEntity);

    }

}