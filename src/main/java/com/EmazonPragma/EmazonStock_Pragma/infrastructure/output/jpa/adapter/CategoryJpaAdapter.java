package com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.adapter;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;
import com.EmazonPragma.EmazonStock_Pragma.domain.spi.ICategoryPersistencePort;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.exceptions.NotDataFound;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.entity.CategoryEntity;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.mapper.CategoryEntityMapper;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

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

    @Override
    public List<Category> listCategories(String sortBy, boolean ascending, int page, int size) {
        Sort sort = Sort.by(Sort.Direction.fromString(ascending ? "ASC": "DESC"), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll(pageable).getContent();
        if(categoryEntityList.isEmpty()){
            throw new NotDataFound();
        }
        return categoryEntityMapper.toCategoryList(categoryEntityList);
    }
}
