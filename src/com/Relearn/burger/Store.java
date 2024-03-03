package com.Relearn.burger;

public class Store {
    public static void main(String[] args) {
        var regularMeal = new Meal();
        System.out.println(regularMeal);

        var USRegularMeal = new Meal(0.68);
        System.out.println(USRegularMeal);
    }
}
