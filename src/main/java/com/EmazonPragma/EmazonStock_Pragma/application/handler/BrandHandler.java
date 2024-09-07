package com.EmazonPragma.EmazonStock_Pragma.application.handler;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.BrandRequest;
import com.EmazonPragma.EmazonStock_Pragma.application.DTO.BrandResponse;
import com.EmazonPragma.EmazonStock_Pragma.application.mapper.BrandRequestMapper;
import com.EmazonPragma.EmazonStock_Pragma.application.mapper.BrandResponseMapper;
import com.EmazonPragma.EmazonStock_Pragma.domain.api.IBrandServicePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BrandHandler implements IBrandHandler {

    private final IBrandServicePort brandServicePort;
    private final BrandRequestMapper brandRequestMapper;
    private final BrandResponseMapper brandResponseMapper;

    @Override
    public BrandResponse saveBrand(BrandRequest brandRequest) {
        return brandResponseMapper.toResponse(brandServicePort.saveBrand(brandRequestMapper.toBrand(brandRequest)));
    }

    @Override
    public List<BrandResponse> listBrands() {
        return List.of();
    }
}
