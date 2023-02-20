package me.ola.webapps2.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;

import com.sun.jdi.connect.VMStartException;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import me.ola.webapps2.exception.ValidationException;
import me.ola.webapps2.model.Ingredient;
import me.ola.webapps2.service.IngredientService;
import me.ola.webapps2.service.ValidationService;

import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.*;
import java.util.HashMap;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {
    private static long idCounter = 1;
    private  Map<Long, Ingredient> ingredients = new HashMap<>();
    private  final ValidationService validationService;
    private final FileService fileService;
@Value("${patch.to.ingredients.file}")
private String ingredientsFilePatch;
@Value("${name.of.ingredients.file}")
private String ingredientsFileName;



    private Path ingredientsPatch;
    @Override
    public Ingredient save (Ingredient ingredient){
        if (!validationService.validate(ingredient)) {
        throw new ValidationException(ingredient.toString());
        }
        ingredients.put(idCounter++, ingredient );
        fileService.saveMapToFile(ingredients, ingredientsPatch);
        return ingredient;
    }
    @Override
    public Optional<Ingredient> getById(Long id) {
        return Optional.ofNullable(ingredients.get(id));
    }

    @Override
    public Ingredient update(Long id, Ingredient ingredient) {
        if (!validationService.validate(ingredient)) {
            throw new ValidationException(ingredient.toString());
        }

        ingredients.replace(id, ingredient);
        fileService.saveMapToFile(ingredients, ingredientsPatch);
        return  ingredient;

    }

    @Override
    public Ingredient delete(Long id) {
        fileService.saveMapToFile(ingredients, ingredientsPatch);
        Ingredient ingredient =  ingredients.remove(id);
        return ingredient;
    }

    @Override
    public Map<Long, Ingredient> getAll() {
        return ingredients;
    }

    @PostConstruct
    private void unit() {
       ingredientsPatch =  Path.of(ingredientsFilePatch, ingredientsFileName );
       ingredients = fileService.readMapFromFile(ingredientsPatch, new TypeReference<HashMap<Long, Ingredient>>(){});
    }

}
