/**
 * Assignment 6
 * BevShopDriverApp - Demonstration driver for BevShop project.
 * This program demonstrates:
 * - Creating new orders
 * - Age validation for alcohol
 * - Alcohol drink limit
 * - Adding Coffee, Smoothie, Alcohol
 * - Showing totals per order
 * - Showing total monthly sale
 * Student: Yousif Aluobaidy
 * Instructor: Gary Thai
 */

public class BevShopDriverApp {

    public static void main(String[] args) {

        BevShop shop = new BevShop();

        System.out.println("The current order in process can have at most " 
                + shop.getMaxOrderForAlcohol() + " alcoholic beverages.");

        System.out.println("The minimum age to order alcohol drink is " 
                + shop.getMinAgeForAlcohol());

        System.out.println("\n--- Start a New Order (Order 1) ---");
        shop.startNewOrder(10, Day.MONDAY, "John", 23);

        System.out.println("Your Total Order for now is " 
                + shop.getCurrentOrder().calcOrderTotal());

        System.out.println("Customer Name: " + shop.getCurrentOrder().getCustomer().getName());
        System.out.println("Customer Age: " + shop.getCurrentOrder().getCustomer().getAge());

        if (shop.isValidAge(shop.getCurrentOrder().getCustomer().getAge()))
            System.out.println("Your age is above 21 and you are eligible to order alcohol\n");

        // --- Alcohol #1 ---
        System.out.println("Adding an alcohol drink...");
        shop.processAlcoholOrder("Beer", Size.SMALL);
        System.out.println("Current drinks: " + shop.getCurrentOrder().getTotalItems());
        System.out.println("Total Price: " + shop.getCurrentOrder().calcOrderTotal() + "\n");

        // --- Alcohol #2 ---
        if (shop.isEligibleForMore()) {
            System.out.println("Adding a second alcohol drink...");
            shop.processAlcoholOrder("Whiskey", Size.MEDIUM);
            System.out.println("Current drinks: " + shop.getCurrentOrder().getTotalItems());
            System.out.println("Total Price: " + shop.getCurrentOrder().calcOrderTotal() + "\n");
        }

        // --- Alcohol #3 ---
        if (shop.isEligibleForMore()) {
            System.out.println("Adding a third alcohol drink...");
            shop.processAlcoholOrder("Vodka", Size.LARGE);
            System.out.println("Current drinks: " + shop.getCurrentOrder().getTotalItems());
            System.out.println("Total Price: " + shop.getCurrentOrder().calcOrderTotal() + "\n");
        }

        // --- Alcohol #4 (should NOT be allowed) ---
        if (!shop.isEligibleForMore()) {
            System.out.println("You have reached the maximum alcohol drinks for this order.\n");
        }

        // Add a Coffee
        System.out.println("Adding a COFFEE to your order...");
        shop.processCoffeeOrder("Latte", Size.MEDIUM, true, false);
        System.out.println("Total items in your order: " + shop.getCurrentOrder().getTotalItems());
        System.out.println("Total Price: " + shop.getCurrentOrder().calcOrderTotal());

        System.out.println("\n#------------------------------------#\n");

        // *************** START ORDER 2 ********************

        System.out.println("--- Start a New Order (Order 2) ---");
        shop.startNewOrder(13, Day.SUNDAY, "Ray", 18);

        System.out.println("Customer Name: Ray");
        System.out.println("Customer Age: 18");
        System.out.println("Total Price on Order: " + shop.getCurrentOrder().calcOrderTotal());

        // Add Smoothie
        System.out.println("\nAdding a SMOOTHIE to order...");
        shop.processSmoothieOrder("Detox", Size.MEDIUM, 3, true);
        System.out.println("Total Price: " + shop.getCurrentOrder().calcOrderTotal());

        // Add another Smoothie
        System.out.println("\nAdding another SMOOTHIE...");
        shop.processSmoothieOrder("Berry Blast", Size.LARGE, 2, false);
        System.out.println("Total Price: " + shop.getCurrentOrder().calcOrderTotal());

        // Add a Coffee
        System.out.println("\nAdding a COFFEE...");
        shop.processCoffeeOrder("Mocha", Size.SMALL, false, true);
        System.out.println("Total Price: " + shop.getCurrentOrder().calcOrderTotal());

        // Try adding Alcohol but age < 21
        System.out.println("\nTrying to add Alcohol...");
        if (!shop.isValidAge(shop.getCurrentOrder().getCustomer().getAge())) {
            System.out.println("Your Age is not appropriate for an alcohol drink!!");
        }

        // Max Fruits demonstration
        System.out.println("\nTotal fruits in last smoothie: 2 + 3 = 5");
        if (shop.isMaxFruit(5))
            System.out.println("You reached the Maximum number of fruits.");

        System.out.println("\nTotal price on second Order: " 
                + shop.getCurrentOrder().calcOrderTotal());

        System.out.println("\nTotal amount for all Orders: " 
                + shop.totalMonthlySale());
        System.out.println("Programmer: Yousif Aluobaidy");
    }
}
