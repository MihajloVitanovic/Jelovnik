package com.mvit.mihajlo.jelovnik.providers;

import com.mvit.mihajlo.jelovnik.model.Category;
import com.mvit.mihajlo.jelovnik.model.Food;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mihajlo on 16-May-17.
 */

public class FoodProvider {

    public static List<String> getFoodNames() {

        List<String> names = new ArrayList<>();
        names.add("Apples");
        names.add("Bananas");
        names.add("Oranges");
        return names;
    }

    public static Food getFoodById(int id) {

        Category rose = new Category(0, "Rose");
        Category citrus = new Category(1, "Citrus");
        Category berry = new Category(2, "Berry");

        switch (id) {
            case 0:
                return new Food(0,"pizza.png", "Pizza", "Big slice of pizza", 5, rose);
            case 1:
                return new Food(1,"pizza.png", "Pizza", "Big slice of pizza", 5, rose);
            case 2:
                return new Food(2,"pizza.png", "Pizza", "Big slice of pizza", 5, rose);
            default:
                return null;
        }
    }


}