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
     * Check if the other instance is equal to this one.
     *
     * @return True if other is equal to this instance, otherwise False.
     */
    public final boolean equals(Object other) {
        // self check
        if(this == other)
            return true;
        // type check and cast, and null check
        if(!(other instanceof Book) || other == null)
            return false;
        Book book = (Book) other;
        return Objects.equals(this.id, book.id);
    }

    /**
     * Return the hash code of this object.
     *
     * @return The hash code of this object.
     */
    public final int HashCode() {
        return Objects.hash(this.id);
    }
}