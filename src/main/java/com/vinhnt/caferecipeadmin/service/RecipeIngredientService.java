package com.vinhnt.caferecipeadmin.service;

import com.vinhnt.caferecipeadmin.data.entity.RecipeIngredient;
import com.vinhnt.caferecipeadmin.data.repository.RecipeIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeIngredientService {
    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;

    // Lấy tất cả các RecipeIngredient
    public List<RecipeIngredient> findAll() {
        return recipeIngredientRepository.findAll();
    }

    // Lấy RecipeIngredient theo ID
    public Optional<RecipeIngredient> findById(Long id) {
        return recipeIngredientRepository.findById(id);
    }

    // Lưu RecipeIngredient
    public RecipeIngredient save(RecipeIngredient recipeIngredient) {
        return recipeIngredientRepository.save(recipeIngredient);
    }

    // Xóa RecipeIngredient theo ID
    public void deleteById(Long id) {
        recipeIngredientRepository.deleteById(id);
    }

    // Lấy tất cả RecipeIngredient của một Recipe
    public List<RecipeIngredient> findByRecipeId(Long recipeId) {
        return recipeIngredientRepository.findByRecipeId(recipeId);
    }
}