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
        try {
            Object[] input = get_user_input();
            int num1 = (int) input[0];
            int num2 = (int) input[1];
            char symbol = (char) input[2];
            switch(symbol) {
                case '+':
                    System.out.printf("%d %c %d = %d\n",
                        num1, symbol, num2, num1 + num2);
                    break;
                case '-':
                    System.out.printf("%d %c %d = %d\n",
                        num1, symbol, num2, num1 - num2);
                    break;
                case '*':
                    System.out.printf("%d %c %d = %d\n",
                        num1, symbol, num2, num1 * num2);
                    break;
                case '/':
                    if (num2 == 0)
                        System.out.println("Cannot divide by 0");
                    else
                        System.out.printf("%d %c %d = %f\n",
                            num1, symbol, num2, (double) num1 / num2);
                    break;
                default:
                    System.out.println("Error parsing input");
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("You did not enter enough numbers.");
        } catch(NumberFormatException e) {
            System.out.println(e.getMessage() + " is not a number");
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Object[] get_user_input() {
        System.out.print("Enter two integer numbers separated by space: ");
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        int num1 = Integer.parseInt(input[0]);
        int num2 = Integer.parseInt(input[1]);

        System.out.print("Enter operation symbol (+, -, *, or /): ");
        char symbol = sc.nextLine().charAt(0);
        if ("+-*/".indexOf(symbol) == -1)
            throw new RuntimeException(
                String.format("'%c' is not a valid operation", symbol));

        return new Object[]{num1, num2, symbol};
    }
}
