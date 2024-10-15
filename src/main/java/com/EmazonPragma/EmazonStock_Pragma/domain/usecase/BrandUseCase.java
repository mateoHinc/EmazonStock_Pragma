package com.EmazonPragma.EmazonStock_Pragma.domain.usecase;

import com.EmazonPragma.EmazonStock_Pragma.domain.api.IBrandServicePort;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Brand;
import com.EmazonPragma.EmazonStock_Pragma.domain.spi.IBrandPersistencePort;

import java.util.List;

public class BrandUseCase implements IBrandServicePort {

    private final IBrandPersistencePort brandPersistencePort;

    public BrandUseCase(IBrandPersistencePort brandPersistencePort) {
        this.brandPersistencePort = brandPersistencePort;
    }

    @Override
    public Brand saveBrand(Brand brand) {
        return brandPersistencePort.saveBrand(brand);
    }

    @Override
    public List<Brand> listBrands(String sortBy, boolean ascending, int page, int size) {
        return brandPersistencePort.listBrands(sortBy,ascending,page,size);
    }

    @Override
    public Brand getBrand(Long id) {
        return brandPersistencePort.getBrand(id);
    }

}
