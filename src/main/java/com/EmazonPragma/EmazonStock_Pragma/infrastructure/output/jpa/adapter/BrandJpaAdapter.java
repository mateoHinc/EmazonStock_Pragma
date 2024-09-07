package com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.adapter;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Brand;
import com.EmazonPragma.EmazonStock_Pragma.domain.spi.IBrandPersistencePort;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.mapper.BrandEntityMapper;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.repository.IBrandRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class BrandJpaAdapter implements IBrandPersistencePort {

    private final IBrandRepository brandRepository;
    private final BrandEntityMapper brandEntityMapper;

    @Override
    public Brand saveBrand(Brand brand) {
        if(brandRepository.existsByName(brand.getName())){
            throw new IllegalArgumentException("A brand with this name already exists in the database.");
        }
        return brandEntityMapper.toBrand(brandRepository.save(brandEntityMapper.toEntity(brand)));
    }

    @Override
    public List<Brand> listBrands() {
        return List.of();
    }
}
