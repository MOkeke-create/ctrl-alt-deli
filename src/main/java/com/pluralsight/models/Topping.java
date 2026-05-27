package com.pluralsight.models;

public class Topping{
    private String name;
    private boolean premium;
    private boolean extra;

    public Topping(String name, boolean premium, boolean extra) {
        this.name = name;
        this.premium = premium;
        this.extra = extra;
    }

    public String getName() {
        return name;
    }

    public boolean isPremium() {
        return premium;
    }

    public boolean isExtra() {
        return extra;
    }

    public double getPrice(String size) {

        if (!premium) {
            return 0;
        }

        double price = 0;

        switch (size) {

            case "4" -> price = 1.00;

            case "8" -> price = 2.00;

            case "12" -> price = 3.00;
        }

        if (extra) {
            price += 0.50;
        }

        return price;
    }

    @Override
    public String toString() {
        return name + (extra ? " (Extra)" : "");
    }
}
