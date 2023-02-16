package me.ola.webapps2.service;

import me.ola.webapps2.model.Ingredient;
import me.ola.webapps2.model.Recipe;

import java.util.Optional;

/**
 * Сервис для работы с рецептами
 */
public interface RecipeService {
    /**
     * сохранить рецепт
     * @param recipe рецепт для сохранения
     * @return сохраненный рецепт
     */
    Recipe save (Recipe recipe);

    /**
     * Получение рецепта по id
     * @param id Идентификатор рецепта
     * @return рецепт
     */
    Optional<Recipe> getById(Long id);
}
