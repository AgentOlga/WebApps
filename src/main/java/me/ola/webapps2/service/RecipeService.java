package me.ola.webapps2.service;

import me.ola.webapps2.model.Ingredient;
import me.ola.webapps2.model.Recipe;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
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
    /**
     * Обновление рецепта
     * @param id идентификатор
     * @param recipe рецепт
     * @return Обновленный рецепт
     */

    Recipe update (Long id, Recipe recipe);

    /**
     * Удаление рецепта
     * @param id идентификатор
     * @return удаленный рецепт
     */
    Recipe delete(Long id);

    /**
     *
     * @return мапа рецептов
     */
    Map<Long, Recipe> getAll();

    /**
     * Чтение файла рецептов
     * @return файла рецептов
     */
    File readFile();

    /**
     * Загрузка файла рецептов
     * @param file файл рецептов
     * @throws IOException
     */
    void uploadFile(MultipartFile file) throws IOException;

    File makeReadyRecipe() throws IOException;

}
