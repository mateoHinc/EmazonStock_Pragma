package com.EmazonPragma.EmazonStock_Pragma.application.mapper;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.BrandResponse;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface BrandResponseMapper {

    BrandResponse toResponse(Brand brand);

    default List<BrandResponse> toReponseList(List<Brand> brandList) {
        return brandList
                .stream()
                .map(brand -> {
                    BrandResponse brandResponse = new BrandResponse();
                    brandResponse.setId(brand.getId());
                    brandResponse.setName(brand.getName());
                    brandResponse.setDescription(brand.getDescription());
                    return brandResponse;
                }).toList();
    }
}
