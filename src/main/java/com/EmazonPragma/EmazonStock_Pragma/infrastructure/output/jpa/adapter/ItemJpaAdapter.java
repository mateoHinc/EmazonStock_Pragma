package com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.adapter;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Item;
import com.EmazonPragma.EmazonStock_Pragma.domain.spi.IItemPersistencePort;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.exceptions.CategoryNotFoundException;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.exceptions.ItemAlreadyExistsException;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.exceptions.NotDataFound;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.entity.CategoryEntity;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.entity.ItemEntity;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.mapper.CategoryEntityMapper;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.mapper.ItemEntityMapper;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.repository.ICategoryRepository;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.repository.IItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ItemJpaAdapter implements IItemPersistencePort {

    private final IItemRepository itemRepository;
    private final ItemEntityMapper itemEntityMapper;
    private final ICategoryRepository categoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;

    @Override
    public void saveItem(Item item) {
        if(itemRepository.findByName(item.getName()).isPresent()){
            throw new ItemAlreadyExistsException();
        }else{
            completeCategories(item);
            itemRepository.save(itemEntityMapper.toEntity(item));
        }
    }

    @Override
    public List<Item> listItems(String sortBy, boolean ascending, int page, int size) {
        Sort sort = Sort.by(Sort.Direction.fromString(ascending ? "ASC" : "DESC"), sortBy);
        Pageable pageable = PageRequest.of(page, size, sort);
        List<ItemEntity> itemEntityList = itemRepository.findAll(pageable).getContent();
        if(itemEntityList.isEmpty()){
            throw new NotDataFound();
        }
        return itemEntityMapper.toItemList(itemEntityList);
    }

    @Override
    public Item getItem(Long id) {
        return itemEntityMapper.toItem(itemRepository.getById(id));
    }

    @Override
    public boolean existByName(String name) {
        return itemRepository.existsByName(name);
    }

    private Item completeCategories(Item item) {
        List<Long> categoryIds = item.getCategory().stream()
                .map(Category::getId)
                .toList();

        List<CategoryEntity> fetchedCategories = categoryRepository.findAllById(categoryIds);

        Set<Long> fetchedIds = fetchedCategories.stream()
                .map(CategoryEntity::getId)
                .collect(Collectors.toSet());

        List<Long> missingIds = categoryIds.stream()
                .filter(id -> !fetchedIds.contains(id))
                .toList();

        if(!missingIds.isEmpty()) {
            throw new CategoryNotFoundException(missingIds.toString());
        }

        item.setCategory(categoryEntityMapper.toCategoryList(fetchedCategories));

        return item;
    }

}
