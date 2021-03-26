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
    static final double WEIGHT_CONVERSION = 0.45;
    static final double HEIGHT_CONVERSION = 2.54;
    static final int BMI_CONVERSION = 10_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice;
        double pounds;
        double kilos;
        double inches;
        double centi;
        double bmi;
        do {
            choice = displayMenu(sc);
            switch(choice) {
                case WEIGHT:
                    System.out.print("\tEnter weight in pounds : ");
                    pounds = getUserDouble(sc);
                    kilos = poundsToKilograms(pounds);
                    System.out.printf("\t%.2f lbs = %.2f kg\n", pounds, kilos);
                    sc.nextLine();  // clear input buffer
                    break;
                case HEIGHT:
                    System.out.print("\tEnter height in inches : ");
                    inches = getUserDouble(sc);
                    centi = inchesToCentimeters(inches);
                    System.out.printf("\t%.2f inches = %.2f cm\n", inches, centi);
                    sc.nextLine();  // clear input buffer
                    break;
                case BMI:
                    System.out.print("\tEnter weight in kg and height in centimeters separated by space : ");
                    kilos = getUserDouble(sc);
                    centi = getUserDouble(sc);
                    bmi = getBMI(kilos, centi);
                    if(bmi < 18.5)
                        System.out.printf("\tBMI=%.2f Category=Underweight\n", bmi);
                    else if(bmi < 25.0)
                        System.out.printf("\tBMI=%.2f Category=Normal\n", bmi);
                    else if(bmi < 30.0)
                        System.out.printf("\tBMI=%.2f Category=Overweight\n", bmi);
                    else
                        System.out.printf("\tBMI=%.2f Category=Obese\n", bmi);
                    sc.nextLine();  // clear input buffer
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
            System.out.print("\nEnter your selection : ");
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

    public static double getUserDouble(Scanner sc) {
        double input = -1;
        boolean badInput = true;
        do {
            try {
                input = sc.nextDouble();
                if(input <= 0)
                    System.out.print("\tPlease enter a positive number: ");
                else
                    badInput = false;
            } catch(InputMismatchException e) {
                // user entered a non-number
                System.out.print("\tThat is not a number. Try again: ");
                sc.nextLine();  // clear scanner of bad input
            }
        }while(badInput);
        return input;
    }

    public static double poundsToKilograms(double pounds) {
        return pounds * WEIGHT_CONVERSION;
    }

    public static double inchesToCentimeters(double inches) {
        return inches * HEIGHT_CONVERSION;
    }

    public static double getBMI(double kilos, double centi) {
        return kilos / centi / centi * BMI_CONVERSION;
    }
}