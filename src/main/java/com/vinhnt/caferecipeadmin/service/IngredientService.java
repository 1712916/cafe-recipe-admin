package com.vinhnt.caferecipeadmin.service;

import com.vinhnt.caferecipeadmin.data.entity.Ingredient;
import com.vinhnt.caferecipeadmin.data.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findById(id).orElseThrow(() -> new RuntimeException("Ingredient not found"));
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Ingredient updateIngredient(Long id, Ingredient ingredientDetails) {
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow(() -> new RuntimeException("Ingredient not found"));
        ingredient.setName(ingredientDetails.getName());
        return ingredientRepository.save(ingredient);
    }

    public void deleteIngredient(Long id) {
        Ingredient ingredient = ingredientRepository.findById(id).orElseThrow(() -> new RuntimeException("Ingredient not found"));
        ingredientRepository.delete(ingredient);
    }
}