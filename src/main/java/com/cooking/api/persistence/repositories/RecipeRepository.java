package com.cooking.api.persistence.repositories;

import com.cooking.api.persistence.entities.Recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RecipeRepository extends JpaRepository<Recipe, UUID> {

    @Query(value = "" +
            "SELECT DISTINCT r.* FROM recipe r " +
            "INNER JOIN ingredient_recipe ir ON (r.id = ir.recipe) " +
            "INNER JOIN ingredient i ON (i.id = ir.ingredient) " +
            "WHERE r.id IN (\n" +
            "    SELECT r.id FROM recipe r " +
            "    INNER JOIN ingredient_recipe ir ON (r.id = ir.recipe) " +
            "    INNER JOIN ingredient i ON (ir.ingredient = i.id) " +
            "    WHERE (:ingredient IS NULL OR i.name = :ingredient)) " +
            "AND (:vegetarian IS NULL OR r.vegetarian = :vegetarian) " +
            "AND (:servingAmount IS NULL OR r.serving_amount = :servingAmount)" +
            "AND (:instruction IS NULL OR r.instruction LIKE CONCAT('%',:instruction,'%'))", nativeQuery = true)
    List<Recipe> findByFilters(Boolean vegetarian, String ingredient, Integer servingAmount, String instruction);


}