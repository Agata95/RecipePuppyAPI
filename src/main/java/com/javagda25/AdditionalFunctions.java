package com.javagda25;

public class AdditionalFunctions {
    ScannerContentLoader scannerContentLoader = new ScannerContentLoader();
    RecipePuppyAPI api = new RecipePuppyAPI();

    public void loadNextPage(String requestURL) {
        RecipePuppyURLBuilder builder = new RecipePuppyURLBuilder(requestURL);
        String asking = null;
        int digit = 2;
        do {
            asking = scannerContentLoader.askAboutPage();
            if (asking.equalsIgnoreCase("no")) {
//                builder.loadParameters(parameters);
                builder.appendIngreduents(requestURL);
                builder.changeURLNextPage(requestURL, digit);
                digit++;
                String newURL = builder.compileURL();
                System.out.println(newURL);
                api.loadURLbyInputStream(newURL).getResults().forEach(System.out::println);
            }
        } while (!asking.equalsIgnoreCase("yes"));
    }
}
