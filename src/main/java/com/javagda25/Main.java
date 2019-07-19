package com.javagda25;

public class Main {
    public static void main(String[] args) {
        ScannerContentLoader scannerContentLoader = new ScannerContentLoader();
        IngredientsList ingredientsList = new IngredientsList();
        final String BASE_URL = "http://www.recipepuppy.com/api/?i={ingredients}&p=1";
        RecipePuppyURLBuilder builder = new RecipePuppyURLBuilder(BASE_URL);
        AdditionalFunctions additionalFunctions = new AdditionalFunctions();

        scannerContentLoader.loadIngredients(ingredientsList);
        String lineOfIngredients = builder.parseAllLine(ingredientsList);
        builder.appendIngreduents(lineOfIngredients);

        System.out.println("\n I am searching...\n");
        String requestURL = builder.compileURL();
        System.out.println(requestURL);

        RecipePuppyAPI api = new RecipePuppyAPI();

        System.out.println("\n Your recipes list: \n");
        api.loadURLbyInputStream(requestURL).getResults().forEach(System.out::println);

        additionalFunctions.loadNextPage(requestURL);
    }


}
