package com.mvit.mihajlo.jelovnik.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mihajlo on 16-May-17.
 */

public class Category {

    private int id;
    private String name;
    private List<Food> foodList;

    public Category(){
        foodList = new ArrayList<>();
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        foodList = new ArrayList<>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
