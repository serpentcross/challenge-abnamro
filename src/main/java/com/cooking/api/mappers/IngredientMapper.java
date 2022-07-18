package com.cooking.api.mappers;

import com.cooking.api.dto.IngredientDto;
import com.cooking.api.persistence.entities.Ingredient;

import org.mapstruct.Mapper;

import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE, componentModel = "spring")
public interface IngredientMapper {

    Ingredient toEntity(IngredientDto ingredientDto);

    IngredientDto toDto(Ingredient ingredient);

    List<IngredientDto> toDtoList(List<Ingredient> ingredients);

    List<Ingredient> toEntityList(List<IngredientDto> ingredients);

}