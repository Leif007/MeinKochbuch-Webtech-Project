package com.example.app;

    public class Recipe {
        private String name;
        private String description;
        private int prepTime;
        private int cookingTime;
        private String ingredients;
        private int servings;

        public Recipe(String name, String description, int prepTime, int cookingTime, String ingredients, int servings){
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


