package com.cooking.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RecipeDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Schema(description = "Recipe's id")
    private UUID id;

    @Schema(description = "Recipe's name.", required = true)
    private String name;

    @Schema(description = "Description of current recipe.", required = true)
    private String instruction;

    @Schema(description = "Amount of servings supported by current recipe.", required = true)
    private int servingAmount;

    @Schema(description = "Current recipe contains vegetables only.", required = true)
    private boolean vegetarian;

    @Schema(description = "List of ingredients used to cook this meal.")
    private List<IngredientDto> ingredients;

}