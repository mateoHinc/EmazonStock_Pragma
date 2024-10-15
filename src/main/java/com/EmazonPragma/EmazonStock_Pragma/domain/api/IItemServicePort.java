package com.EmazonPragma.EmazonStock_Pragma.domain.api;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Item;

import java.util.List;

public interface IItemServicePort {
    void saveItem(Item item);
    List<Item> listItems(String sortBy, boolean ascending, int page, int size);
    Item getItem(Long id);
}
