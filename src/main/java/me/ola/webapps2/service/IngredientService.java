package me.ola.webapps2.service;

import me.ola.webapps2.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Сервис для работы с ингредиентами
 */
public interface IngredientService {
    /**
     * сохранить ингредиент
     * @param ingredient ингредиент для сохранения
     * @return сохраненный ингредиент
     */

    Ingredient save (Ingredient ingredient);

    /**
     * Получение ингредиента по id
     * @param id Идентификатор ингредиента
     * @return ингредиент
     */
    Optional<Ingredient> getById(Long id);

}
