package com.EmazonPragma.EmazonStock_Pragma.domain.usecase;

import com.EmazonPragma.EmazonStock_Pragma.domain.api.ICategoryServicePort;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;
import com.EmazonPragma.EmazonStock_Pragma.domain.spi.ICategoryPersistencePort;

import java.util.List;

public class CategoryUseCase implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void saveCategory(Category category) {
        categoryPersistencePort.saveCategory(category);
    }

    @Override
    public List<Category> listCategories(String sortBy, boolean ascending, int page, int size) {
        return categoryPersistencePort.listCategories(sortBy,ascending,page,size);
    }

    @Override
    public Category getCategory(Long id) {
        return categoryPersistencePort.getCategory(id);
    }
}
