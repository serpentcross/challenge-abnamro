package com.cooking.api.decorators;

import com.cooking.api.dto.IngredientDto;
import com.cooking.api.dto.RecipeDto;

import com.cooking.api.mappers.RecipeMapper;

import com.cooking.api.persistence.entities.Ingredient;
import com.cooking.api.persistence.entities.Recipe;
import com.cooking.api.services.IngredientService;
import com.cooking.api.services.RecipeService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RecipeDecorator {

    private final IngredientService ingredientService;
    private final RecipeMapper recipeMapper;
    private final RecipeService recipeService;

    public RecipeDto getOne(UUID id) {
        return recipeMapper.toDto(recipeService.getOne(id));
    }

    public List<RecipeDto> getAll(Boolean vegetarian, Integer servings, String instruction, String ingredient) {
        return recipeMapper.toDtoList(recipeService.getAll(vegetarian, servings, instruction, ingredient));
    }

    public void deleteOne(UUID id) {
        recipeService.deleteOne(id);
    }

    @Transactional
    public RecipeDto createOne(RecipeDto recipeDto) {

        Recipe recipe = recipeMapper.toEntity(recipeDto);

        List<Ingredient> ingredients = getIngredients(recipeDto);
        recipe.setVegetarian(ingredients.stream().allMatch(Ingredient::isVegetable));
        recipe.setIngredients(ingredients);

        return recipeMapper.toDto(recipeService.saveOne(recipe));

    }

    @Transactional
    public RecipeDto updateOne(UUID id, RecipeDto recipeDto) {

        Recipe recipe = recipeService.getOne(id);

        recipe.setName(recipeDto.getName());
        recipe.setInstruction(recipeDto.getInstruction());
        recipe.setServingAmount(recipeDto.getServingAmount());

        List<Ingredient> ingredients = getIngredients(recipeDto);
        recipe.setVegetarian(ingredients.stream().allMatch(Ingredient::isVegetable));
        recipe.setIngredients(ingredients);

        return recipeMapper.toDto(recipeService.saveOne(recipe));

    }

    private List<Ingredient> getIngredients(RecipeDto recipeDto) {
        return ingredientService
            .getAllIn(
                recipeDto
                    .getIngredients()
                    .stream()
                    .map(IngredientDto::getId)
                    .collect(Collectors.toList())
            );
    }

}