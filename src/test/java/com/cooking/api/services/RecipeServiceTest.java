package com.cooking.api.services;

import com.cooking.api.persistence.entities.Recipe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RecipeServiceTest {

    @Autowired
    private RecipeService recipeService;

    @Test
    public void mustExtractExactDtoById() {

        Recipe recipe = recipeService.getOne(UUID.fromString("0bc71e70-4ffe-4d9f-876c-b01600b30a49"));

        assertEquals("Potato Soup", recipe.getName());
        assertEquals(6, recipe.getServingAmount());
        assertTrue(recipe.isVegetarian());

    }

}