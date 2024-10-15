package com.EmazonPragma.EmazonStock_Pragma.infrastructure.input.rest;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.CategoryResponse;
import com.EmazonPragma.EmazonStock_Pragma.application.DTO.ItemRequest;
import com.EmazonPragma.EmazonStock_Pragma.application.DTO.ItemResponse;
import com.EmazonPragma.EmazonStock_Pragma.application.handler.IItemHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemRestController {

    private final IItemHandler itemHandler;

    @Operation(summary = "Añadir a new item")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Item created", content = @Content)})
    @PostMapping("/new")
    public ResponseEntity<Void> saveItem(@RequestBody ItemRequest itemRequest){
        itemHandler.saveItem(itemRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Get all the items")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All items returned", content = @Content(mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = CategoryResponse.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<ItemResponse>>getAllItems
            (@RequestParam(value= "sortBy", defaultValue = "id") String sortBy,
             @RequestParam(value= "ascending", defaultValue = "true") boolean ascending,
             @RequestParam(value= "page", defaultValue = "0") int page,
             @RequestParam(value= "size", defaultValue = "10") int size) {
        return ResponseEntity.ok(itemHandler.ListItems(sortBy, ascending, page, size));
    }
}
