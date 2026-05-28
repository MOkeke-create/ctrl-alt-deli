package com.pluralsight.models;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Order {
    private ArrayList<MenuItem> items = new ArrayList<>();

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public double getTotal() {
        return items.stream()
                .mapToDouble(MenuItem::getPrice)
                .sum();
    }

    public boolean hasSandwich() {

        return items.stream()
                .anyMatch(item -> item instanceof Sandwich);
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        String orderDetails = items.stream()
                .map(MenuItem::toString)
                .collect(Collectors.joining("\n"));
        return """
        ===== ORDER DETAILS =====
        %s

        TOTAL: $%.2f
        """.formatted(orderDetails, getTotal());
    }
}
