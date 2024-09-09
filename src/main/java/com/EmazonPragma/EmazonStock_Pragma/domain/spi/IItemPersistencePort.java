package com.EmazonPragma.EmazonStock_Pragma.domain.spi;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Item;

public interface IItemPersistencePort {

    Item saveItem(Item item);

}
