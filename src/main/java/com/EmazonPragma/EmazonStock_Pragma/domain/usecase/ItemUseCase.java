package com.EmazonPragma.EmazonStock_Pragma.domain.usecase;

import com.EmazonPragma.EmazonStock_Pragma.domain.api.IItemServicePort;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Item;
import com.EmazonPragma.EmazonStock_Pragma.domain.spi.IItemPersistencePort;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.exceptions.DuplicateCategoriesException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ItemUseCase implements IItemServicePort {

    private final IItemPersistencePort itemPersistencePort;

    public ItemUseCase(IItemPersistencePort itemPersistencePort) {
        this.itemPersistencePort = itemPersistencePort;
    }

    @Override
    public void saveItem(Item item) {
        Set<Long> uniqueCategoryIds = new HashSet<>();

        for (Category category : item.getCategory()) {
            if(!uniqueCategoryIds.add(category.getId())) {
                throw new DuplicateCategoriesException("No puede tener categorias duplicadas en el articulo");
            }
        }

        itemPersistencePort.saveItem(item);
    }

}
