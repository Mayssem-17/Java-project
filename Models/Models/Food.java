package Models;

import java.util.Arrays;

public class Food extends Item {
    private String[] ingredients;

    public Food(String name, Float price, String[] ingredients) {
        super(name, price);
        this.ingredients = ingredients;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(String ingredient) {
        // check if ingredient is already in array
        for (String i : ingredients) {
            if (i.equals(ingredient)) {
                return;
            }
        }

        // if ingredient not already in array, add it
        String[] newIngredients = new String[ingredients.length + 1];
        for (int i = 0; i < ingredients.length; i++) {
            newIngredients[i] = ingredients[i];
        }
        newIngredients[newIngredients.length - 1] = ingredient;
        ingredients = newIngredients;
    }

    public void removeIngredient(String ingredient) {
        // check if ingredient is in array
        boolean found = false;
        int index = 0;
        for (int i = 0; i < ingredients.length; i++) {
            if (ingredients[i].equals(ingredient)) {
                found = true;
                index = i;
                break;
            }
        }

        // if ingredient is in array, remove it
        if (found) {
            String[] newIngredients = new String[ingredients.length - 1];
            for (int i = 0, j = 0; i < ingredients.length; i++) {
                if (i == index) {
                    continue;
                }
                newIngredients[j++] = ingredients[i];
            }
            ingredients = newIngredients;
        }
    }

    @Override
    public String toString() {
        return  getName() + "......................"+getPrice()+"dt"+"\ningredients=" + Arrays.toString(ingredients);
    }
    
    

}
