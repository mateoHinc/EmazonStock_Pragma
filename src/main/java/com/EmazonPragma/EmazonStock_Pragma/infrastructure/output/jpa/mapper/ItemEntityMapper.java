package com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.mapper;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Item;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.entity.BrandEntity;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.entity.ItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ItemEntityMapper {

    @Mapping(source = "idBrand", target = "idBrand")
    @Mapping(source = "category", target = "category")
    ItemEntity toEntity(Item item);

    @Mapping(source = "idBrand", target = "idBrand")
    @Mapping(source = "category", target = "category")
    Item toItem(ItemEntity itemEntity);

    // Método personalizado para mapear de Long a BrandEntity
    default BrandEntity map(Long id) {
        if (id == null) {
            return null;
        }
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setId(id);
        return brandEntity;
    }

    //Método personalizado para mapear de BrandEntity a Long
    default Long map(BrandEntity brandEntity) {
        return brandEntity == null ? null : brandEntity.getId();
    }

}
