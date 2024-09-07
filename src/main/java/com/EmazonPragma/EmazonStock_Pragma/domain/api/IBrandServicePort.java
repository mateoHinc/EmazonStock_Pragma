package com.EmazonPragma.EmazonStock_Pragma.domain.api;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Brand;

import java.util.List;

public interface IBrandServicePort {

    Brand saveBrand(Brand brand);
    List<Brand> listBrands();

}
