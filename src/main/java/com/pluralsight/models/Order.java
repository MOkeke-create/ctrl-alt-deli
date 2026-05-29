package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private final ArrayList<MenuItem> items = new ArrayList<>();

    // ADD ITEM
    public void addItem(MenuItem item) {
        items.add(item);
    }

    // TOTAL PRICE
    public double getTotal() {

        return items.stream()
                .mapToDouble(item -> item.getPrice())
                .sum();
    }

    // CHECK IF ORDER HAS A SANDWICH
    public boolean hasSandwich() {

        return items.stream()
                .anyMatch(item -> item instanceof Sandwich);
    }

    // GET ALL SANDWICHES
    public List<Sandwich> getSandwiches() {

        return items.stream()
                .filter(item -> item instanceof Sandwich)
                .map(item -> (Sandwich) item)
                .collect(Collectors.toList());
    }

    // GET ALL DRINKS
    public List<Drink> getDrinks() {

        return items.stream()
                .filter(item -> item instanceof Drink)
                .map(item -> (Drink) item)
                .collect(Collectors.toList());
    }

    // GET ALL CHIPS
    public List<Chips> getChips() {

        return items.stream()
                .filter(item -> item instanceof Chips)
                .map(item -> (Chips) item)
                .collect(Collectors.toList());
    }

    // RETURN ALL ITEMS
    public ArrayList<MenuItem> getItems() {
        return items;
    }

    @Override
    public String toString() {

        String sandwiches = getSandwiches().stream()
                .map(Sandwich::toString)
                .collect(Collectors.joining("\n"));

        String drinks = getDrinks().stream()
                .map(Drink::toString)
                .collect(Collectors.joining("\n"));

        String chips = getChips().stream()
                .map(Chips::toString)
                .collect(Collectors.joining("\n"));

        return """
                ===== ORDER DETAILS =====

                --- Sandwiches ---
                %s

                --- Drinks ---
                %s

                --- Chips ---
                %s

                TOTAL: $%.2f
                """.formatted(
                sandwiches.isEmpty() ? "None" : sandwiches,
                drinks.isEmpty() ? "None" : drinks,
                chips.isEmpty() ? "None" : chips,
                getTotal()
        );
    }
}
