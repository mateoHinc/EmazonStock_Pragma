package com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.mapper;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Brand;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.entity.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface BrandEntityMapper {

    BrandEntity toEntity(Brand brand);
    Brand toBrand(BrandEntity brandEntity);
    List<Brand> toBrandList(List<BrandEntity> brandEntities);
}
