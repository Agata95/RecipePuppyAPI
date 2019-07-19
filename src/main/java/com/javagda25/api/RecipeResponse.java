package com.javagda25.api;

import lombok.Data;

import java.util.List;

@Data
public class RecipeResponse {
    private String title;
    private double version;
    private String href;
    private List<Results> results;


}
