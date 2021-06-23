/**
 * File: OrderSystem.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Assignment 2
 * Creation Date: (11JUN21)
 * Description: 
 */

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Predicate;

public class OrderSystem {
    // constants
    private static final int ORDER = 1;
    private static final int CHANGE = 2;
    private static final int DISPLAY = 3;
    private static final int EXIT = 9;

    private Map<String, Gift> gifts;
    private int choice;

    /**
     * Constructor for OrderSystem.
     */
    public OrderSystem() {
        gifts = new HashMap<>();
    }

    /**
     * Main method of program.
     *
     * @param args The program arguments.
     */
    public static void main(String[] args) {
        OrderSystem orders = new OrderSystem();

        // choose which menu option to run
        while(orders.choice != EXIT) {
            orders.displayMenu();
            switch(orders.choice) {
                case ORDER:
                    orders.orderGift();
                    break;
                case CHANGE:
                    orders.changeGift();
                    break;
                case DISPLAY:
                    orders.displayGift();
                    break;
                case EXIT:
                    System.out.println("\nThank you for using the program. Goodbye!");
                    break;
                default:
                    System.out.println("Choice not recognized");
                    break;
            }
        }
    }

    /**
     * Display the menu and get user input.
     */
    public void displayMenu() {
        // display the menu
        System.out.println("\n   MENU");
        System.out.println("1: Order a Gift Basket ");
        System.out.println("2: Change Gift Basket");
        System.out.println("3: Display Gift");
        System.out.println("9: Exit program\n");

        // get user menu choice
        this.choice = this.getUserNumber("Enter your selection : ", input -> input < ORDER || input > EXIT);
    }

    /**
     * Collect user input to order a gift.
     */
    public void orderGift() {
        String FRUIT = "1";  // constant for fruit basket
        String SWEET = "2";  // constant for sweets basket
        Scanner scan = new Scanner(System.in);
        boolean invalidInput = true;
        Gift gift;
        String giftType = "";
        String size = "";
        String includeExtraStr = "";
        boolean includeExtra;

        while(invalidInput) {
            System.out.print("Do you want Fruit Basket (1) or Sweets Basket (2): ");
            giftType = scan.nextLine();
            if(!giftType.equals(FRUIT) && !giftType.equals(SWEET))
                System.out.println("Not a valid choice");
            else
                invalidInput = false;
        }
        
        invalidInput = true;
        while(invalidInput) {
            System.out.print("What size do you want: S, M, or L: ");
            size = scan.nextLine();
            if(!List.of("S", "M", "L").contains(size.toUpperCase()))
                System.out.println("Not a valid choice");
            else
                invalidInput = false;
        }

        invalidInput = true;
        while(invalidInput) {
            if(giftType.equals(FRUIT))
                System.out.print("Do you want citrus fruits included? true/false: ");
            else
                System.out.print("Do you want nuts included? true/false: ");
            includeExtraStr = scan.nextLine();
            if(!includeExtraStr.equals("true") && !includeExtraStr.equals("false"))
                System.out.println("Not a valid choice");
            else
                invalidInput = false;
        }
        includeExtra = Boolean.valueOf(includeExtraStr);

        gift = giftType.equals(FRUIT) ?
            new FruitBasket(size, includeExtra) :
            new SweetsBasket(size, includeExtra);
        this.gifts.put(gift.getID(), gift);
    }

    /**
     * Change some attribute of an existing gift order.
     */
    public void changeGift() {
        if(this.gifts.isEmpty()) {
            System.out.println("No gift has been ordered yet");
            return;
        }
        Scanner scan = new Scanner(System.in);
        boolean invalidInput = true;
        Gift gift;
        String size = "";
        String includeExtraStr = "";

        System.out.print("Enter the Id of the gift you want to change: ");
        gift = this.gifts.get(scan.nextLine());
        if(gift == null) {
            System.out.println("Gift not found");
            return;
        }
        
        while(invalidInput) {
            System.out.printf("Current size is %s: What size do you want: S, M, or L: ", gift.getSize());
            size = scan.nextLine();
            if(!List.of("S", "M", "L").contains(size.toUpperCase()))
                System.out.println("Not a valid choice");
            else
                invalidInput = false;
        }
        gift.setSize(size);

        invalidInput = true;
        while(invalidInput) {
            if(gift instanceof FruitBasket)
                System.out.printf("Current basket citrus=%b Do you want citrus fruits included? true/false: ", ((FruitBasket) gift).isIncludeCitrus());
            else
                System.out.printf("Current basket nuts=%b Do you want nuts included? true/false: ", ((SweetsBasket) gift).isIncludeNuts());
            includeExtraStr = scan.nextLine();
            if(!includeExtraStr.equals("true") && !includeExtraStr.equals("false"))
                System.out.println("Not a valid choice");
            else
                invalidInput = false;
        }
        if(gift instanceof FruitBasket)
            ((FruitBasket) gift).setIncludeCitrus(Boolean.valueOf(includeExtraStr));
        else
            ((SweetsBasket) gift).setIncludeNuts(Boolean.valueOf(includeExtraStr));
    }

    /**
     * Display the details on all ordered gifts.
     */
    public void displayGift() {
        if(this.gifts.isEmpty()) {
            System.out.println("\nNo gift has been ordered yet");
        } else {
            System.out.println();
            for(Gift gift: this.gifts.values())
                System.out.println(gift);
        }
    }

    /**
     * Collect user numerical input. Returns an int value.
     * invalid is a predicate used to test user input. It should
     * return true if user input is not valid, otherwise true. If input does not
     * need to be checked, it should always return false.
     *
     * @param prompt The prompt to gives the user before collecting input.
     * @param invalid A Predicate to check user input.
     * @return The user input.
     */
    public int getUserNumber(
        String prompt, Predicate<Integer> invalid) {
        Scanner scan = new Scanner(System.in);
        int input = -1;  // initialize input to prevent compile error
        boolean badInput = true;
        do {
            try {
                System.out.print(prompt);
                input = Integer.valueOf(scan.nextLine());
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