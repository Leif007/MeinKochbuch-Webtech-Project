package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    RecipeService service;

    Logger logger = LoggerFactory.getLogger(RecipeController.class);

    @CrossOrigin
    @PostMapping("/recipe")
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        logger.info("Creating recipe: " + recipe);
        return service.save(recipe);
    }

    @CrossOrigin
    @GetMapping("/recipe/{id}")
    public Recipe getRecipe(@PathVariable String id) {
        logger.info("GET request on route things with {}" + id);
        Long recipeId = Long.parseLong(id);
        return service.get(recipeId);
    }

    @GetMapping("/recipes")
    public Iterable<Recipe> getAllRecipes() {
        return service.getAllRecepies();
    }


}
