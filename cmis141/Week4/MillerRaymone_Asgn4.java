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
        int input = getInput(
            "How high should the triangle be? ", "Height must be positive: ");
        buildTriangle(input);
        input = getInput(
            "How long should each side be? ", "length must be positive: ");
        buildDiamond(input);
    }

    public static void buildTriangle(int rows) {
        for(int rowNum = 0; rowNum < rows; rowNum++) {
            for(int rowLength = 0; rowLength <= rowNum; rowLength++)
                System.out.print("#");
            System.out.println();
        }
    }

    public static void buildDiamond(int sideLength) {
        for(int rowNum = 0; rowNum < sideLength - 1; rowNum++) {
            for(int rowLength = 0; rowLength <= sideLength + rowNum; rowLength++)
                if(rowLength < sideLength - rowNum)
                    System.out.print(" ");
                else
                    System.out.print("#");
            System.out.println();
        }
        for(int rowNum = sideLength - 1; rowNum >= 0; rowNum--) {
            for(int rowLength = 0; rowLength <= sideLength + rowNum; rowLength++)
                if(rowLength < sideLength - rowNum)
                    System.out.print(" ");
                else
                    System.out.print("#");
            System.out.println();
        }
    }

    public static int getInput(String prompt, String errorPrompt) {
        System.out.print(prompt);
        // open scanner with auto-close try-with-resources
        Scanner sc = new Scanner(System.in);
        int input = 0;  // initialize input to avoid compile error
        boolean goodInput = false;  // sentinal value
        do {
            try {  // wrap in try  to catch scanner exception
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