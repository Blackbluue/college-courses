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
        Inventory inventory = new Inventory();
        int choice;

        do {
            choice = displayMenu();
            switch(choice) {
                case ADD:
                    //add new book
                    break;
                case REMOVE:
                    //remove book
                    break;
                case FIND:
                    //find book
                    break;
                case DISPLAY:
                    //display all books
                    break;
                case EXIT:
                    //exit program
                    break;
                default:
                    System.out.println("Choice not recognized");
                    break;
            }
        } while(choice != EXIT);
    }

    public static int displayMenu() {
        Scanner scan = new Scanner(System.in);
        boolean badInput = true;
        int choice;

        do {
            System.out.println("Please select one of the following options");
            System.out.println("(1) Add");
            System.out.println("(2) Remove");
            System.out.println("(3) Find");
            System.out.println("(4) Display");
            System.out.println("(0) Exit");

            choice = (int) getUserNumber("Please select one of options above: ", input -> input < EXIT || input > DISPLAY);
            
        } while(badInput);
        return choice;
    }

    public static void addBook(Inventory inventory) {

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