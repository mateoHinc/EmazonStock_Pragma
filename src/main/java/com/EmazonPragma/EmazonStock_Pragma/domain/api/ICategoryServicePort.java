package com.EmazonPragma.EmazonStock_Pragma.domain.api;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;

import java.util.List;

public interface ICategoryServicePort {
    void saveCategory(Category category);
    List<Category> listCategories(String sortBy, boolean ascending, int page, int size);
    Category getCategory(Long id);
}
