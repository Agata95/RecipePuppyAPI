package com.javagda25;

import com.javagda25.api.RecipeResponse;
import com.javagda25.api.Results;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class BrowseOpener {
    public void browseOpener(RecipeResponse recipeResponse, int number) throws URISyntaxException {
        Results currentResult = recipeResponse.getResults().get(number - 1);

        // our URL address is :
//        System.out.println(currentResult.getHref());

        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI(currentResult.getHref()));
            } catch (IOException e) {
                System.err.println("I don't have recipe this number.");
            }
        }
    }
}
