package me.ola.webapps2.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import me.ola.webapps2.exception.ValidationException;
import me.ola.webapps2.model.Ingredient;
import me.ola.webapps2.model.Recipe;
import me.ola.webapps2.service.RecipeService;
import me.ola.webapps2.service.ValidationService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Service
@RequiredArgsConstructor

public class RecipeServiceImpl implements RecipeService {
    private static long idCounter = 1;
    private  Map<Long, Recipe> recipes = new HashMap<>();
    private  final ValidationService validationService;
    private final FileService fileService;
    @Value("${patch.to.recipes.file}")
    private String recipesFilePatch;
    @Value("${name.of.recipes.file}")
    private String recipesFileName;



    private Path recipesPatch;


    @Override
    public Recipe save (Recipe recipe){
        if (!validationService.validate(recipe)) {
            throw new ValidationException(recipe.toString());
        }
        recipes.put(idCounter++, recipe );
        fileService.saveMapToFile(recipes, recipesPatch);

        return  recipe;
    }
    @Override
    public Optional<Recipe> getById(Long id) {
        return Optional.ofNullable(recipes.get(id));
    }

    @Override
    public Recipe update(Long id, Recipe recipe) {
        if (!validationService.validate(recipe)) {
            throw new ValidationException(recipe.toString());
        }
        recipes.replace(id, recipe);
        fileService.saveMapToFile(recipes, recipesPatch);
        return  recipe;
    }

    @Override
    public Recipe delete(Long id) {

      Recipe recipe = recipes.remove(id);
       fileService.saveMapToFile(recipes, recipesPatch);
       return recipe;
    }

    @Override
    public Map<Long, Recipe> getAll() {
        return recipes;
    }

    @Override
    public File readFile() {
        return recipesPatch.toFile();
    }

    @Override
    public void uploadFile(MultipartFile file) throws IOException {
        fileService.uploadFile(file, recipesPatch);
        recipes = fileService.readMapFromFile(recipesPatch, new TypeReference<Map<Long, Recipe>>(){});

    }

    @PostConstruct
    private void unit() {
        recipesPatch =  Path.of(recipesFilePatch, recipesFileName );
        recipes = fileService.readMapFromFile(recipesPatch, new TypeReference<Map<Long, Recipe>>(){});

    }
}
