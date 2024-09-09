package com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.repository;

import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemRepository extends JpaRepository<ItemEntity, Long> {
}
