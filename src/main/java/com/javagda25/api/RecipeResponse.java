package com.javagda25.api;

import lombok.Data;

import java.util.List;

@Data
public class RecipeResponse {
    private String title;
    private double version;
    private String href;
    private List<Results> results;

    @Override
    public String toString() {
        final int[] value = new int[]{1};
        StringBuilder recipeList = new StringBuilder();

        results.forEach(p -> recipeList.append((value[0]++) + ". " + p.getTitle() + "\n"));

        return recipeList.toString();
    }
}
