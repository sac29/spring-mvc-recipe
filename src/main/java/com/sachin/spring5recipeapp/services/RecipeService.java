package com.sachin.spring5recipeapp.services;

import com.sachin.spring5recipeapp.models.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
