package com.cooking.api.decorators;

import com.cooking.api.dto.IngredientDto;
import com.cooking.api.mappers.IngredientMapper;
import com.cooking.api.services.IngredientService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class IngredientDecorator {

    private final IngredientMapper ingredientMapper;
    private final IngredientService ingredientService;

    public List<IngredientDto> getAll() {
        return ingredientMapper.toDtoList(ingredientService.getAll());
    }

    public IngredientDto getOne(UUID id) {
        return ingredientMapper.toDto(ingredientService.getOne(id));
    }

    public IngredientDto createOne(String name, boolean vegetable) {
        return ingredientMapper.toDto(ingredientService.createOne(name, vegetable));
    }

    public IngredientDto updateOne(UUID id, IngredientDto ingredientDto) {
        return ingredientMapper.toDto(ingredientService.updateOne(id, ingredientDto));
    }

    public void deleteOne(UUID id) {
        ingredientService.deleteOne(id);
    }

}