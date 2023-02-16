package me.ola.webapps2.service;

import me.ola.webapps2.model.Ingredient;
import me.ola.webapps2.model.Recipe;

public class ValidationServiceImpl implements ValidationService {
    @Override
    public boolean validate(Recipe recipe) {
        return recipe != null
                && recipe.getNameRecipe() != null
                && recipe.getSteps() != null
                && recipe.getIngredients() != null
                && !recipe.getIngredients().isEmpty()
                && !recipe.getSteps().isEmpty();
    }

    @Override
    public boolean validate(Ingredient ingredient) {
        return false;
    }
}
