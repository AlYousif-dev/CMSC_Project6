/*
 Program: Assignment #6
 Instructor: Gary Thai
 Summary of Description:
 This class represents a single order in the BevShop program.
 It stores the order time, day, customer information, and a list of 
 beverages added to the order. The class also supports adding new 
 beverages, calculating the order total, checking weekend status, 
 and comparing orders by their order number.
 Due Date: 12/7/2025
 Integrity Pledge:
 I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Student Name: Yousif Aluobaidy
*/

import java.util.*;

public class Order implements OrderInterface, Comparable<Order> {
    private int orderNum;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> bevList = new ArrayList<Beverage>();

    /**
     * Creates a new Order with the given time, day, and customer.
     * Makes a deep copy of the customer and generates a random order number.
     */
    public Order(int orderTime, Day orderDay, Customer customer) {
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer); // deep copy
        orderNum = generateOrder();
    }

    /** Returns the order number. */
    public int getOrderNo() {
        return orderNum;
    }

    /** Returns the time the order was placed. */
    public int getOrderTime() {
        return orderTime;
    }

    /** Returns the day the order was placed. */
    public Day getOrderDay() {
        return orderDay;
    }

    /** Returns a deep copy of the customer who placed the order. */
    public Customer getCustomer() {
        return new Customer(customer);
    }

    /**
     * Generates a random order number between 10000 and 90000.
     * @return generated order number
     */
    public int generateOrder() {
        return new Random().nextInt(80000) + 10000;
    }

    /** Checks if the order was placed on a weekend. */
    public boolean isWeekend() {
        return (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY);
    }

    /** Returns the beverage at the given index. */
    public Beverage getBeverage(int itemNo) {
        return bevList.get(itemNo);
    }

    /** Returns the number of beverages in this order. */
    public int getTotalItems() {
        return bevList.size();
    }

    /**
     * Adds a new Alcohol beverage to the order.
     */
    public void addNewBeverage(String bevName, Size size) {
        Beverage alc = new Alcohol(bevName, size, isWeekend());
        bevList.add(alc);
    }

    /**
     * Adds a new Coffee beverage to the order.
     */
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        Beverage cof = new Coffee(bevName, size, extraShot, extraSyrup);
        bevList.add(cof);
    }

    /**
     * Adds a new Smoothie beverage to the order.
     */
    public void addNewBeverage(String bevname, Size size, int numOfFruits, boolean addProtein) {
        Beverage smooth = new Smoothie(bevname, size, numOfFruits, addProtein);
        bevList.add(smooth);
    }

    /**
     * Calculates the total cost of all beverages in this order.
     * @return total price of the order
     */
    public double calcOrderTotal() {
        double total = 0;

        // Add up the price of each beverage
        for (int i = 0; i < bevList.size(); i++) {
            total += bevList.get(i).calcPrice();
        }
        return total;
    }

    /**
     * Counts the number of beverages of a specific type in this order.
     */
    public int findNumOfBeveType(Type type) {
        int count = 0;

        // Count matching beverage types
        for (int i = 0; i < bevList.size(); i++) {
            if (bevList.get(i).getType() == type) {
                count++;
            }
        }
        return count;
    }

    /**
     * Builds a formatted String containing all the order details,
     * including customer info, beverages, and the total price.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Order Number: ").append(orderNum)
          .append(", Time: ").append(orderTime)
          .append(", Day: ").append(orderDay).append("\n");

        sb.append("Customer: ").append(customer.toString()).append("\n");

        sb.append("Beverages:\n");

        // List all beverages in the order
        for (Beverage b : bevList) {
            sb.append("   ").append(b.toString()).append("\n");
        }

        sb.append("Total Price: ").append(calcOrderTotal());

        return sb.toString();
    }

    /**
     * Compares two orders based on their order numbers.
     * @return 0 if equal, positive if greater, negative if smaller
     */
    @Override
    public int compareTo(Order other) {
        if (orderNum == other.orderNum) {
            return 0;
        } else if (orderNum > other.orderNum) {
            return 1;
        } else {
            return -1;
        }
    }
}
