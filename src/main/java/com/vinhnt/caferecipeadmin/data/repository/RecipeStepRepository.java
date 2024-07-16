package com.vinhnt.caferecipeadmin.data.repository;

import com.vinhnt.caferecipeadmin.data.model.RecipeStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeStepRepository extends JpaRepository<RecipeStep, Long> {
}