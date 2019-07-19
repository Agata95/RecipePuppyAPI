package com.javagda25.api;

import lombok.Data;

@Data
public class Results {
    private RecipeResponse recipeResponse = new RecipeResponse();
    private String title;
    private String href;
    private String ingredients;
    private String thumbnail;

    @Override
    public String toString() {
        return title + ", web address: " + href + "\n";
    }
}
