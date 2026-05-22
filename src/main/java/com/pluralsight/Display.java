package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Display {static Scanner scanner = new Scanner(System.in);
    public void displayHomeScreen(){
        boolean running = true;
        while (running){
            System.out.println("\n===== Ctrl-alt-deli Sandwich Shop =====");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> orderScreen();

                case 0 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }

                default -> System.out.println("Invalid option.");
            }
        }

    }

    public static void orderScreen(){
        boolean ordering = true;

        while (ordering) {

            System.out.println("\n===== ORDER SCREEN =====");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1 -> addSandwich();

                case 2 -> addDrink();

                case 3 -> addChips();

                case 4 -> {
                    checkout();
                    ordering = false;
                }

                case 0 -> {
                    System.out.println("Order canceled.");
                    ordering = false;
                }

                default -> System.out.println("Invalid option.");
            }
        }
    }

    // ADD SANDWICH SCREEN
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

        // SIZE
        System.out.println("\nSelect sandwich size:");
        System.out.println("1) 4 inch");
        System.out.println("2) 8 inch");
        System.out.println("3) 12 inch");

        int sizeChoice = scanner.nextInt();
        scanner.nextLine();

        // MULTIPLE MEATS
        ArrayList<String> meats = new ArrayList<>();

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

                case 1 -> meats.add("Turkey");

                case 2 -> meats.add("Ham");

                case 3 -> meats.add("Roast Beef");

                case 4 -> meats.add("Chicken");

                case 0 -> choosingMeats = false;

                default -> System.out.println("Invalid option.");
            }
        }

        // MULTIPLE CHEESES
        ArrayList<String> cheeses = new ArrayList<>();

        boolean choosingCheese = true;

        while (choosingCheese) {

            System.out.println("\nChoose cheeses:");
            System.out.println("1) American");
            System.out.println("2) Swiss");
            System.out.println("3) Cheddar");
            System.out.println("4) Provolone");
            System.out.println("0) Done");

            int cheeseChoice = scanner.nextInt();
            scanner.nextLine();

            switch (cheeseChoice) {

                case 1 -> cheeses.add("American");

                case 2 -> cheeses.add("Swiss");

                case 3 -> cheeses.add("Cheddar");

                case 4 -> cheeses.add("Provolone");

                case 0 -> choosingCheese = false;

                default -> System.out.println("Invalid option.");
            }
        }

        // MULTIPLE TOPPINGS
        ArrayList<String> toppings = new ArrayList<>();

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

                case 1 -> toppings.add("Lettuce");

                case 2 -> toppings.add("Tomatoes");

                case 3 -> toppings.add("Onions");

                case 4 -> toppings.add("Pickles");

                case 5 -> toppings.add("Jalapeños");

                case 0 -> choosingToppings = false;

                default -> System.out.println("Invalid option.");
            }
        }

        // MULTIPLE SAUCES
        ArrayList<String> sauces = new ArrayList<>();

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

                case 1 -> sauces.add("Mayo");

                case 2 -> sauces.add("Mustard");

                case 3 -> sauces.add("Ranch");

                case 4 -> sauces.add("Chipotle");

                case 0 -> choosingSauces = false;

                default -> System.out.println("Invalid option.");
            }
        }

        // TOASTED
        System.out.print("\nWould you like the sandwich toasted? (yes/no): ");
        String toasted = scanner.nextLine();

        // DISPLAY ORDER SUMMARY
        System.out.println("\n===== SANDWICH SUMMARY =====");

        System.out.println("Bread Choice: " + breadChoice);
        System.out.println("Size Choice: " + sizeChoice);

        System.out.println("Meats: " + meats);
        System.out.println("Cheeses: " + cheeses);
        System.out.println("Toppings: " + toppings);
        System.out.println("Sauces: " + sauces);

        System.out.println("Toasted: " + toasted);

        System.out.println("\nSandwich added successfully!");
    }

    // ADD DRINK SCREEN
    public static void addDrink() {

        System.out.println("\n===== ADD DRINK =====");

        System.out.println("Select drink size:");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");

        int sizeChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nSelect drink flavor:");
        System.out.println("1) Coke");
        System.out.println("2) Sprite");
        System.out.println("3) Dr Pepper");
        System.out.println("4) Lemonade");

        int flavorChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nDrink added successfully!");
    }

    // ADD CHIPS SCREEN
    public static void addChips() {

        System.out.println("\n===== ADD CHIPS =====");

        System.out.println("Select chip type:");
        System.out.println("1) BBQ");
        System.out.println("2) Sour Cream & Onion");
        System.out.println("3) Cheddar");
        System.out.println("4) Salt & Vinegar");

        int chipChoice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nChips added successfully!");
    }

    // CHECKOUT SCREEN
    public static void checkout() {

        System.out.println("\n===== CHECKOUT =====");

        System.out.println("Order Details:");
        System.out.println("Sandwich: $10.50");
        System.out.println("Drink: $2.50");
        System.out.println("Chips: $1.50");

        double total = 10.50 + 2.50 + 1.50;

        System.out.printf("Total Price: $%.2f%n", total);

        System.out.println("\n1) Confirm");
        System.out.println("0) Cancel");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

            case 1 -> {
                System.out.println("Receipt created!");
                System.out.println("Returning to home screen...");
            }

            case 0 -> System.out.println("Order canceled.");

            default -> System.out.println("Invalid option.");
        }
    }
}
