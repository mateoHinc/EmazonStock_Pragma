package com.EmazonPragma.EmazonStock_Pragma.application.handler;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.BrandRequest;
import com.EmazonPragma.EmazonStock_Pragma.application.DTO.BrandResponse;

import java.util.List;

public interface IBrandHandler {

    BrandResponse saveBrand(BrandRequest brandRequest);

//    List<BrandResponse> listBrands();

}
