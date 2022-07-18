package com.cooking.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class IngredientDto {

    @Schema(description = "Ingredient id")
    private UUID id;

    @Schema(description = "Ingredient name", required = true)
    private String name;

    private boolean vegetable;

}