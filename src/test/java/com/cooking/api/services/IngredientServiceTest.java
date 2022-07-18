package com.cooking.api.services;

import com.cooking.api.dto.IngredientDto;
import com.cooking.api.exceptions.Code409ItemConflictException;
import com.cooking.api.persistence.entities.Ingredient;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertFalse;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IngredientServiceTest {

    @Autowired
    private IngredientService ingredientService;

    @Test
    public void mustExtractExactDtoById() {
        assertEquals("Salad", ingredientService.getOne(UUID.fromString("0ef0f4cf-1d80-427f-9669-715f69f00456")).getName());
    }

    @Test
    public void mustPersistNewEntity() {

        Ingredient ingredient = ingredientService.createOne("Caramel", false);

        assertEquals(7, ingredientService.getAll().size());
        assertEquals("Caramel", ingredientService.getOne(ingredient.getId()).getName());

        ingredientService.deleteOne(ingredient.getId()); //TearDown

    }

    @Test
    public void mustDeleteOneEntity() {

        ingredientService.deleteOne(UUID.fromString("7b2bd50f-95b2-4674-97ff-7cc9349b95d4"));
        assertEquals(5, ingredientService.getAll().size());
        ingredientService.createOne("Yogurt", false);

    }

    @Test
    public void mustUpdateOneEntity() {

        UUID id = UUID.fromString("afe5e38d-6401-4ad3-8145-e9c537ae2fef");

        ingredientService.updateOne(id, IngredientDto.builder().name("Pork").vegetable(false).build());
        assertEquals("Pork", ingredientService.getOne(id).getName());
        assertFalse("Pork", ingredientService.getOne(id).isVegetable());

    }

    @Test
    public void mustThrowAConflictException() {
        assertThrows(
            Code409ItemConflictException.class, () -> ingredientService.deleteOne(UUID.fromString("fa441a3d-db5b-4ac4-bffc-4d7596e3438b"))
        );
    }

}