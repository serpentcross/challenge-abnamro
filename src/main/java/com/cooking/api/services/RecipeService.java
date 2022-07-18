package com.cooking.api.services;

import com.cooking.api.dto.RecipeDto;
import com.cooking.api.exceptions.Code404ItemNotFoundException;
import com.cooking.api.persistence.entities.Recipe;
import com.cooking.api.persistence.repositories.RecipeRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public Recipe getOne(UUID id) {
        return recipeRepository
            .findById(id)
            .orElseThrow(() -> new Code404ItemNotFoundException(RecipeDto.class, id));
    }
    public List<Recipe> getAll(Boolean vegetarian,
                                  Integer servings,
                                  String instruction,
                                  String ingredient) {
        return recipeRepository.findByFilters(vegetarian, ingredient, servings, instruction);
    }

    public void deleteOne(UUID id) {
        recipeRepository.deleteById(id);
    }

    public Recipe saveOne(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

}