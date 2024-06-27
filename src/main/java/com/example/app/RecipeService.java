package com.example.app;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository repo;

    public Recipe save(Recipe recipe) {
        return repo.save(recipe);
    }

    public Recipe get(Long id) {
        return repo.findById(id).orElseThrow(RuntimeException::new);
    }


    public Iterable<Recipe> getAllRecipes() {
        return repo.findAll();
    }
}
