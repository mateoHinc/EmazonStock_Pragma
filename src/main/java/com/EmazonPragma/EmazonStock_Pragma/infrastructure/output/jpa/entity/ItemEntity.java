package com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @JoinColumn(name = "idCategory")
    private Long idCategory;
    @JoinColumn(name = "idBrand")
    private Long idBrand;
}
