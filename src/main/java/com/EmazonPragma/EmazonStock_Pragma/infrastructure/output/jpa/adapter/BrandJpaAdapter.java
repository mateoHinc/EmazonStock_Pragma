package com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.adapter;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Brand;
import com.EmazonPragma.EmazonStock_Pragma.domain.spi.IBrandPersistencePort;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.exceptions.NotDataFound;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.entity.BrandEntity;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.mapper.BrandEntityMapper;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.repository.IBrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
    public List<Brand> listBrands(String sortBy, boolean ascending, int page, int size) {
        Sort sort = Sort.by(Sort.Direction.fromString(ascending ? "ASC" : "DESC"), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        List<BrandEntity> brandEntities = brandRepository.findAll(pageable).getContent();
        if(brandEntities.isEmpty()){
            throw new NotDataFound();
        }
        return brandEntityMapper.toBrandList(brandEntities);
    }

}
