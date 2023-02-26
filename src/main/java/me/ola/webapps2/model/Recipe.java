package me.ola.webapps2.model;

import lombok.*;

import java.util.List;


/**
 * Рецепт
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

public class Recipe {
    private String nameRecipe;
    private int cookingTime;
    private List<Ingredient> ingredients;
    private List<String> steps;

    @Override
    public String toString(){
        return  nameRecipe + "\n Время приготовления: " + cookingTime;
























    }
}
