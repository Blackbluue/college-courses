/**
 * File: Book.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Assignment 1
 * Creation Date: (17MAY21)
 * Description: Create a Book Inventory interface
 */

public class Book {
    private final int id;
    private final String title;
    private final double price;

    /**
     * Construct a Book object. A negative price will default to 0.
     *
     * @param id The unique ID of the book.
     * @param title The title of the book.
     * @param price The price of the book.
     */
    public Book(int id, String title, double price) {
        this.id = id;
        this.title = title;
        // a negative price will default to 0
        this.price = price <= 0 ? 0 : price;
    }

    /**
     * Return the ID of this book.
     *
     * @return TheID of this book.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Return the title of this book.
     *
     * @return The title of this book.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Return the price of this book.
     *
     * @return the price of this book.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Display the details of this book to the console.
     */
    public void display() {
        System.out.printf("[Book ID = %d; ", this.id);
        System.out.printf("Book Title = \"%s\"; ", this.title);
        System.out.printf("Book Price = $%.2f]\n", this.price);
    }
}