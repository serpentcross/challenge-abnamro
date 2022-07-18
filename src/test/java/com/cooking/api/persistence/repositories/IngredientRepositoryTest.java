package com.cooking.api.persistence.repositories;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class IngredientRepositoryTest {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Test
    public void mustDetectUsedIngredient() {
        assertTrue(ingredientRepository.ingredientIsUsedInRecipe(UUID.fromString("fa441a3d-db5b-4ac4-bffc-4d7596e3438b")));
    }
    @Test
    public void mustDetectFreeIngredient() {
        assertFalse(ingredientRepository.ingredientIsUsedInRecipe(UUID.fromString("7b2bd50f-95b2-4674-97ff-7cc9349b95d4")));
    }

}