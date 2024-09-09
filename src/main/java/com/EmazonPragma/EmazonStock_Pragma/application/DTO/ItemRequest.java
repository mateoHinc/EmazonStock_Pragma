package com.EmazonPragma.EmazonStock_Pragma.application.DTO;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Brand;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemRequest {

    @Size(min = 1, max = 100, message = "El nombre del articulo maximo es de 100 caracteres")
    private String name;

    @Size(min = 1, max = 120, message = "El nombre del articulo maximo es de 120 caracteres")
    private String description;

    private int amount;

    private double price;

    private Category category;

    private Brand brand;
}
