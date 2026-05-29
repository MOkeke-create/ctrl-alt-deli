package com.pluralsight.models;

public class BLT extends Sandwich{
    public BLT() {

        super("White", "8", true);

        addTopping(new Topping("Bacon", true, false));
        addTopping(new Topping("Cheddar", true, false));
        addTopping(new Topping("Lettuce", false, false));
        addTopping(new Topping("Tomato", false, false));
        addTopping(new Topping("Ranch", false, false));
    }

    @Override
    public String toString() {

        return """
                ===== BLT =====
                %s
                """.formatted(super.toString());
    }
}
