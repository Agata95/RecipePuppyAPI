package com.javagda25;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class IngredientsList {
    private List<String> ingredientsList = new ArrayList<>();

    public void add(String line) {
        ingredientsList.add(line);
    }
}
