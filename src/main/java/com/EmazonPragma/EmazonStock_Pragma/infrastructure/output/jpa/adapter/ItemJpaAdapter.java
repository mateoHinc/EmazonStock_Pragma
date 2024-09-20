package com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.adapter;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Item;
import com.EmazonPragma.EmazonStock_Pragma.domain.spi.IItemPersistencePort;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.mapper.BrandEntityMapper;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.mapper.CategoryEntityMapper;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.mapper.ItemEntityMapper;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.repository.IBrandRepository;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.repository.ICategoryRepository;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.repository.IItemRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ItemJpaAdapter implements IItemPersistencePort {

    private final IItemRepository itemRepository;
    private final ItemEntityMapper itemEntityMapper;

    @Override
    public void saveItem(Item item) {
        itemRepository.save(itemEntityMapper.toEntity(item));
    }

    @Override
    public boolean existByName(String name) {
        return itemRepository.existsByName(name);
    }
}
