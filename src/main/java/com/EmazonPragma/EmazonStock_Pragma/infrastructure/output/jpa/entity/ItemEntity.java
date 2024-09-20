package com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="item")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int amount;
    private double price;
    @ManyToMany
    @JoinTable(
            name = "itemCategory",
            joinColumns = @JoinColumn(name = "idItem"),
            inverseJoinColumns = @JoinColumn(name = "idCategory")
    )
    private List<CategoryEntity> category;
    @ManyToOne
    @JoinColumn(name = "idBrand", nullable = false)
    private BrandEntity idBrand;
}
