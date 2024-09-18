package com.EmazonPragma.EmazonStock_Pragma.domain.spi;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Brand;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;

import java.util.List;

public interface ICategoryPersistencePort {
    void saveCategory(Category category);

    List<Category> listCategories(String sortBy, boolean ascending, int page, int size);

    Category getCategory(Long id);
}
