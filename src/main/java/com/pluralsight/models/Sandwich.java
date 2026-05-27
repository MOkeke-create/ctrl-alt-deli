package com.pluralsight.models;

import java.util.ArrayList;

public class Sandwich extends MenuItem{
    private String bread;
    private String size;
    private boolean toasted;

    private ArrayList<Topping> toppings = new ArrayList<>();

    public Sandwich(String bread, String size, boolean toasted) {

        super(size + "\" Sandwich");

        this.bread = bread;
        this.size = size;
        this.toasted = toasted;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    @Override
    public double getPrice() {

        double basePrice = 0;

        switch (size) {

            case "4" -> basePrice = 5.50;

            case "8" -> basePrice = 7.00;

            case "12" -> basePrice = 8.50;
        }

        for (Topping topping : toppings) {
            basePrice += topping.getPrice(size);
        }

        return basePrice;
    }

    @Override
    public String toString() {

        return """
                Sandwich:
                Bread: %s
                Size: %s"
                Toasted: %s
                Toppings: %s
                Price: $%.2f
                """.formatted(
                bread,
                size,
                toasted ? "Yes" : "No",
                toppings,
                getPrice()
        );
    }
}
