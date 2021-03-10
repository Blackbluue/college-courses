/**
 * File: Assignment4.java
 * Author: Miller, Raymone
 * Class:  CMIS 141 – Assignment 4
 * Creation Date: (08MAR21)
 * Description: Prompts and evaluates user input for math equation.
 */
package com.miller.millerraymone_asgn2;

import java.util.Scanner;

public class MillerRaymone_Asgn2 {

    public static void main(String[] args) {
        // begin 'try' clause, 'catch' clauses to handle exceptions
        try {
            // get user input
            Object[] input = getUserInput();
            int num1 = (int) input[0];
            int num2 = (int) input[1];
            char symbol = (char) input[2];
            /*
            switch statement to control program flow
            4 cases for each arithmetic operator
            default case for catch all
            */
            switch(symbol) {
                case '+':
                    System.out.printf("Evaluation: %d %c %d = %d\n",
                        num1, symbol, num2, num1 + num2);
                    break;
                case '-':
                    System.out.printf("Evaluation: %d %c %d = %d\n",
                        num1, symbol, num2, num1 - num2);
                    break;
                case '*':
                    System.out.printf("Evaluation: %d %c %d = %d\n",
                        num1, symbol, num2, num1 * num2);
                    break;
                case '/':
                    if (num2 == 0)
                        System.out.println("Cannot divide by 0");
                    else
                        System.out.printf("Evaluation: %d %c %d = %f\n",
                            num1, symbol, num2, (double) num1 / num2);
                    break;
                default:  // this case should never happen
                    System.out.println("Error parsing input");
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            /*
            user entered less than 2 numbers
            note that 3+ numbers are ok ,extras are ignored
            */
            System.out.println("You did not enter enough numbers.");
        } catch(NumberFormatException e) {
            // user entered a non-number
            System.out.println(e.getMessage() + " is not a number");
        } catch(RuntimeException e) {
            // user entered an unknown operator
            System.out.println(e.getMessage());
        }
    }

    public static Object[] getUserInput() {
        // create scanner for user input
        Scanner sc = new Scanner(System.in);

        /*
        collect and validate user input for numbers
        Integer.parseInt() will throw NumberFormatException if wrong input
        */
        System.out.print("Enter two integer numbers separated by space: ");
        String[] input = sc.nextLine().split(" ");
        int num1 = Integer.parseInt(input[0]);
        int num2 = Integer.parseInt(input[1]);

        /*
        collect and validate user input for operator
        'if' conditional will generate RuntimeException if unknown operator
        */
        System.out.print("Enter operation symbol (+, -, *, or /): ");
        char symbol = sc.nextLine().charAt(0);
        if ("+-*/".indexOf(symbol) == -1)
            throw new RuntimeException(
                String.format("'%c' is not a valid operation", symbol));

        // return an array to hold all input since java cannot unpack variables
        return new Object[]{num1, num2, symbol};
    }
}
