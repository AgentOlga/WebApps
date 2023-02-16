package me.ola.webapps2.service;

import me.ola.webapps2.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.Map;
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

    /**
     * Обновление ингредиента
     * @param id идентификатор
     * @param ingredient ингредиент
     * @return Обновленный ингредиент
     */

    Ingredient update (Long id, Ingredient ingredient);

    /**
     * Удаление ингредиента
     * @param id идентификатор
     * @return удаленный ингредиент
     */
    Ingredient delete(Long id);

    /**
     *
     * @return мапа ингредиентов
     */
    Map<Long, Ingredient> getAll();

}
