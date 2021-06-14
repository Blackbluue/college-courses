/**
 * File: OrderSystem.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Assignment 2
 * Creation Date: (11JUN21)
 * Description: 
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class OrderSystem {
    private final int ORDER = 1;
    private final int CHANGE = 2;
    private final int DISPLAY = 3;
    private final int EXIT = 9;

    private Map<String, Gift> gifts;
    private int choice;

    public OrderSystem() {
        gifts = new HashMap<>();
    }

    public static void main(String[] args) {
        OrderSystem orders = new OrderSystem();

        while(orders.choice != orders.EXIT) {
            orders.displayMenu();
            switch(orders.choice) {
                case orders.ORDER:
                    orders.orderGift();
                    break;
                case orders.CHANGE:
                    orders.changeGift();
                    break;
                case orders.DISPLAY:
                    orders.displayGift();
                    break;
                case orders.EXIT:
                    System.out.println("Thank you for using our order system!");
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
        this.choice = this.getUserNumber("Enter your selection : ", input -> input < EXIT || input > DISPLAY);
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
        String giftType;
        String size;
        boolean includeExtra;

        while(invalidInput) {
            System.out.print("Do you want Fruit Basket (1) or Sweets Basket (2): ");
            giftType = scan.nextLine();
            if(!giftType.equals(FRUIT) || !giftType.equals(SWEET))
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
            includeExtraString = scan.nextLine();
            if(!includeExtraStr.equals("true") || !includeExtraStr.equals("false"))
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

    public void changeGift() {
        Scanner scan = new Scanner(System.in);
        boolean invalidInput = true;
        Gift gift;
        String size;
        boolean includeExtra;

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