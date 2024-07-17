package com.vinhnt.caferecipeadmin.controller;

import com.vinhnt.caferecipeadmin.data.entity.RecipeStep;
import com.vinhnt.caferecipeadmin.service.RecipeStepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recipeSteps")
public class RecipeStepController {
    @Autowired
    private RecipeStepService recipeStepService;

    @GetMapping
    public List<RecipeStep> getAllRecipeSteps() {
        return recipeStepService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeStep> getRecipeStepById(@PathVariable Long id) {
        Optional<RecipeStep> recipeStep = recipeStepService.findById(id);
        return recipeStep.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public RecipeStep createRecipeStep(@RequestBody RecipeStep recipeStep) {
        return recipeStepService.save(recipeStep);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeStep> updateRecipeStep(@PathVariable Long id, @RequestBody RecipeStep recipeStepDetails) {
        Optional<RecipeStep> recipeStepOptional = recipeStepService.findById(id);
        if (!recipeStepOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        RecipeStep recipeStep = recipeStepOptional.get();
        recipeStep.setName(recipeStepDetails.getName());
        recipeStep.setDescription(recipeStepDetails.getDescription());
        recipeStep.setStepNumber(recipeStepDetails.getStepNumber());
        recipeStep.setRecipe(recipeStepDetails.getRecipe());

        RecipeStep updatedRecipeStep = recipeStepService.save(recipeStep);
        return ResponseEntity.ok(updatedRecipeStep);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipeStep(@PathVariable Long id) {
        if (!recipeStepService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        recipeStepService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}