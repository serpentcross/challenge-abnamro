package com.cooking.api.mappers;

import com.cooking.api.dto.IngredientDto;
import com.cooking.api.persistence.entities.Ingredient;
import com.cooking.api.persistence.entities.Recipe;
import com.cooking.api.dto.RecipeDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = "spring")
public interface RecipeMapper {

    IngredientMapper ingredientMapper = Mappers.getMapper(IngredientMapper.class);

    @Mappings({
        @Mapping(source = "recipeDto", target = "ingredients", qualifiedByName = "getIngredientsEntity")
    })
    Recipe toEntity(RecipeDto recipeDto);

    @Mappings({
        @Mapping(source = "recipe", target = "ingredients", qualifiedByName = "getIngredientsDto")
    })
    RecipeDto toDto(Recipe recipe);

    @Mappings({
        @Mapping(source = "recipe", target = "ingredients", qualifiedByName = "getIngredientsEntity")
    })
    List<RecipeDto> toDtoList(List<Recipe> recipes);

    @Named("getIngredientsDto")
    default List<IngredientDto> getIngredientsDto(Recipe recipe) {
        return recipe != null ? recipe.getIngredients() != null ? ingredientMapper.toDtoList(recipe.getIngredients()) : new ArrayList<>() : new ArrayList<>();
    }

    @Named("getIngredientsEntity")
    default List<Ingredient> getIngredientsEntity(RecipeDto recipeDto) {
        return recipeDto != null ? recipeDto.getIngredients() != null ? ingredientMapper.toEntityList(recipeDto.getIngredients()) : new ArrayList<>() : new ArrayList<>();
    }

}