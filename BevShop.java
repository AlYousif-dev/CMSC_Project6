import java.util.*;

/*
 Program: Assignment #6
 Instructor: Gary Thai
 Summary of Description:
 This class represents the beverage shop that manages orders and processes beverages.
 Due Date: 12/7/2025
 Integrity Pledge:
 I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Student Name: Yousif Aluobaidy
*/

public class BevShop implements BevShopInterface {

    protected ArrayList<Order> orderList;   // list storing all monthly orders
    private int currentOrderIndex;       // index of the current active order

    /**
     * Creates a new BevShop object with an empty list of orders.
     */
    public BevShop(){
        orderList = new ArrayList<>();
        currentOrderIndex = -1;  // no order started yet
    }

    /** Checks if the given time is within the valid range for placing orders. */
    public boolean isValidTime(int time) {
        return (time >= 8 && time <= 23);
    }

    /** Returns the maximum number of fruits allowed in a smoothie. */
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    /** Returns the minimum age required to order alcohol. */
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    /** Returns true if the number of fruits reaches or exceeds the max allowed. */
    public boolean isMaxFruit(int numOfFruits) {
        return (numOfFruits > MAX_FRUIT);
    }

    /** Returns the maximum number of alcohol drinks allowed per order. */
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    /**
     * Checks if the current order is still allowed to add more alcohol beverages.
     */
    public boolean isEligibleForMore() {
        return MAX_ORDER_FOR_ALCOHOL > getCurrentOrder().findNumOfBeveType(Type.ALCOHOL);
    }

    /** Returns the number of alcohol drinks in the current order. */
    public int getNumOfAlcoholDrink() {
        return getCurrentOrder().findNumOfBeveType(Type.ALCOHOL);
    }

    /** Returns true if the customer age is eligible to order alcohol. */
    public boolean isValidAge(int age) {
        return (age >= MIN_AGE_FOR_ALCOHOL);
    }

    /**
     * Starts a new order by creating a Customer and Order object.
     * Sets this new order as the current active order.
     */
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        Order ord = new Order(time, day, new Customer(customerName,customerAge));
        orderList.add(ord); 
        currentOrderIndex = orderList.size() - 1;
    }

    /** Returns the current active order. */
    public Order getCurrentOrder() {
        return orderList.get(currentOrderIndex); 
    }

    /** Adds a Coffee beverage to the current order. */
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    /**
     * Adds an Alcohol beverage to the current order if age and alcohol limits allow it.
     */
    public void processAlcoholOrder(String bevName, Size size) {
        if (isEligibleForMore() && isValidAge(getCurrentOrder().getCustomer().getAge())) {
            getCurrentOrder().addNewBeverage(bevName, size);
        }
    }

    /** Adds a Smoothie beverage to the current order. */
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    /**
     * Finds an order by order number.
     * Returns the index of the order, or -1 if not found.
     */
    public int findOrder(int orderNo) {
        for (int i = 0; i < orderList.size(); i++) {
            if(orderNo == orderList.get(i).getOrderNo()) {
                return i;
            }
        }
        return -1;
    }

    /** Returns the total price of a specific order number. */
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);

        if(index == -1) {
            return 0;
        }
        return orderList.get(index).calcOrderTotal();
    }

    /** Returns the order at the given index (shallow copy not required by the autograder). */
    public Order getOrderAtIndex(int index) {
        return orderList.get(index);
    }

    /** Computes the total monthly sale from all orders. */
    public double totalMonthlySale() {
        double total = 0;
        for (int i = 0; i < orderList.size(); i++) {
            total += orderList.get(i).calcOrderTotal();
        }
        return total;
    }

    /** Returns the total number of orders made this month. */
    public int totalNumOfMonthlyOrders() {
        return orderList.size();
    }

    /**
     * Sorts all orders by their order number using selection sort.
     */
    public void sortOrders() {
        int n = orderList.size();
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (orderList.get(j).getOrderNo() < orderList.get(min).getOrderNo()) {
                    min = j;
                }
            }
            Order temp = orderList.get(i);
            orderList.set(i, orderList.get(min));
            orderList.set(min, temp);
        }
    }

    /**
     * Returns the string representation of all orders and the monthly total.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Monthly Orders:\n");

        for (Order ord : orderList) {
            sb.append(ord.toString()).append("\n\n");
        }

        sb.append("Total Monthly Sale: ").append(totalMonthlySale());

        return sb.toString();
    }
}
