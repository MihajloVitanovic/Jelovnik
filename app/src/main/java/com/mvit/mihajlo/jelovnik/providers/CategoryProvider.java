package com.mvit.mihajlo.jelovnik.providers;

import com.mvit.mihajlo.jelovnik.model.Category;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mihajlo on 16-May-17.
 */

public class CategoryProvider {

    public static List<Category> getCategories() {

        List<Category> categories = new ArrayList<>();
        categories.add(new Category(0, "Appetizer"));
        categories.add(new Category(1, "Main Dish"));
        categories.add(new Category(2, "Dessert"));
        return categories;
    }

    public static List<String> getCategoryNames() {
        List<String> names = new ArrayList<>();
        names.add("Appetizer");
        names.add("Main Dish");
        names.add("Dessert");
        return names;
    }

    public static Category getCategoryById(int id) {
        switch (id) {
            case 0:
                return new Category(0, "Appetizer");
            case 1:
                return new Category(1, "Main Dish");
            case 2:
                return new Category(2, "Dessert");
            default:
                return null;
        }
    }
}
