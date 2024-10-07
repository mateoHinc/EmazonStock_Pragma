package com.EmazonPragma.EmazonStock_Pragma.application.mapper;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.ItemRequest;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Collections;
import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ItemRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "category", target = "category", qualifiedByName = "mapCategoryIds")
    Item toItem(ItemRequest itemRequest);

    @Named(value = "mapCategoryIds")
    default List<Category> mapCategoryIds(List<Long> categories) {
        if(categories == null){
            return Collections.emptyList();
        }
        return categories.stream()
                .map(id -> new Category(id,"name","description"))
                .toList();
    }

}
