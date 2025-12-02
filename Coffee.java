/*
 Program: Assignment #6
 Instructor: Gary Thai
 Summary of Description:
 This class represents a Coffee beverage with options for extra shot and extra syrup.
 Due Date: 12/7/2025
 Integrity Pledge:
 I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Student Name: Yousif Aluobaidy
*/

public class Coffee extends Beverage {
    private boolean xtShot;   // true if extra shot is added
    private boolean xtSyrup;  // true if extra syrup is added

    /**
     * Creates a Coffee object with the given size and add-on options.
     */
    public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        super(bevName, Type.COFFEE, size);
        xtShot = extraShot;
        xtSyrup = extraSyrup;
    }

    /** Returns true if extra shot was added. */
    public boolean getExtraShot() {
        return xtShot;
    }

    /** Returns true if extra syrup was added. */
    public boolean getExtraSyrup() {
        return xtSyrup;
    }

    /**
     * Calculates the price of the Coffee based on size and add-on selections.
     */
    public double calcPrice() {
        if (xtShot && xtSyrup) {
            return BASE_PRICE + addSizePrice() + 1.0;
        }
        else if (xtShot || xtSyrup) {
            return BASE_PRICE + addSizePrice() + 0.5;
        }
        return BASE_PRICE + addSizePrice();
    }

    /**
     * Returns a String listing the Coffee's size, add-ons, and final price.
     */
    @Override 
    public String toString() {
        return super.toString() 
             + ", Extra Shot: " + xtShot 
             + ", Extra Syrup: " + xtSyrup 
             + ", Price: " + calcPrice();
    }

    /**
     * Checks if two Coffee objects are equal by comparing inherited fields
     * as well as extra shot and extra syrup values.
     */
    @Override
    public boolean equals(Object other) {
        if (!(super.equals(other))) {
            return false;
        }
        else if (!(other instanceof Coffee)) {
            return false;
        }
        Coffee otherCoffee = (Coffee) other;
        return (xtShot == otherCoffee.xtShot && xtSyrup == otherCoffee.xtSyrup);
    }
}
