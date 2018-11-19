package com.sachin.spring5recipeapp.repositories;

import com.sachin.spring5recipeapp.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
