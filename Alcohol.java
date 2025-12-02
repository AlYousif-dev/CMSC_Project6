/*
 Program: Assignment #6
 Instructor: Gary Thai
 Summary of Description:
 This class represents an Alcohol beverage and adds a weekend surcharge to the price when applicable.
 Due Date: 12/7/2025
 Integrity Pledge:
 I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Student Name: Yousif Aluobaidy
*/

public class Alcohol extends Beverage {
    private boolean weekend; // true if the drink is ordered on a weekend

    /**
     * Creates an Alcohol beverage with the given name, size, and weekend flag.
     */
    public Alcohol(String bevName, Size size, boolean isWeekend) {
        super(bevName, Type.ALCOHOL, size);
        weekend = isWeekend;
    }

    /** Returns true if the drink is ordered on a weekend. */
    public boolean isWeekend() {
        return weekend;
    }

    /**
     * Calculates the price of the Alcohol beverage.
     * Adds an extra 0.6 charge if ordered on the weekend.
     */
    public double calcPrice() {
        if (weekend) {
            return BASE_PRICE + addSizePrice() + 0.6;
        }
        return BASE_PRICE + addSizePrice();
    }

    /**
     * Returns a String listing the Alcohol drink's size, weekend flag, and total price.
     */
    @Override
    public String toString() {
        return super.toString() 
             + ", Weekend: " + weekend 
             + ", Price: " + calcPrice();
    }

    /**
     * Checks if two Alcohol objects are equal by comparing inherited fields
     * as well as the weekend flag.
     */
    @Override
    public boolean equals(Object other) {
        if (!(super.equals(other))) {
            return false;
        }
        else if (!(other instanceof Alcohol)) {
            return false;
        }
        Alcohol otherAlc = (Alcohol) other;
        return (weekend == otherAlc.weekend);
    }
}
