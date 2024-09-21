package com.EmazonPragma.EmazonStock_Pragma.application.DTO;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrandRequest {
    @Size(min = 1, max = 50, message = "El nombre de la marca maximo es de 50 caracteres")
    private String name;
    @Size(min = 1, max = 120, message = "La descripción de la marca maximo es de 120 caracteres")
    private String description;
}
