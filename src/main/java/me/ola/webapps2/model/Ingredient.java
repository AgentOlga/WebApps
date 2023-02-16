package me.ola.webapps2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Ингредиенты
 */
@Data
@AllArgsConstructor
public class Ingredient {
    private String name;
    private int count;
    private String measureUnit;

}

