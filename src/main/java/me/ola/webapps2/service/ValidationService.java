package me.ola.webapps2.service;

import me.ola.webapps2.model.Ingredient;
import me.ola.webapps2.model.Recipe;

/**
 * Сервис валидации
 */
public interface ValidationService {
    /**
     * Валидация рецепта
     * @param recipe Рецепт для валидации
     * @return Рецепт корректен
     */
    public boolean validate(Recipe recipe);
    /**
     * Валидация ингредиента
     * @param ingredient Ингредиент для валидации
     * @return Ингредиент корректен
     */
    public  boolean validate(Ingredient ingredient);
}
