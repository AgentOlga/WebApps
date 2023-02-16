package me.ola.webapps2.model;

import java.util.List;
import java.util.Objects;

/**
 * Рецепт
 */
public class Recipe {
    private String nameRecipe;
    private int cookingTime;
    private List<Ingredient> ingredients;
    private List<String> steps;

    public Recipe(String nameRecipe, int cookingTime, List<Ingredient> ingredients, List<String> steps) {
        this.nameRecipe = nameRecipe;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    public String getNameRecipe() {
        return nameRecipe;
    }

    public void setNameRecipe(String nameRecipe) {
        this.nameRecipe = nameRecipe;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe recipe)) return false;
        return cookingTime == recipe.cookingTime && nameRecipe.equals(recipe.nameRecipe) && ingredients.equals(recipe.ingredients) && steps.equals(recipe.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameRecipe, cookingTime, ingredients, steps);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "nameRecipe='" + nameRecipe + '\'' +
                ", cookingTime=" + cookingTime +
                ", ingredients=" + ingredients +
                ", steps=" + steps +
                '}';
    }
}
