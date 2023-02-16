package me.ola.webapps2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


/**
 * Рецепт
 */
@Data
@AllArgsConstructor
public class Recipe {
    private String nameRecipe;
    private int cookingTime;
    private List<Ingredient> ingredients;
    private List<String> steps;


}
