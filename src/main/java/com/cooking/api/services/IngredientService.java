package com.cooking.api.services;

import com.cooking.api.exceptions.Code404ItemNotFoundException;
import com.cooking.api.exceptions.Code409ItemConflictException;
import com.cooking.api.persistence.entities.Ingredient;
import com.cooking.api.persistence.repositories.IngredientRepository;
import com.cooking.api.dto.IngredientDto;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }

    public List<Ingredient> getAllIn(List<UUID> ids) {
        return ingredientRepository.findAllById(ids);
    }

    public Ingredient getOne(UUID id) {
        return ingredientRepository
            .findById(id)
            .orElseThrow(() -> new Code404ItemNotFoundException(Ingredient.class, id));
    }

    public Ingredient createOne(String name, boolean vegetable) {
        return mergeEntityResult(Ingredient.builder().name(name).vegetable(vegetable).build());
    }

    @Transactional
    public Ingredient updateOne(UUID id, IngredientDto ingredientDto) {
        Ingredient old = getOne(id);
        old.setName(ingredientDto.getName());
        old.setVegetable(ingredientDto.isVegetable());
        return mergeEntityResult(old);
    }

    public void deleteOne(UUID id) {
        if (ingredientRepository.ingredientIsUsedInRecipe(id)) {
            throw new Code409ItemConflictException(Ingredient.class, id);
        } else {
            ingredientRepository.deleteById(id);
        }
    }

    private Ingredient mergeEntityResult(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

}