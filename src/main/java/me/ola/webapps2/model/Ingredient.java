package me.ola.webapps2.model;

import lombok.*;

/**
 * Ингредиенты
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    private String name;
    private int count;
    private String measureUnit;
    @Override
    public String toString (){
        return name +" - " + count + " " + measureUnit;
    }

}

