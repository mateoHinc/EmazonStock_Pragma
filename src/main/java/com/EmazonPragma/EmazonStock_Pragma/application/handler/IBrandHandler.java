package com.EmazonPragma.EmazonStock_Pragma.application.handler;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.BrandRequest;
import com.EmazonPragma.EmazonStock_Pragma.application.DTO.BrandResponse;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Brand;

import java.util.List;

public interface IBrandHandler {

    BrandResponse saveBrand(BrandRequest brandRequest);

    List<BrandResponse> listBrands(String sortBy, boolean ascending, int page, int size);

    Brand getBrand(Long id);
}
