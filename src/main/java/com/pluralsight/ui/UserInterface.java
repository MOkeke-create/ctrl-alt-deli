package com.pluralsight.ui;

import com.pluralsight.data.ReceiptManager;
import com.pluralsight.models.*;

import java.util.Scanner;

public class UserInterface {static Scanner scanner = new Scanner(System.in);

    // CURRENT ACTIVE ORDER
    private static Order currentOrder;

    // HOME SCREEN
    public void displayHomeScreen() {

        boolean running = true;

        while (running) {

            System.out.println("\n===== Ctrl-Alt-Deli Sandwich Shop =====");
            System.out.println("1) New Order");
            System.out.println("0) Exit");

            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> {

                    // START NEW ORDER
                    currentOrder = new Order();

                    orderScreen();
                }

                case 0 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }

                default -> System.out.println("Invalid option.");
            }
        }
    }

    // ORDER SCREEN
    public static void orderScreen() {

        boolean ordering = true;

        while (ordering) {

            System.out.println("\n===== ORDER SCREEN =====");
            System.out.println("1) Add Custom Sandwich");
            System.out.println("2) Add Signature Sandwich");
            System.out.println("3) Add Drink");
            System.out.println("4) Add Chips");
            System.out.println("5) Checkout");
            System.out.println("0) Cancel Order");

            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> addSandwich();

                case 2 -> addSignatureSandwich();

                case 3 -> addDrink();

                case 4 -> addChips();

                case 5 -> {

                    if (currentOrder.getItems().isEmpty()) {

                        System.out.println("Your order is empty.");

                    } else {

                        checkout();

                        ordering = false;
                    }
                }

                case 0 -> {

                    currentOrder = null;

                    System.out.println("Order canceled.");

                    ordering = false;
                }

                default -> System.out.println("Invalid option.");
            }
        }
    }

    // ADD SANDWICH
    public static void addSandwich() {

        System.out.println("\n===== ADD SANDWICH =====");

        // BREAD
        System.out.println("Select your bread:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");

        int breadChoice = scanner.nextInt();
        scanner.nextLine();

        String bread = switch (breadChoice) {

            case 1 -> "Wheat";
            case 2 -> "Rye";
            case 3 -> "Wrap";

            default -> "White";
        };

        // SIZE
        System.out.println("\nSelect sandwich size:");
        System.out.println("1) 4 inch");
        System.out.println("2) 8 inch");
        System.out.println("3) 12 inch");

        int sizeChoice = scanner.nextInt();
        scanner.nextLine();

        String size = switch (sizeChoice) {

            case 1 -> "8";
            case 2 -> "12";

            default -> "4";
        };

        // TOASTED
        System.out.print("\nWould you like the sandwich toasted? (yes/no): ");

        String input = scanner.nextLine()
                .trim()
                .toLowerCase();

        boolean toasted = input.startsWith("y");

        // CREATE SANDWICH OBJECT
        Sandwich sandwich = new Sandwich(
                bread,
                size,
                toasted
        );

        // ADD TOPPINGS
        getMeats(sandwich);

        getCheeses(sandwich);

        getToppings(sandwich);

        getSauces(sandwich);

        // ADD TO ORDER
        currentOrder.addItem(sandwich);

        System.out.println("\nSandwich added successfully!");
    }

    // MEATS
    public static void getMeats(Sandwich sandwich) {

        boolean choosingMeats = true;

        while (choosingMeats) {

            System.out.println("\nChoose meats:");
            System.out.println("1) Turkey");
            System.out.println("2) Ham");
            System.out.println("3) Roast Beef");
            System.out.println("4) Chicken");
            System.out.println("0) Done");

            int meatChoice = scanner.nextInt();
            scanner.nextLine();

            switch (meatChoice) {

                case 1 -> sandwich.addTopping(
                        new Topping("Turkey", true, false)
                );

                case 2 -> sandwich.addTopping(
                        new Topping("Ham", true, false)
                );

                case 3 -> sandwich.addTopping(
                        new Topping("Roast Beef", true, false)
                );

                case 4 -> sandwich.addTopping(
                        new Topping("Chicken", true, false)
                );

                case 0 -> choosingMeats = false;

                default -> System.out.println("Invalid option.");
            }
        }
    }

    // CHEESES
    public static void getCheeses(Sandwich sandwich) {

        boolean choosingCheeses = true;

        while (choosingCheeses) {

            System.out.println("\nChoose cheeses:");
            System.out.println("1) American");
            System.out.println("2) Swiss");
            System.out.println("3) Cheddar");
            System.out.println("4) Provolone");
            System.out.println("0) Done");

            int cheeseChoice = scanner.nextInt();
            scanner.nextLine();

            switch (cheeseChoice) {

                case 1 -> sandwich.addTopping(
                        new Topping("American", true, false)
                );

                case 2 -> sandwich.addTopping(
                        new Topping("Swiss", true, false)
                );

                case 3 -> sandwich.addTopping(
                        new Topping("Cheddar", true, false)
                );

                case 4 -> sandwich.addTopping(
                        new Topping("Provolone", true, false)
                );

                case 0 -> choosingCheeses = false;

                default -> System.out.println("Invalid option.");
            }
        }
    }

    // TOPPINGS
    public static void getToppings(Sandwich sandwich) {

        boolean choosingToppings = true;

        while (choosingToppings) {

            System.out.println("\nChoose toppings:");
            System.out.println("1) Lettuce");
            System.out.println("2) Tomatoes");
            System.out.println("3) Onions");
            System.out.println("4) Pickles");
            System.out.println("5) Jalapeños");
            System.out.println("0) Done");

            int toppingChoice = scanner.nextInt();
            scanner.nextLine();

            switch (toppingChoice) {

                case 1 -> sandwich.addTopping(
                        new Topping("Lettuce", false, false)
                );

                case 2 -> sandwich.addTopping(
                        new Topping("Tomatoes", false, false)
                );

                case 3 -> sandwich.addTopping(
                        new Topping("Onions", false, false)
                );

                case 4 -> sandwich.addTopping(
                        new Topping("Pickles", false, false)
                );

                case 5 -> sandwich.addTopping(
                        new Topping("Jalapeños", false, false)
                );

                case 0 -> choosingToppings = false;

                default -> System.out.println("Invalid option.");
            }
        }
    }

    // SAUCES
    public static void getSauces(Sandwich sandwich) {

        boolean choosingSauces = true;

        while (choosingSauces) {

            System.out.println("\nChoose sauces:");
            System.out.println("1) Mayo");
            System.out.println("2) Mustard");
            System.out.println("3) Ranch");
            System.out.println("4) Chipotle");
            System.out.println("0) Done");

            int sauceChoice = scanner.nextInt();
            scanner.nextLine();

            switch (sauceChoice) {

                case 1 -> sandwich.addTopping(
                        new Topping("Mayo", false, false)
                );

                case 2 -> sandwich.addTopping(
                        new Topping("Mustard", false, false)
                );

                case 3 -> sandwich.addTopping(
                        new Topping("Ranch", false, false)
                );

                case 4 -> sandwich.addTopping(
                        new Topping("Chipotle", false, false)
                );

                case 0 -> choosingSauces = false;

                default -> System.out.println("Invalid option.");
            }
        }
    }

    // ADD DRINK
    public static void addDrink() {

        System.out.println("\n===== ADD DRINK =====");

        System.out.print("Enter drink flavor: ");
        String flavor = scanner.nextLine();

        System.out.print("Enter drink size (Small/Medium/Large): ");
        String size = scanner.nextLine();

        Drink drink = new Drink(flavor, size);

        currentOrder.addItem(drink);

        System.out.println("Drink added successfully!");
    }

    // ADD CHIPS
    public static void addChips() {

        System.out.println("\n===== ADD CHIPS =====");

        System.out.println("Select your chips:");
        System.out.println("1) BBQ");
        System.out.println("2) Sour Cream & Onion");
        System.out.println("3) Cheddar");
        System.out.println("4) Salt & Vinegar");
        System.out.println("5) Classic");
        System.out.println("0) Cancel");

        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        String chipType;

        switch (choice) {

            case 1 -> chipType = "BBQ";

            case 2 -> chipType = "Sour Cream & Onion";

            case 3 -> chipType = "Cheddar";

            case 4 -> chipType = "Salt & Vinegar";

            case 5 -> chipType = "Classic";

            case 0 -> {

                System.out.println("Chip selection canceled.");
                return;
            }

            default -> {

                System.out.println("Invalid option.");
                return;
            }
        }

        Chips chips = new Chips(chipType);

        currentOrder.addItem(chips);

        System.out.println(chipType + " chips added successfully!");
    }

    // CHECKOUT
    public static void checkout() {

        System.out.println("\n===== CHECKOUT =====");

        // DISPLAY ACTUAL ORDER
        System.out.println(currentOrder);

        System.out.println("\n1) Confirm");
        System.out.println("0) Cancel");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

            case 1 -> {

                ReceiptManager.saveReceipt(currentOrder);

                System.out.println("Receipt created!");
                System.out.println("Returning to home screen...");
            }

            case 0 -> System.out.println("Checkout canceled.");

            default -> System.out.println("Invalid option.");
        }
    }
    public static void customizeSignatureSandwich(Sandwich sandwich) {

        boolean customizing = true;

        while (customizing) {

            System.out.println("\n1) Add Topping");
            System.out.println("2) Finish");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> {

                    System.out.println("1) Lettuce");
                    System.out.println("2) Tomato");
                    System.out.println("3) Mayo");

                    int toppingChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (toppingChoice) {

                        case 1 -> sandwich.addTopping(
                                new Topping("Lettuce", false, false)
                        );

                        case 2 -> sandwich.addTopping(
                                new Topping("Tomato", false, false)
                        );

                        case 3 -> sandwich.addTopping(
                                new Topping("Mayo", false, false)
                        );
                    }
                }

                case 2 -> customizing = false;

                default -> System.out.println("Invalid option.");
            }
        }
    }
    public static void addSignatureSandwich() {

        System.out.println("\n===== SIGNATURE SANDWICHES =====");

        System.out.println("1) BLT");
        System.out.println("2) Philly Cheese Steak");

        int choice = scanner.nextInt();
        scanner.nextLine();

        Sandwich sandwich;

        switch (choice) {

            case 1 -> sandwich = new BLT();

            case 2 -> sandwich = new PhillyCheeseSteak();

            default -> {
                System.out.println("Invalid option.");
                return;
            }
        }

        System.out.println("\nCurrent Sandwich:");
        System.out.println(sandwich);

        System.out.print("\nWould you like to customize it? (yes/no): ");

        String customize = scanner.nextLine();

        if (customize.equalsIgnoreCase("yes")) {

            customizeSignatureSandwich(sandwich);
        }

        currentOrder.addItem(sandwich);

        System.out.println("\nSignature sandwich added!");
    }
}
