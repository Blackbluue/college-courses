/**
 * File: MillerRaymone_Asgn4.java
 * Author: Miller, Raymone
 * Class:  CMIS 141 - Assignment 4
 * Creation Date: (19MAR21)
 * Description: 
 */

package com.miller.millerraymone_asgn4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MillerRaymone_Asgn4 {
    public static void main(String[] args) {
        // get user input for triangle
        int input = getInput(
            "How high should the triangle be? ", "Height must be positive: ");
        // build and print triangle
        buildTriangle(input);
        // get user input for diamond
        input = getInput(
            "How long should each side be? ", "length must be positive: ");
        // build and print diamond
        buildDiamond(input);
    }

    public static void buildTriangle(int rows) {
        // outer loop to count rows
        for(int rowNum = 0; rowNum < rows; rowNum++) {
            // inner loop to print characters in columns
            for(int rowLength = 0; rowLength <= rowNum; rowLength++)
                System.out.print("#");  // print character
            System.out.println();
        }
    }

    public static void buildDiamond(int sideLength) {
        // outer loop to count rows of top half of diamond
        for(int rowNum = 0; rowNum < sideLength - 1; rowNum++) {
            // inner loop to print characters in columns
            for(int rowLength = 0; rowLength <= sideLength + rowNum; rowLength++)
                if(rowLength < sideLength - rowNum)
                    System.out.print(" ");  // print character
                else
                    System.out.print("#");  // print character
            System.out.println();
        }
        // outer loop to count rows of bottom half of diamond
        for(int rowNum = sideLength - 1; rowNum >= 0; rowNum--) {
            // inner loop to print characters in columns
            for(int rowLength = 0; rowLength <= sideLength + rowNum; rowLength++)
                if(rowLength < sideLength - rowNum)
                    System.out.print(" ");  // print character
                else
                    System.out.print("#");  // print character
            System.out.println();
        }
    }

    public static int getInput(String prompt, String errorPrompt) {
        System.out.print(prompt);
        // open scanner for usre input
        Scanner sc = new Scanner(System.in);
        int input = 0;  // initialize input to avoid compile error
        boolean goodInput = false;  // sentinal value
        do {
            try {  // wrap in try to catch scanner exception
                input = sc.nextInt();
                // validate input
                if(input <= 0)
                    System.out.print(errorPrompt);
                else
                    goodInput = true;
            } catch(InputMismatchException e) {
                // user entered a non-number
                System.out.print("Please enter a whole number: ");
                sc.nextLine();  // clear scanner of bad input
            }
            
        }while(goodInput == false);
        // return input
        return input;
    }
 }