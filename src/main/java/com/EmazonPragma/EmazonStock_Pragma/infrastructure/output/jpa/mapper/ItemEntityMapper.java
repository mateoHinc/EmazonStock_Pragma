package com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.mapper;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Item;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.entity.BrandEntity;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.entity.ItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ItemEntityMapper {

    ItemEntity toEntity(Item item);
    Item toItem(ItemEntity itemEntity);
    List<Item> toItemList(List<ItemEntity> itemEntityList);

}
