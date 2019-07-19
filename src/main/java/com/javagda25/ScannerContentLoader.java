package com.javagda25;

import java.util.Scanner;

public class ScannerContentLoader {
    private Scanner scanner = new Scanner(System.in);

    public void loadIngredients(IngredientsList ingredientsList) {
        String line = null;
        System.out.println("Please, add your ingredient: ");
        do {
            line = scanner.nextLine();
            if (!line.equalsIgnoreCase("end")) {
                ingredientsList.add(line);
            }
            if (line.equalsIgnoreCase("end")) {
                System.out.println("Did you end?");
                line = scanner.nextLine();
            }
        } while (!line.equalsIgnoreCase("yes"));

//        System.out.println(ingredientsList.toString());
    }


    public String askAboutPage(){
        System.out.println("Did you find your recipe?");
        String linia = scanner.nextLine();
        return linia;
    }
}
