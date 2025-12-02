/*
 Program: Assignment #6
 Instructor: Gary Thai
 Summary of Description:
 This class represents a Smoothie beverage in the BevShop program.
 Due Date: 12/7/2025
 Integrity Pledge:
 I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Student Name: Yousif Aluobaidy
*/

public class Smoothie extends Beverage {
    private int fruits;       // number of added fruits
    private boolean protein;  // true if protein powder is added

    /**
     * Creates a Smoothie with the given name, size, number of fruits,
     * and whether protein powder is added.
     */
    public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
        super(bevName, Type.SMOOTHIE, size);
        fruits = numOfFruits;
        protein = addProtein;
    }

    /** Returns the number of fruits added to the Smoothie. */
    public int getNumOfFruits() {
        return fruits;
    }

    /** Returns true if protein powder was added to the Smoothie. */
    public boolean getAddProtein() {
        return protein;
    }

    /**
     * Calculates the total price of the Smoothie.
     * Price includes the base price, size adjustment, fruit cost,
     * and extra cost if protein powder is added.
     */
    public double calcPrice() {
        if (protein) {
            return BASE_PRICE + addSizePrice() + 1.50 + (0.5 * fruits);
        }
        return BASE_PRICE + addSizePrice() + (0.5 * fruits);
    }

    /**
     * Returns a formatted String containing Smoothie information,
     * including size, number of fruits, protein choice, and total price.
     */
    @Override 
    public String toString() {
        return super.toString() 
                + ", Fruits: " + fruits 
                + ", Protein: " + protein 
                + ", Price: " + calcPrice();
    }

    /**
     * Checks if two Smoothie objects are equal by comparing the
     * inherited fields (name, size, type) and the Smoothie-specific
     * fields (number of fruits and protein choice).
     */
    @Override
    public boolean equals(Object other) {
        if (!(super.equals(other))) {
            return false;
        }
        else if (!(other instanceof Smoothie)) {
            return false;
        }
        Smoothie otherSmoothie = (Smoothie) other;
        return (fruits == otherSmoothie.fruits && protein == otherSmoothie.protein);
    }
}
