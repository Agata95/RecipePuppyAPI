package com.javagda25;

import com.javagda25.api.RecipeResponse;

import java.net.URISyntaxException;

public class AdditionalFunctions {
    ScannerContentLoader scannerContentLoader = new ScannerContentLoader();
    RecipePuppyAPI api = new RecipePuppyAPI();
    BrowseOpener browseOpener = new BrowseOpener();
    RecipeResponse response;

    public void loadNextPage(String requestURL) {
        RecipePuppyURLBuilder builder = new RecipePuppyURLBuilder(requestURL);
        builder.appendIngreduents(requestURL);

        String asking;
        int digit = 2;
        System.out.println("If you want to leave this application right now, write 'quit'.");
        do {
            asking = scannerContentLoader.askAboutPage();
            if (asking.equalsIgnoreCase("no")) {
                builder.changeURLNextPage(requestURL, digit);
                digit++;
                String newURL = builder.compileURL();
                System.out.println(newURL);

                // I want to use 'toString' method from RecipeResponse :
                response = api.loadURLbyInputStream(newURL);
                System.out.println(response.toString());
            }
            if (asking.equalsIgnoreCase("yes")) {
                String newURL = builder.compileURL();
                response = api.loadURLbyInputStream(newURL);
                int number = scannerContentLoader.askAboutNoRecipe();
                try {
                    browseOpener.browseOpener(response, number);
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                break;
            }
        } while (!asking.equalsIgnoreCase("quit"));
    }
}
