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
        private int preperationTime;
        private int cookingTime;
        private String ingredients;
        private String instructions;
        private String dishType;
        private String mealTime;
        private String dietType;
        private String picture;





        public Recipe(Long id,String name, String description, int preperationTime, int cookingTime, String ingredients, String instructions, String dishType, String mealTime, String dietType, String picture) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.preperationTime = preperationTime;
            this.cookingTime = cookingTime;
            this.ingredients = ingredients;
            this.instructions = instructions;
            this.dishType = dishType;
            this.mealTime = mealTime;
            this.dietType = dietType;
            this.picture = picture;



        }
        public Recipe() {} // leerer Konstruktor von Hibernate benötigt

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public int getPrepTime() {
            return preperationTime;
        }

        public int getCookingTime() {
            return cookingTime;
        }

        public String getIngredients() {
            return ingredients;
        }

        public String getInstructions() {
            return instructions;
        }

        public String getDishType() {
            return dishType;
        }

        public String getMealTime() {
            return mealTime;
        }

        public String getDietType() {
            return dietType;
        }



    }


