package com.EmazonPragma.EmazonStock_Pragma.infrastructure.input.rest;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.CategoryRequest;
import com.EmazonPragma.EmazonStock_Pragma.application.handler.ICategoryHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryRestController {

    private final ICategoryHandler categoryHandler;

    @Operation(summary = "Add a new categoria")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Category created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Category already exists", content = @Content),
            @ApiResponse(responseCode = "400",description = "Se envio algun dato de forma erronea en la peticion.",content = @Content)
    })
    @PostMapping("/new")
    public ResponseEntity<Void> saveCategory(@Validated @RequestBody CategoryRequest categoryRequest){
        categoryHandler.saveCategory(categoryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
