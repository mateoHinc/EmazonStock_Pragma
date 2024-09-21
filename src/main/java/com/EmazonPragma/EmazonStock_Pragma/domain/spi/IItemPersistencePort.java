package com.EmazonPragma.EmazonStock_Pragma.domain.spi;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Item;

public interface IItemPersistencePort {

    void saveItem(Item item);
    boolean existByName(String name);

}
