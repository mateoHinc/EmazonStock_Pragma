package com.EmazonPragma.EmazonStock_Pragma.application.handler;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.CategoryRequest;
import com.EmazonPragma.EmazonStock_Pragma.application.mapper.CategoryRequestMapper;
import com.EmazonPragma.EmazonStock_Pragma.application.mapper.CategoryResponseMapper;
import com.EmazonPragma.EmazonStock_Pragma.domain.api.ICategoryServicePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryHandler implements ICategoryHandler{

    private final ICategoryServicePort categoryServicePort;
    private final CategoryRequestMapper categoryRequestMapper;
    private final CategoryResponseMapper categoryResponseMapper;

    @Override
    public void saveCategory(CategoryRequest categoryRequest) {
        categoryServicePort.saveCategory(categoryRequestMapper.toCategory(categoryRequest));
    }
}
