package com.vinhnt.caferecipeadmin.controller;

import com.vinhnt.caferecipeadmin.data.model.Recipe;
import com.vinhnt.caferecipeadmin.data.model.RecipeStep;
import com.vinhnt.caferecipeadmin.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping
    public List<Recipe> getAllRecipes() {
        return recipeService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeById(@PathVariable Long id) {
        Optional<Recipe> recipe = recipeService.findById(id);
        return recipe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        for (RecipeStep step : recipe.getSteps()) {
            step.setRecipe(recipe);
        }
        return recipeService.save(recipe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody Recipe recipeDetails) {
        Optional<Recipe> recipeOptional = recipeService.findById(id);
        if (!recipeOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Recipe recipe = recipeOptional.get();
        recipe.setName(recipeDetails.getName());
        recipe.setDescription(recipeDetails.getDescription());
        recipe.setSteps(recipeDetails.getSteps());

        Recipe updatedRecipe = recipeService.save(recipe);
        return ResponseEntity.ok(updatedRecipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id) {
        if (!recipeService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        recipeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}