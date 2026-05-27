package com.pluralsight.models;

import java.util.ArrayList;

public class Order {
    private ArrayList<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double getTotal() {

        double total = 0;

        for (MenuItem item : items) {
            total += item.getPrice();
        }

        return total;
    }

    public boolean hasSandwich() {

        for (MenuItem item : items) {

            if (item instanceof Sandwich) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("\n===== ORDER DETAILS =====\n");

        for (MenuItem item : items) {
            sb.append(item).append("\n");
        }

        sb.append("\nTOTAL: $")
                .append(String.format("%.2f", getTotal()));

        return sb.toString();
    }
}
