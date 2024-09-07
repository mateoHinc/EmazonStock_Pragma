package com.EmazonPragma.EmazonStock_Pragma.infrastructure.input.rest;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.BrandRequest;
import com.EmazonPragma.EmazonStock_Pragma.application.DTO.BrandResponse;
import com.EmazonPragma.EmazonStock_Pragma.application.handler.IBrandHandler;
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
@RequestMapping("/brand")
public class BrandRestController {

    private final IBrandHandler brandHandler;

    @Operation(summary = "Add a new brand")
    @ApiResponses(@ApiResponse(responseCode = "201", description = "Brand created", content = @Content))
    @PostMapping("/new")
    public ResponseEntity<BrandResponse> saveBrand(@Validated @RequestBody BrandRequest brandRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(brandHandler.saveBrand(brandRequest));
    }

    @Operation(summary = "Get the all brands")
    @ApiResponses(@ApiResponse(responseCode = "200", description = "All brands returned",
                               content = @Content(mediaType = "application/json",
                                       array = @ArraySchema(schema = @Schema(implementation = BrandResponse.class)))))
    @GetMapping
    public ResponseEntity<List<BrandResponse>> listBrands(@RequestParam(value= "sortBy", defaultValue = "id") String sortBy,
                                                          @RequestParam(value= "ascending", defaultValue = "true") boolean ascending,
                                                          @RequestParam(value= "page", defaultValue = "0") int page,
                                                          @RequestParam(value= "size", defaultValue = "10") int size) {
        return ResponseEntity.ok(brandHandler.listBrands(sortBy,ascending,page,size));
    }
}
