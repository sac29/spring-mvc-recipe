package com.sachin.spring5recipeapp.bootstrap;

import com.sachin.spring5recipeapp.models.*;
import com.sachin.spring5recipeapp.repositories.CategoryRepository;
import com.sachin.spring5recipeapp.repositories.RecipeRepository;
import com.sachin.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes(){
        List<Recipe> recipes = new ArrayList<>(2);

        Optional<UnitOfMeasure> teaspoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if(!teaspoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> tablespoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if(!tablespoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> pinchUomOptional = unitOfMeasureRepository.findByDescription("Pinch");

        if(!pinchUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
        Optional<UnitOfMeasure> cupUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if(!cupUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        Optional<UnitOfMeasure> ounceUomOptional = unitOfMeasureRepository.findByDescription("Ounce");


        if(!ounceUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }


        UnitOfMeasure teaspoonUom = teaspoonUomOptional.get();
        UnitOfMeasure pinchUom = pinchUomOptional.get();
        UnitOfMeasure tablespoonUom = tablespoonUomOptional.get();
        UnitOfMeasure cupsUom = cupUomOptional.get();
        UnitOfMeasure ounceUom = pinchUomOptional.get();

        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if(!americanCategoryOptional.isPresent()){
            throw new RuntimeException("Expected category not found");
        }
        Optional<Category> indianCategoryOptional = categoryRepository.findByDescription("Indian");

        if(!indianCategoryOptional.isPresent()){
            throw new RuntimeException("Expected category not found");
        }

        Category americanCategory = americanCategoryOptional.get();
        Category indianCategory = indianCategoryOptional.get();

        Recipe guaca = new Recipe();
        guaca.setDescription("Perfect Guacamole");
        guaca.setPrepTime(10);
        guaca.setCookTime(15);
        guaca.setDifficulty(Difficulty.EASY);
        guaca.setDirections("Place liquid in the blender first, then add your fruit and ice. "+
                            "\n"+
                            "Cover and start on low sped, increasing to high speed."+
                            "\n"+
                            "Blend until creamy and smooth.");

        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("A healthy avocado smoothie recipe is a great idea to begin your day with rich healthy fats and nutrients.");

        guacNotes.setRecipe(guaca);
        guaca.setNotes(guacNotes);

        guaca.getIngredients().add(new Ingredient("ripe avcado", new BigDecimal(2), ounceUom, guaca));
        guaca.getIngredients().add(new Ingredient("lime water", new BigDecimal(1), tablespoonUom, guaca));
        guaca.getIngredients().add(new Ingredient("some water", new BigDecimal(4), ounceUom, guaca));
        guaca.getIngredients().add(new Ingredient("Cilantro", new BigDecimal(2), teaspoonUom, guaca));

        guaca.getCategories().add(americanCategory);
        guaca.getCategories().add(indianCategory);

        recipes.add(guaca);

        Recipe samosa = new Recipe();
        samosa.setDescription("Deep fried samosa");
        samosa.setPrepTime(5);
        samosa.setCookTime(15);
        samosa.setDifficulty(Difficulty.MODERATE);
        samosa.setDirections("Make aloo ka bharta "+
                "\n"+
                "Fill the maida with aloo patties"+
                "\n"+
                "Deep fry them in oil");

        Notes samosaNotes = new Notes();
        samosaNotes.setRecipeNotes("We have a great snack to enjoy any time of the  day");

        samosaNotes.setRecipe(samosa);
        samosa.setNotes(samosaNotes);


        samosa.getIngredients().add(new Ingredient("Potatoes", new BigDecimal(10), ounceUom, samosa));
        samosa.getIngredients().add(new Ingredient("Masala", new BigDecimal(2), teaspoonUom, samosa));
        samosa.getIngredients().add(new Ingredient("Jeera", new BigDecimal(10), teaspoonUom, samosa));
        samosa.getIngredients().add(new Ingredient("Flour", new BigDecimal(5), tablespoonUom, samosa));

        samosa.getCategories().add(indianCategory);
        recipes.add(samosa);

        return recipes;


    }
}
