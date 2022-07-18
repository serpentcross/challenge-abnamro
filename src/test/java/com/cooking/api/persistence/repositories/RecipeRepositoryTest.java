package com.cooking.api.persistence.repositories;

import com.cooking.api.persistence.entities.Recipe;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class RecipeRepositoryTest {

    @Autowired
    private RecipeRepository recipeRepository;

    @Test
    public void mustFindRecipesAccordingGivenFilters() {
        List<Recipe> filteredRecipes = recipeRepository.findByFilters(true,"Carrot", 8, "stove");
        assertEquals(1, filteredRecipes.size());
        assertEquals(UUID.fromString("27d71d6f-9643-47a4-8fc6-70808265b6cf"), filteredRecipes.get(0).getId());
    }


}