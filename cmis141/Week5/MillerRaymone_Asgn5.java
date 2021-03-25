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
                    System.out.print("\tEnter weight in pounds : ");
                    double pounds = getUserDouble(sc);
                    double kilos = poundsToKilograms(pounds);
                    System.out.printf("\t%.2f lbs = %.2f kg\n", pounds, kilos);
                    sc.nextLine();
                    break;
                case HEIGHT:
                    System.out.print("\tEnter height in inches : ");
                    double inches = getUserDouble(sc);
                    double centi = inchesToCentimeters(inches);
                    System.out.printf("\t%.2f inches = %.2f cm\n", inches, centi);
                    break;
                case BMI:
                    System.out.println("\tWorking!\n");
                    break;
                case QUIT:
                    System.out.println("\nThank you for using the program. Goodbye!");
                    break;
            }
        }while(!choice.equals(QUIT));
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
                    System.out.println("++" + choice + "++");
            }
        }while(badInput);
        return choice;
    }

    public static double getUserDouble(Scanner sc) {
        double input = -1;
        boolean badInput = true;
        do {
            try {
                input = sc.nextDouble();
                if(input <= 0)
                    System.out.print("Please enter a positive number: ");
                else
                    badInput = false;
            } catch(InputMismatchException e) {
                // user entered a non-number
                System.out.print("That is not a number. Try again: ");
                sc.nextLine();  // clear scanner of bad input
            }
        }while(badInput);
        return input;
    }

    public static double poundsToKilograms(double pounds) {
        return pounds;
    }

    public static double inchesToCentimeters(double inches) {
        return inches;
    }
}