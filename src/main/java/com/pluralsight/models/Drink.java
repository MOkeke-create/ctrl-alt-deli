package com.pluralsight.models;

public class Drink extends MenuItem{
    private String size;

    public Drink(String flavor, String size) {

        super(flavor);

        this.size = size;
    }
    @Override
    public double getPrice() {

        return switch (size) {

            case "Small" -> 2.00;

            case "Medium" -> 2.50;

            case "Large" -> 3.00;

            default -> 0;
        };
    }
    @Override
    public String toString() {
        return getName() + " (" + size + ") - $" + getPrice();
    }
}
