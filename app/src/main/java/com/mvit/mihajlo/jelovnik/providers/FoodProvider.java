package com.mvit.mihajlo.jelovnik.providers;

import android.widget.ImageView;

import com.mvit.mihajlo.jelovnik.R;
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
        names.add("Capricciosa Pizza");
        names.add("Chicken Wings BBQ");
        names.add("Big Cheeseburger");
        names.add("Garden Salad");
        names.add("Fruit Ice Cream");
        return names;
    }

    public static Food getFoodById(int id) {

        Category predjelo = new Category(0, "Appetizer");
        Category glJelo = new Category(1, "Main Dish");
        Category dezert = new Category(2, "Dessert");

        switch (id) {
            case 0:
                return new Food(0,"pizza.png", "Capricciosa", "Pizza is a yeasted flatbread typically topped with tomato sauce and cheese and baked in an oven. It is commonly topped with a selection of meats, vegetables and condiments.", 4, glJelo);
            case 1:
                return new Food(1,"chicken.png", "Chicken BBQ", "Barbecue chicken consists of chicken parts or entire chickens that are barbecued, grilled or smoked. There are many global and regional preparation techniques and cooking styles.", 5, glJelo);
            case 2:
                return new Food(2,"burger.png", "Cheeseburger", "A cheeseburger is a hamburger topped with cheese. Traditionally, the slice of cheese is placed on top of the meat patty, but the burger can include many variations in structure, ingredients, and composition.", 4, glJelo);
            case 3:
                return new Food(3, "salad.png", "Garden Salad", "A salad is a dish consisting of a mixture of small pieces of food, usually featuring vegetables. They are typically served at room temperature or chilled, with notable exceptions such as south German potato salad which is served warm. Salads may contain virtually any type of ready-to-eat food.", 3, predjelo);
            case 4:
                return new Food(4, "icecream.png", "Ice Cream", "Ice cream is a sweetened frozen food typically eaten as a snack or dessert. It is usually made from dairy products, such as milk and cream, and often combined with fruits or other ingredients and flavors.", 5, dezert);
            case 5:
                return new Food(5, "logo.png", "logo", "logo", 3, glJelo);
            default:
                return null;
        }
    }


}