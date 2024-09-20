package com.EmazonPragma.EmazonStock_Pragma.domain.api;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Item;

public interface IItemServicePort {
    void saveItem(Item item);
}
