package com.javagda25;

public class RecipePuppyURLBuilder {
    private final StringBuilder builder;

    public RecipePuppyURLBuilder(String url) {
        builder = new StringBuilder(url);
    }

    public void appendIngreduents(String line) {
        if (builder.toString().contains("{ingredients}")) {
            int pozycjaIngredients = builder.indexOf("{ingredients}");
            builder.replace(pozycjaIngredients, pozycjaIngredients + 13, String.valueOf(line));
        }
    }

    public String parseAllLine(IngredientsList ingredientsList) {
        String line = "";
        for (String s : ingredientsList.getIngredientsList()) {
            line += s + ",";
        }
        System.out.println(line);
        return line;
    }

    public String compileURL() {
        return builder.toString();
    }

    public void changeURLNextPage(String line, int digit) {
        int positionOfValue = builder.indexOf("&p=");
        String value = String.valueOf(digit);
        builder.replace(positionOfValue + 3, builder.length(), value);
    }


    @Override
    public String toString() {
        return "APIRecipeURLBuilder{" +
                "builder=" + builder +
                '}';
    }
}
