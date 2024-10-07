package com.EmazonPragma.EmazonStock_Pragma.application.mapper;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.BrandRequest;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface BrandRequestMapper {
    Brand toBrand(BrandRequest brandRequest);
}
