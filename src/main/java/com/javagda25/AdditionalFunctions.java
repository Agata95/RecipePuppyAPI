package com.javagda25;

import com.javagda25.api.RecipeResponse;

public class AdditionalFunctions {
    ScannerContentLoader scannerContentLoader = new ScannerContentLoader();
    RecipePuppyAPI api = new RecipePuppyAPI();

    public void loadNextPage(String requestURL) {
        RecipePuppyURLBuilder builder = new RecipePuppyURLBuilder(requestURL);
        String asking;
        int digit = 2;
        do {
            asking = scannerContentLoader.askAboutPage();
            if (asking.equalsIgnoreCase("no")) {
                builder.appendIngreduents(requestURL);
                builder.changeURLNextPage(requestURL, digit);
                digit++;
                String newURL = builder.compileURL();
                System.out.println(newURL);

                // aby użyć toString z metody RecipeResponse :
                RecipeResponse response = api.loadURLbyInputStream(newURL);
                System.out.println(response.toString());
            }
        } while (!asking.equalsIgnoreCase("yes"));
    }
}
