package com.EmazonPragma.EmazonStock_Pragma.infrastructure.input.rest;

import com.EmazonPragma.EmazonStock_Pragma.application.DTO.BrandRequest;
import com.EmazonPragma.EmazonStock_Pragma.application.DTO.BrandResponse;
import com.EmazonPragma.EmazonStock_Pragma.application.handler.IBrandHandler;
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
@RequestMapping("/brand")
public class BrandRestController {

    private final IBrandHandler brandHandler;

    @Operation(summary = "Add a new brand")
    @ApiResponses(@ApiResponse(responseCode = "201", description = "Brand created", content = @Content))
    @PostMapping("/new")
    public ResponseEntity<BrandResponse> saveBrand(@Validated @RequestBody BrandRequest brandRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(brandHandler.saveBrand(brandRequest));
    }
}
