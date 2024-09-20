package com.EmazonPragma.EmazonStock_Pragma.application.handler;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.ItemRequest;
import com.EmazonPragma.EmazonStock_Pragma.application.mapper.ItemRequestMapper;
import com.EmazonPragma.EmazonStock_Pragma.domain.api.IItemServicePort;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Item;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemHandler implements IItemHandler{

    private final IItemServicePort itemServicePort;
    private final ItemRequestMapper itemRequestMapper;

    @Override
    public void saveItem(ItemRequest itemRequest) {
        Item item = itemRequestMapper.toItem(itemRequest);
        itemServicePort.saveItem(item);
    }

}
