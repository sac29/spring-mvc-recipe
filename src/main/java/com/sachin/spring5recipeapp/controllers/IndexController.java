package com.sachin.spring5recipeapp.controllers;


import com.sachin.spring5recipeapp.models.Category;
import com.sachin.spring5recipeapp.models.UnitOfMeasure;
import com.sachin.spring5recipeapp.repositories.CategoryRepository;
import com.sachin.spring5recipeapp.repositories.UnitOfMeasureRepository;
import com.sachin.spring5recipeapp.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
import java.util.logging.Logger;

@Controller
public class IndexController {

    private final RecipeService recipeService;
    static Logger logger = Logger.getLogger("IndexController");
    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){
        logger.info("hello spring - request");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
