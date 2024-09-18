package com.EmazonPragma.EmazonStock_Pragma.application.handler;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.BrandResponse;
import com.EmazonPragma.EmazonStock_Pragma.application.DTO.CategoryResponse;
import com.EmazonPragma.EmazonStock_Pragma.application.DTO.ItemRequest;
import com.EmazonPragma.EmazonStock_Pragma.application.DTO.ItemResponse;
import com.EmazonPragma.EmazonStock_Pragma.application.mapper.BrandResponseMapper;
import com.EmazonPragma.EmazonStock_Pragma.application.mapper.CategoryResponseMapper;
import com.EmazonPragma.EmazonStock_Pragma.application.mapper.ItemRequestMapper;
import com.EmazonPragma.EmazonStock_Pragma.application.mapper.ItemResponseMapper;
import com.EmazonPragma.EmazonStock_Pragma.domain.api.IBrandServicePort;
import com.EmazonPragma.EmazonStock_Pragma.domain.api.ICategoryServicePort;
import com.EmazonPragma.EmazonStock_Pragma.domain.api.IItemServicePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemHandler implements IItemHandler{

    private final IItemServicePort itemServicePort;
    private final ItemRequestMapper itemRequestMapper;
    private final ItemResponseMapper itemResponseMapper;
    private final ICategoryServicePort categoryServicePort;
    private final CategoryResponseMapper categoryResponseMapper;
    private final IBrandServicePort brandServicePort;
    private final BrandResponseMapper brandResponseMapper;

    @Override
    public ItemResponse saveItem(ItemRequest itemRequest) {
        BrandResponse brandResponse = brandResponseMapper.toResponse(brandServicePort.getBrand(itemRequest.getBrand().getId()));
        CategoryResponse categoryResponse = categoryResponseMapper.toResponse(categoryServicePort.getCategory(itemRequest.getCategory().getId()));
        return itemResponseMapper.toResponse(itemServicePort.saveItem(itemRequestMapper.toItem(itemRequest)), categoryResponse, brandResponse);
    }
}
