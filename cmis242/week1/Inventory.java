/**
 * File: Inventory.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Assignment 1
 * Creation Date: (17MAY21)
 * Description: Create a Book Inventory interface
 */

import java.util.Map;
import java.util.HashMap;

public class Inventory {
    private final Map<Integer, Book> bookShelf;

    /**
     * Construct a new Inventory object.
     */
    public Inventory() {
        this.bookShelf = new HashMap<>();
    }

    /**
     * Adds the book to the inventory. If the book already exists, it will not
     * be added again.
     *
     * @param book The book to add to the inventory.
     * @return True if the book was added to the inventory.
     */
    public boolean add(Book book) {
        if(book == null)
            throw new NullPointerException();

        return this.bookShelf.putIfAbsent(book.getId(), book) != null);
    }

    /**
     * Remove the book with the specified ID from the inventory.
     *
     * @param id The id of the book to remove.
     * @return The specified book, or null if not found.
     */
    public Book remove(int id) {
        return this.bookShelf.remove(id);
    }

    /**
     * Finds the book with the specified ID in the inventory and returns it.
     *
     * @param id The ID of the specified book.
     * @return The specified book, or null if not found.
     */
    public Book find(int id) {
        return this.bookShelf.get(id);
    }

    /**
     * Display every book in this inventory to the console.
     */
    public void display() {
        if(this.bookShelf.size() == 0)
            System.out.println("The inventory has no books");
        else
            for(Book book: this.bookShelf.values())
                book.display();
    }
}