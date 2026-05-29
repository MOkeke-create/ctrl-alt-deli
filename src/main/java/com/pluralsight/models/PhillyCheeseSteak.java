package com.pluralsight.models;

public class PhillyCheeseSteak extends Sandwich{public PhillyCheeseSteak() {

    super("White", "8", true);

    addTopping(new Topping("Steak", true, false));
    addTopping(new Topping("American Cheese", true, false));
    addTopping(new Topping("Jalapeños", false, false));
    addTopping(new Topping("Mayo", false, false));
}

    @Override
    public String toString() {

        return """
                ===== Philly Cheese Steak =====
                %s
                """.formatted(super.toString());
    }
}
