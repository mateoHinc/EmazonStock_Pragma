package com.EmazonPragma.EmazonStock_Pragma.domain.usecase;

import com.EmazonPragma.EmazonStock_Pragma.domain.api.IItemServicePort;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Item;
import com.EmazonPragma.EmazonStock_Pragma.domain.spi.IItemPersistencePort;

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

        validateCategory(item.getCategory());

        itemPersistencePort.saveItem(item);
    }

    private void validateCategory(List<Category> category) {
        if(category == null || category.isEmpty() || category.size() > 3){
            throw new IllegalArgumentException("El artículo debe tener entre 1 y 3 categorías.");
        }

        Set<Long> categoryIds = category.stream().map(Category::getId).collect(Collectors.toSet());

        if(categoryIds.size() != category.size()) {
            throw new IllegalArgumentException("Las categorías no pueden estar repetidas.");
        }
    }
}
