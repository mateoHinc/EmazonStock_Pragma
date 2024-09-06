package com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.adapter;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;
import com.EmazonPragma.EmazonStock_Pragma.domain.spi.ICategoryPersistencePort;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.mapper.CategoryEntityMapper;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryJpaAdapter implements ICategoryPersistencePort {

    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void saveCategory(Category category) {
        if(categoryRepository.existsByName(category.getName())){
            throw new IllegalArgumentException("A category with this name already exists in the database.");
        }
        categoryRepository.save(categoryEntityMapper.toEntity(category));
    }
}
