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
        categories.add(new Category(0, "Predjelo"));
        categories.add(new Category(1, "Glavno jelo"));
        categories.add(new Category(2, "Dezert"));
        return categories;
    }

    public static List<String> getCategoryNames() {
        List<String> names = new ArrayList<>();
        names.add("Predjelo");
        names.add("Glavno jelo");
        names.add("Dezert");
        return names;
    }

    public static Category getCategoryById(int id) {
        switch (id) {
            case 0:
                return new Category(0, "Predjelo");
            case 1:
                return new Category(1, "Glavno jelo");
            case 2:
                return new Category(2, "Dezert");
            default:
                return null;
        }
    }
}
