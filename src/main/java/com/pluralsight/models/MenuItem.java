package com.pluralsight.models;

public abstract class MenuItem implements Priceable {
    private final String name;

    public MenuItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getPrice();
}
