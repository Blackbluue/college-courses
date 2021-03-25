/**
 * File: MillerRaymone_Asgn5.java
 * Author: Miller, Raymone
 * Class:  CMIS 141 - Assignment 5
 * Creation Date: (24MAR21)
 * Description: Uses methods to either convert pounds to kilograms,
                inches to meters, or determine BMI display category
                based on user input.
 */

package com.miller.millerraymone_asgn5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MillerRaymone_Asgn5 {
    static final String WEIGHT = "1";
    static final String HEIGHT = "2";
    static final String BMI = "3";
    static final String QUIT = "9";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            choice = displayMenu(sc);
            switch(choice) {
                case WEIGHT:
                    break;
                case HEIGHT:
                    break;
                case BMI:
                    break;
                case QUIT:
                    break;
                default:
                    System.out.println("Not a valid choice. Choose again.");
            }
        }while(!choice.equals(QUIT));
        System.out.println("Thank you for using the program. Goodbye!");
    }

    public static String displayMenu(Scanner sc) {
        String choice;
        boolean badInput = true;
        do {
            System.out.println("\n\tMENU");
            System.out.println("1: Convert pounds into kilograms");
            System.out.println("2: Convert height in inches to centimeters");
            System.out.println("3: Calculate BMI using weight in kilograms and display category");
            System.out.println("9: Exit program");
            System.out.print("\n Enter your selection : ");
            choice = sc.nextLine();
            switch(choice) {
                case WEIGHT:
                case HEIGHT:
                case BMI:
                case QUIT:
                    badInput = false;
                    break;
                default:
                    System.out.println("Not a valid choice. Choose again.");
            }
        }while(badInput);
        return choice;
    }

    public static double poundsToKilo() {
        double pounds;
        do {
            System.out.print("Enter weight in pounds :");
        }
    }
}