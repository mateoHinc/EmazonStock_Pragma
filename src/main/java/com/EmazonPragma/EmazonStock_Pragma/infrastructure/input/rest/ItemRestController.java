package com.EmazonPragma.EmazonStock_Pragma.infrastructure.input.rest;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.ItemRequest;
import com.EmazonPragma.EmazonStock_Pragma.application.DTO.ItemResponse;
import com.EmazonPragma.EmazonStock_Pragma.application.handler.IItemHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemRestController {

    private final IItemHandler itemHandler;

    @Operation(summary = "Añadir a new item")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Item created", content = @Content)})
    @PostMapping("/new")
    public ResponseEntity<ItemResponse> saveItem(@RequestBody ItemRequest itemRequest){
        itemHandler.saveItem(itemRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
