package com.EmazonPragma.EmazonStock_Pragma.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Long id;
    private String name;
    private String description;
    private int amount;
    private double price;
    private Long idCategory;
    private Long idBrand;
}
