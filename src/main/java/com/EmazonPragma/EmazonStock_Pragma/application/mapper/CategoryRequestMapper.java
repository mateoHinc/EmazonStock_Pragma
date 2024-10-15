package com.EmazonPragma.EmazonStock_Pragma.application.mapper;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.CategoryRequest;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface CategoryRequestMapper {
    Category toCategory(CategoryRequest categoryRequest);
}
