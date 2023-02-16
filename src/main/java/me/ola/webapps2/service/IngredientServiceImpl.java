package me.ola.webapps2.service;

import com.sun.jdi.connect.VMStartException;
import me.ola.webapps2.exception.ValidationException;
import me.ola.webapps2.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class IngredientServiceImpl implements IngredientService {
    private static long idCounter = 1;
    private final Map<Long, Ingredient> ingredients = new HashMap<>();
    private  final ValidationService validationService;

    public IngredientServiceImpl(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public Ingredient save (Ingredient ingredient){
        if (!validationService.validate(ingredient)) {
        throw new ValidationException(ingredient.toString());
        }
        return ingredients.put(idCounter++, ingredient );
    }
    @Override
    public Optional<Ingredient> getById(Long id) {
        return Optional.ofNullable(ingredients.get(id));
    }
}
