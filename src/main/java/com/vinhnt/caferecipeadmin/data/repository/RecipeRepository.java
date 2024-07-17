package com.vinhnt.caferecipeadmin.data.repository;

import com.vinhnt.caferecipeadmin.data.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}