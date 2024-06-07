package com.example.app;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Recipe {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String name;
        private String description;
        private int prepTime;
        private int cookingTime;
        private String ingredients;
        private int servings;

        public Recipe(Long id,String name, String description, int prepTime, int cookingTime, String ingredients, int servings){
            this.id = id;
            this.name = name;
            this.description = description;
            this. prepTime = prepTime;
            this.cookingTime = cookingTime;
            this.ingredients = ingredients;
            this.servings = servings;

        }
        public Recipe() {} // leerer Konstruktor von Hibernate benötigt

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public int getPrepTime() {
            return prepTime;
        }

        public int getCookingTime() {
            return cookingTime;
        }

        public String getIngredients() {
            return ingredients;
        }

        public int getServings() {
            return servings;
        }


    }


