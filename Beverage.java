/*
 Program: Assignment #6
 Instructor: Gary Thai
 Summary of Description:
 This abstract class represents a general Beverage with a name, size, type, and base pricing used by all drink subclasses.
 Due Date: 12/7/2025
 Integrity Pledge:
 I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Student Name: Yousif Aluobaidy
*/

public abstract class Beverage {
    private String bevName;     // beverage name (e.g., "Latte")
    private Type type;          // beverage type (COFFEE, SMOOTHIE, ALCOHOL)
    private Size size;          // beverage size (SMALL, MEDIUM, LARGE)

    // Base price for all beverages and additional price for larger sizes
    protected static final double BASE_PRICE = 2.0;
    protected static final double SIZE_PRICE = 0.5;

    /**
     * Creates a Beverage with the given name, type, and size.
     */
    public Beverage(String bevName, Type type, Size size) {
        this.bevName = bevName;
        this.type = type;
        this.size = size;
    }

    /** Returns the beverage name. */
    public String getBevName() {
        return bevName;
    }

    /** Sets the beverage name. */
    public void setBevName(String s) {
        bevName = s;
    }

    /** Returns the type of beverage. */
    public Type getType() {
        return type;
    }

    /** Sets the beverage type. */
    public void setType(Type t) {
        type = t;
    }

    /** Returns the beverage size. */
    public Size getSize() {
        return size;
    }

    /** Sets the beverage size. */
    public void setSize(Size s) {
        size = s;
    }

    /**
     * Adds the additional cost based on the size of the beverage.
     * Medium adds one size price, Large adds two, and Small adds none.
     */
    public double addSizePrice() {
        if (this.size == Size.MEDIUM) {
            return SIZE_PRICE;
        }
        else if (this.size == Size.LARGE) {
            return SIZE_PRICE + SIZE_PRICE;
        }
        else {
            return 0.0;
        }
    }

    /**
     * Abstract method for calculating the final price of the beverage.
     * Each subclass (Coffee, Smoothie, Alcohol) implements its own logic.
     */
    public abstract double calcPrice();

    /**
     * Returns a String containing the beverage name and size.
     */
    @Override
    public String toString() {
        return String.format("%s, %s", bevName, size.toString());
    }

    /**
     * Checks if two Beverage objects are equal by comparing
     * their name, size, and type.
     */
    @Override 
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        else if (!(other instanceof Beverage)) {
            return false;
        }
        Beverage otherBev = (Beverage) other;
        return (bevName.equals(otherBev.bevName) 
                && type == otherBev.type 
                && size == otherBev.size);
    }
}
