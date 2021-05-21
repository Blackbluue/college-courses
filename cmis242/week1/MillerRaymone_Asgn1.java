/**
 * File: MillerRaymone_Asgn1.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Assignment 1
 * Creation Date: (17MAY21)
 * Description: Create a Book Inventory interface
 */

import java.util.Scanner;
import java.util.InputMismatchException;
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
                case ADD:
                    addBook(inventory);
                    break;
                case REMOVE:
                    removeBook(inventory);
                    break;
                case FIND:
                    findBook(inventory);
                    break;
                case DISPLAY:
                    displayBooks(inventory);
                    break;
                case EXIT:
                    System.out.println("Thank you for using the book invnetory system.");
                    break;
                default:
                    System.out.println("Choice not recognized");
                    break;
            }
        } while(choice != EXIT);
    }

    public static int displayMenu() {
        System.out.println("Please select one of the following options");
        System.out.println("(1) Add");
        System.out.println("(2) Remove");
        System.out.println("(3) Find");
        System.out.println("(4) Display");
        System.out.println("(0) Exit");

        return (int) getUserNumber("Please select one of options above: ", input -> input < EXIT || input > DISPLAY);
    }

    public static void addBook(Inventory inventory) {
        Scanner scan = new Scanner(System.in);

        int id = (int) getUserNumber("What is the ID of the book: ", input -> true);
        System.out.print("What is the title of the book: ");
        String title = scan.nextLine();
        double price = getUserNumber("What is the price of the book: ", input -> true);

        Book book = new Book(id, title, price);
        inventory.add(book);
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
        int id = (int) getUserNumber("What is the ID of the book: ", input -> true);
        // remove book if found
        Book book = inventory.remove(id);
        // display outcome to console
        if(book)
            Systme.out.printf("%s was removed from the inventory", book.getTitle());
        else
            System.out.println("Book was not in the inventory");
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
        int id = (int) getUserNumber("What is the ID of the book: ", input -> true);
        // look for the book in the invnetory
        Book book = inventory.find(id);
        // display the book if found, print error message if not
        if(book)
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
            } catch(InputMismatchException e) {
                // user entered a non-number
                System.out.println("\tThat is not a number. Try again");
                scan.nextLine();  // clear scanner of bad input
            }
        } while(badInput);
        return input;
    }

 }