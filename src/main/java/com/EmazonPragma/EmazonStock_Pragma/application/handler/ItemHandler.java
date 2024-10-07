package com.EmazonPragma.EmazonStock_Pragma.application.handler;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.ItemRequest;
import com.EmazonPragma.EmazonStock_Pragma.application.DTO.ItemResponse;
import com.EmazonPragma.EmazonStock_Pragma.application.mapper.ItemRequestMapper;
import com.EmazonPragma.EmazonStock_Pragma.application.mapper.ItemResponseMapper;
import com.EmazonPragma.EmazonStock_Pragma.domain.api.IItemServicePort;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Item;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemHandler implements IItemHandler{

    private final IItemServicePort itemServicePort;
    private final ItemRequestMapper itemRequestMapper;
    private final ItemResponseMapper itemResponseMapper;

    @Override
    public void saveItem(ItemRequest itemRequest) {
        Item item = itemRequestMapper.toItem(itemRequest);
        itemServicePort.saveItem(item);
    }

    @Override
    public List<ItemResponse> ListItems(String sortBy, boolean ascending, int page, int size) {
        return itemResponseMapper.toResponseList(itemServicePort.listItems(sortBy, ascending, page, size));
    }

    @Override
    public Item getItem(Long id) {
        return itemServicePort.getItem(id);
    }

}
