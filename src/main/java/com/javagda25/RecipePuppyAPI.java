package com.javagda25;

import com.google.gson.Gson;
import com.javagda25.api.RecipeResponse;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class RecipePuppyAPI {
    private final static Gson GSON = new Gson();

    public RecipeResponse loadURLbyInputStream(String requestURL) {
        RecipeResponse recipeResponse = null;
        try {
            URL url = new URL(requestURL);
            recipeResponse = GSON.fromJson(new InputStreamReader(url.openStream()), RecipeResponse.class);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        recipeResponse.getResults()
                .forEach(r ->
                        r.setIngredients(StringEscapeUtils.unescapeHtml4(r.getIngredients())));
        return recipeResponse;
    }
}

