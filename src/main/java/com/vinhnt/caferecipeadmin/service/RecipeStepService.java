package com.vinhnt.caferecipeadmin.service;


import com.vinhnt.caferecipeadmin.data.model.RecipeStep;
import com.vinhnt.caferecipeadmin.data.repository.RecipeStepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeStepService {
    @Autowired
    private RecipeStepRepository recipeStepRepository;

    public List<RecipeStep> findAll() {
        return recipeStepRepository.findAll();
    }

    public Optional<RecipeStep> findById(Long id) {
        return recipeStepRepository.findById(id);
    }

    public RecipeStep save(RecipeStep recipeStep) {
        return recipeStepRepository.save(recipeStep);
    }

    public void deleteById(Long id) {
        recipeStepRepository.deleteById(id);
    }
}