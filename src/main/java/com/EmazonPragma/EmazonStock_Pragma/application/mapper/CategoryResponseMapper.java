package com.EmazonPragma.EmazonStock_Pragma.application.mapper;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.CategoryResponse;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface CategoryResponseMapper {

    CategoryResponse toResponse(Category category);

    default List<CategoryResponse> toResponseList(List<Category> categories) {
        return categories.stream()
                .map(category -> {
                    CategoryResponse categoryResponse = new CategoryResponse();
                    categoryResponse.setName(category.getName());
                    categoryResponse.setDescription(category.getDescription());
                    return categoryResponse;
                }).toList();
    }
}
