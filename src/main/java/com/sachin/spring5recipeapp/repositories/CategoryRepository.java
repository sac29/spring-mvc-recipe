package com.sachin.spring5recipeapp.repositories;

import com.sachin.spring5recipeapp.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
