package me.ola.webapps2.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.ola.webapps2.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import me.ola.webapps2.model.Recipe;

import java.util.Map;

@RestController
@RequestMapping("/recipe")
@Tag(name ="API по работе с рецептами", description =" CRUD-операции по работе с рецептами")

public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @Operation(
            summary = "Сохранение рецепта"
    )

    @PostMapping
    public ResponseEntity<Recipe> save(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.save(recipe));
    }
    @Operation(
            summary = "Получение рецепта по id"
    )

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getById(@PathVariable Long id) {
         return ResponseEntity.of(recipeService.getById(id));
    }
    @Operation(
            summary = "Обновление рецепта"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> update(@PathVariable Long id, @RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.update(id, recipe));
    }
    @Operation(
            summary = "Удаление рецепта"
    )

    @DeleteMapping("/{id}")
    public ResponseEntity<Recipe> delete(@PathVariable Long id) {
        return ResponseEntity.ok(recipeService.delete(id));
    }
    @Operation(
            summary = "Получение всех рецептов"
    )

    @GetMapping
    public ResponseEntity<Map<Long, Recipe>> getAll() {
        return ResponseEntity.ok(recipeService.getAll());
    }

}
