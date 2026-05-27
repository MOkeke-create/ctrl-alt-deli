package com.pluralsight.models;

public class Chips extends MenuItem{
    public Chips(String type) {
        super(type);
    }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String toString() {
        return getName() + " - $" + getPrice();
    }
}
