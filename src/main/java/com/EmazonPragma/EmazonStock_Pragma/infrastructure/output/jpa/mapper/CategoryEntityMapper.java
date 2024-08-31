package com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.mapper;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface CategoryEntityMapper {
    @Mapping(source= "name" , target = "name")
    CategoryEntity toEntity(Category category);
}
