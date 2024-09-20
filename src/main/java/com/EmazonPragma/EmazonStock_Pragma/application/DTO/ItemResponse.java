package com.EmazonPragma.EmazonStock_Pragma.application.DTO;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemResponse {

    private Long id;
    private String name;
    private String description;
    private int amount;
    private double price;
    private List<Category> category;
    private Long brand;

}
