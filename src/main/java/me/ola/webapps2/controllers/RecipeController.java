package me.ola.webapps2.controllers;

import me.ola.webapps2.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import me.ola.webapps2.model.Recipe;

@RestController
@RequestMapping("/recipe")

public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
@PostMapping
    public ResponseEntity<Recipe> save(@RequestBody Recipe recipe) {
        return ResponseEntity.ok(recipeService.save(recipe));
}

@GetMapping("/{id}")
    public ResponseEntity<Recipe> getById(@PathVariable Long id) {
    return ResponseEntity.of(recipeService.getById(id));
}

}
