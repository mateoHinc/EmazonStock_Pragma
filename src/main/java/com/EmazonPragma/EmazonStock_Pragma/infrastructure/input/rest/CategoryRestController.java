package com.EmazonPragma.EmazonStock_Pragma.infrastructure.input.rest;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.CategoryRequest;
import com.EmazonPragma.EmazonStock_Pragma.application.DTO.CategoryResponse;
import com.EmazonPragma.EmazonStock_Pragma.application.handler.ICategoryHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryRestController {

    private final ICategoryHandler categoryHandler;

    @Operation(summary = "Add a new category")
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

    @Operation(summary = "Get all the categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All categories returned", content = @Content(mediaType = "application/json",
            array = @ArraySchema(schema = @Schema(implementation = CategoryResponse.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories
            (@RequestParam(value= "sortBy", defaultValue = "id") String sortBy,
             @RequestParam(value= "ascending", defaultValue = "true") boolean ascending,
             @RequestParam(value= "page", defaultValue = "0") int page,
             @RequestParam(value= "size", defaultValue = "10") int size) {
        return ResponseEntity.ok(categoryHandler.listCategories(sortBy, ascending, page, size));
    }
}
