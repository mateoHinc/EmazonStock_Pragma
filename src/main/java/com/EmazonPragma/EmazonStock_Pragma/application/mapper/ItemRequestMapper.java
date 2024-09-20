package com.EmazonPragma.EmazonStock_Pragma.application.mapper;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.ItemRequest;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ItemRequestMapper {

    Item toItem(ItemRequest itemRequest);

}
