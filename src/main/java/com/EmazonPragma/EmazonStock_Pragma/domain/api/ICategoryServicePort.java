package com.EmazonPragma.EmazonStock_Pragma.domain.api;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;

public interface ICategoryServicePort {
    void saveCategory(Category category);
}
