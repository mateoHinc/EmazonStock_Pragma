package com.EmazonPragma.EmazonStock_Pragma.application.handler;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.CategoryRequest;
import com.EmazonPragma.EmazonStock_Pragma.application.DTO.CategoryResponse;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;

import java.util.List;

public interface ICategoryHandler {
    void saveCategory(CategoryRequest categoryRequest);
    List<CategoryResponse> listCategories(String sortBy, boolean ascending, int page, int size);
    Category getCategory(Long id);
}
