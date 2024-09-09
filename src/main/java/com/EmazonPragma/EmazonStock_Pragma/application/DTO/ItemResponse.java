package com.EmazonPragma.EmazonStock_Pragma.application.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemResponse {

    private Long id;
    private String name;
    private String description;
    private int amount;
    private double price;
    private CategoryResponse category;
    private BrandResponse brand;

}
