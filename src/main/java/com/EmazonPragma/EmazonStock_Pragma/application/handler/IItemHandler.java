package com.EmazonPragma.EmazonStock_Pragma.application.handler;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.ItemRequest;
import com.EmazonPragma.EmazonStock_Pragma.application.DTO.ItemResponse;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Item;

import java.util.List;

public interface IItemHandler {

    void saveItem(ItemRequest itemRequest);
    List<ItemResponse> ListItems(String sortBy, boolean ascending, int page, int size);
    Item getItem(Long id);

}
