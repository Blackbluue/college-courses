/**
 * File: Inventory.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Assignment 1
 * Creation Date: (17MAY21)
 * Description: Create a Book Inventory interface
 */

//package college_courses.cmis242.week1;

import java.util.Map;
import java.util.HashMap;

public class Inventory {
    private final Map<Book> bookShelf;

    /**
     * Construct a new Inventory object.
     */
    public Inventory() {
        this.bookShelf = new HashMap<>();
    }

    /**
     * Adds the book to the inventory. If the book already exists, it will not
     * be added again and an error message will be displayed.
     *
     * @param book The book to add to the inventory.
     * @return True if the book was added to the inventory.
     */
    public boolean add(Book book) {
        if(book == null) {
            System.out.println("Book cannot be null");
            return false;
        }
        if(this.bookShelf.putIfAbsent(book.getId(), book) != null) {
            System.out.println("Book already in the inventory");
            return false;
        }
        return true;
    }

    /**
     * Remove the book with the specified ID from the inventory. If the book
     * was not in the inventory, an error message will be displayed.
     *
     * @param id The id of the book to remove.
     * @return True if the book was in the inventory, and was sucessfully removed.
     */
    public boolean remove(int id) {
        if(this.bookShelf.remove(id) == null) {
            System.out.println("Book was not in the inventory");
            return false;
        }
        return true;
    }

    /**
     * Finds the book with the specified ID in the inventory and returns it.
     * If the book was not in the inventory, an error message will be displayed.
     *
     * @param The ID of the specified book.
     * @return The specified book, or null if not found.
     */
    public Book find(int id) {
        Book book = this.bookShelf.get(id);
        if(book == null)
            System.out.println("Book was not in the inventory");
        return book;
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