package com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.repository;

import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandRepository extends JpaRepository<BrandEntity,Long> {
    boolean existsByName(String name);
}
