package com.EmazonPragma.EmazonStock_Pragma.application.mapper;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.ItemResponse;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Item;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ItemResponseMapper {
    ItemResponse toResponse(Item item);

    // Método personalizado para mapear List<Category> a List<Long>
    default List<Long> mapCategoryListToLongList(List<Category> categories) {
        return categories.stream()
                .map(Category::getId) // Asumiendo que Category tiene un método getId()
                .collect(Collectors.toList());
    }
}
