package com.EmazonPragma.EmazonStock_Pragma.application.handler;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.CategoryRequest;
import com.EmazonPragma.EmazonStock_Pragma.application.DTO.CategoryResponse;

import java.util.List;

public interface ICategoryHandler {
    void saveCategory(CategoryRequest categoryRequest);
    List<CategoryResponse> listCategories(String sortBy, boolean ascending, int page, int size);
}
