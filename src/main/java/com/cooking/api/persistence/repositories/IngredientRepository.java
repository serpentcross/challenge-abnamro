package com.cooking.api.persistence.repositories;

import com.cooking.api.persistence.entities.Ingredient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface IngredientRepository extends JpaRepository<Ingredient, UUID> {

    @Query(value = "SELECT EXISTS(SELECT r.* FROM recipe r " +
            "INNER JOIN ingredient_recipe ir ON (r.id = ir.recipe) " +
            "INNER JOIN ingredient i ON (i.id = ir.ingredient) " +
            "WHERE  r.id IN (\n" +
            "        SELECT r.id FROM recipe r\n" +
            "        INNER JOIN ingredient_recipe ir ON (r.id = ir.recipe) " +
            "        INNER JOIN ingredient i ON (ir.ingredient = i.id) " +
            "        WHERE (:id IS NULL OR i.id = :id)))", nativeQuery = true)
    boolean ingredientIsUsedInRecipe(UUID id);

}