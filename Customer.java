/*
 Program: Assignment #6
 Instructor: Gary Thai
 Summary of Description:
 This class stores basic customer information for the BevShop program.
 Due Date: 12/7/2025
 Integrity Pledge:
 I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
 Student Name: Yousif Aluobaidy
*/

public class Customer {
    private String name;
    private int age;

    /**
     * Creates a Customer with the given name and age.
     */
    public Customer(String n, int a) {
        name = n;
        age = a;
    }

    /**
     * Deep copy constructor. Creates a new Customer with the same
     * name and age as the provided Customer object.
     */
    public Customer(Customer other) {
        this.name = other.name;
        this.age = other.age;
    }

    /** Returns the customer's age. */
    public int getAge() {
        return age;
    }

    /** Sets the customer's age. */
    public void setAge(int a) {
        age = a;
    }

    /** Returns the customer's name. */
    public String getName() {
        return name;
    }

    /** Sets the customer's name. */
    public void setName(String n) {
        name = n;
    }

    /**
     * Returns a formatted String with the customer's name and age.
     */
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}
