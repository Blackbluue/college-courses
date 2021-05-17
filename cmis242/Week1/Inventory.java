/**
 * File: Inventory.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Assignment 1
 * Creation Date: (17MAY21)
 * Description: Create a Book Inventory interface
 */

import java.util.Map;
import java.util.HashMap;
import Book;

public class Inventory {
    private final Map<Book> bookList;

    /**
     * Construct a new Inventory object.
     */
    public Inventory() {
        this.bookList = new HashMap<>();
    }

    /**
     * Adds the book to the inventory. If the book already exists, it will not
     * be added again and an error message will be displayed.
     *
     * @param book The book to add to the list.
     */
    public void add(Book book) {
        if(this.bookList.putIfAbsent(book.getId(), book) != null)
            System.out.println("Book already in the inventory");
    }

    /**
     * Remove the book with the specified ID from the inventory. If the book
     * was not in the inventory, an error message will be displayed.
     *
     * @param id The id of the book to remove.
     */
    public void remove(int id) {
        if(this.bookList.remove(id) == null)
            System.out.println("Book was not in the inventory");
    }

    /**
     * Finds the book with the specified id in the inventory and returns it.
     * If the book was not in the inventory, an error message will be displayed.
     *
     * @param The ID of the specified book.
     * @return The specified book, or null if not found.
     */
    public Book find(int id) {
        Book book = this.bookList.get(id);
        if(book == null)
            System.out.println("Book was not in the inventory");
        return book;
    }
}