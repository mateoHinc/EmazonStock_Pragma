package com.EmazonPragma.EmazonStock_Pragma.domain.spi;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;

public interface ICategoryPersistencePort {
    void saveCategory(Category category);
}
