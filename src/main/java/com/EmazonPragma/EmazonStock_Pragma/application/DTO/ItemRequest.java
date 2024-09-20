package com.EmazonPragma.EmazonStock_Pragma.application.DTO;

import com.EmazonPragma.EmazonStock_Pragma.domain.model.Brand;
import com.EmazonPragma.EmazonStock_Pragma.domain.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ItemRequest {

    @Size(min = 1, max = 100, message = "El nombre del articulo maximo es de 100 caracteres")
    private String name;

    @Size(min = 1, max = 120, message = "El nombre del articulo maximo es de 120 caracteres")
    private String description;

    @NotBlank(message = "La cantidad es obligatoria")
    @Positive(message = "La cantidad debe ser positivo")
    private int amount;

    @NotBlank(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser positivo")
    private double price;

    private List<Category> category;

    private Long brand;
}
