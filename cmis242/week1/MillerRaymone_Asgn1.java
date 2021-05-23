/**
 * File: MillerRaymone_Asgn1.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Assignment 1
 * Creation Date: (17MAY21)
 * Description: Create a Book Inventory interface
 */

import java.util.Scanner;
import java.util.function.Predicate;

public class MillerRaymone_Asgn1 {
    public static final int EXIT = 0;
    public static final int ADD = 1;
    public static final int REMOVE = 2;
    public static final int FIND = 3;
    public static final int DISPLAY = 4;

    public static void main(String[] args) {
        // inventory for all books
        Inventory inventory = new Inventory();
        int choice;  // user choice for menu option

        // do..while loop to control program flow
        do {
            choice = displayMenu();
            switch(choice) {
                case ADD:  // add book
                    addBook(inventory);
                    break;
                case REMOVE:  // remove book
                    removeBook(inventory);
                    break;
                case FIND:  // find book
                    findBook(inventory);
                    break;
                case DISPLAY:  // display all books
                    displayBooks(inventory);
                    break;
                case EXIT:  // exit program
                    System.out.println("Thank you for using the book invnetory system.");
                    break;
                default:  // cannot interpret user choice
                    System.out.println("Choice not recognized");
                    break;
            }
        } while(choice != EXIT);
    }

    /**
     * Display the menu and get user input.
     *
     * @return The user's menu choice.
     */
    public static int displayMenu() {
        // display the menu
        System.out.println("\nPlease select one of the following options");
        System.out.println("(1) Add");
        System.out.println("(2) Remove");
        System.out.println("(3) Find");
        System.out.println("(4) Display");
        System.out.println("(0) Exit\n");

        // get user menu choice
        return (int) getUserNumber("Please select one of options above: ", input -> input < EXIT || input > DISPLAY);
    }

    /**
     * Add a book to the inventory. If a book with the specified id already exists in
     * the inventory, it will not be added again and an error message will be displayed
     * to the console.
     *
     * @param inventory The inventory of Books.
     */
    public static void addBook(Inventory inventory) {
        Scanner scan = new Scanner(System.in);

        System.out.println();
        // accept all id values, 'invalid' Predicate always returns false
        // caste to int, decimal values will be truncated
        int id = (int) getUserNumber("What is the ID of the book: ", input -> false);
        // get title of the book
        System.out.print("What is the title of the book: ");
        String title = scan.nextLine();
        // accept all price values, 'invalid' Predicate always returns false
        // negative prices will be set to 0 in Book class
        double price = getUserNumber("What is the price of the book: ", input -> false);

        if (!inventory.add(new Book(id, title, price)))
            System.out.println("Book already in the inventory");
    }

    /**
     * Removes the book with a specified ID from the inventory.
     * If the book was not in the inventory, an error message
     * will be displayed.
     *
     * @param inventory The inventory of books.
     */
    public static void removeBook(Inventory inventory) {
        // get user input
        int id = (int) getUserNumber("What is the ID of the book: ", input -> false);
        // remove book if found
        Book book = inventory.remove(id);
        // display outcome to console
        if(book != null)
            System.out.printf("\n\"%s\" was removed from the inventory", book.getTitle());
        else
            System.out.println("\nBook was not in the inventory");
    }

    /**
     * Finds the book with a specified ID in the inventory and displays
     * it to the console. If the book was not in the inventory,
     * an error message will be displayed.
     *
     * @param inventory The inventory of books.
     */
    public static void findBook(Inventory inventory) {
        // get user input
        int id = (int) getUserNumber("What is the ID of the book: ", input -> false);
        // look for the book in the invnetory
        Book book = inventory.find(id);
        // display the book if found, print error message if not
        System.out.println();
        if(book != null)
            book.display();
        else
            System.out.println("Book was not found");
    }

    /**
     * Display every book in the inventory to the console.
     *
     * @param inventory The inventory of books.
     */
    public static void displayBooks(Inventory inventory) {
        inventory.display();  // display every book in inventory
    }

    /**
     * Collect user numerical input. Returns a double value; cast to int if
     * required. invalid is a predicate used to test user input. It should
     * return true if user input is not valid, otherwise true. If input does not
     * need to be checked, it should always return false.
     *
     * @param prompt The prompt to gives the user before collecting input.
     * @param invalid A Predicate to check user input.
     * @return The user input.
     */
    public static double getUserNumber(
        String prompt, Predicate<Double> invalid) {
        Scanner scan = new Scanner(System.in);
        double input = -1;  // initialize input to prevent compile error
        boolean badInput = true;
        do {
            try {
                System.out.print(prompt);
                input = Double.valueOf(scan.nextLine());
                if(invalid.test(input))  // test input
                    System.out.println("\tValue is invalid. try again");
                else
                    badInput = false;
            } catch(NumberFormatException e) {
                // user entered a non-number
                System.out.println("\tThat is not a number. Try again");
            }
        } while(badInput);
        return input;
    }
 }
