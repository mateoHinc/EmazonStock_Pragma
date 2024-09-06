package com.EmazonPragma.EmazonStock_Pragma.application.DTO;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class CategoryRequest {
    @Size(min = 1, max = 50, message = "El nombre de la categoría maximo es de 50 caracteres")
    private String name;

    @Size(min = 1, max = 90, message = "La descripción de la categoría maximo es de 90 caracteres")
    private String description;

}
