package me.ola.webapps2.service;

import me.ola.webapps2.model.Ingredient;
import me.ola.webapps2.model.Recipe;
import org.apache.commons.lang3.StringUtils;

public class ValidationServiceImpl implements ValidationService {
    @Override
    public boolean validate(Recipe recipe) {
        return recipe != null
                && recipe.getNameRecipe() != null
                && !StringUtils.isEmpty(recipe.getNameRecipe())
                && recipe.getSteps() != null
                && recipe.getIngredients() != null
                && !recipe.getIngredients().isEmpty()
                && !recipe.getSteps().isEmpty();
    }

    @Override
    public boolean validate(Ingredient ingredient) {
        return ingredient != null
                && ingredient.getName() != null
                && !StringUtils.isEmpty(ingredient.getName());

    }
}
