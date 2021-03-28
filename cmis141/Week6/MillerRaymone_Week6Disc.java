 /**
  * File: MillerRaymone_Week6Disc.java
  * Author: Miller, Raymone
  * Class:  CMIS 141 - Discussion 6
  * Creation Date: (22MAR21)
  * Description: ask user for dimensions, then print a cube and calculate volume
  */

package com.miller.millerraymone_week6disc;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MillerRaymone_Week6Disc {
    public static void main(String[] args) {
        // open scanner
        Scanner sc = new Scanner(System.in);

        // get user input
        System.out.println("This program will calculate the volume of a rectangular prism");
        int length = getUserInt(sc, "Input the length: ");
        int width = getUserInt(sc, "Input the width: ");
        int height = getUserInt(sc, "Input the height: ");
        // calculate volume
        int volume = getVolume(length, width, height);

        // print results
        System.out.printf("\nThe volume of the rectangular prism is %d\n", volume);
        printCube(length, width, height);
    }

    public static int getVolume(int length, int width, int height) {
        return length * width * height;
    }

    public static void printCube(int length, int width, int height) {
        // one line of the cube
        char[] line;
        // index of first character not the side surface in line
        int notSide;
        // index of last position in line
        int endOfLine;
        System.out.println(" " + repeat("_", width));  // cube back top
        for(int row = 0; row < length + height; row++) {
            line = new char[width + 3 + Math.min((length - 1), row)];
            endOfLine = line.length - 1;
            notSide = Math.min(row + 1, length);  // length of side surface for this line
            // build side surface
            if(row < height) {  // side surface above  bottom corner
                line[0] = '|';  // back vertical wall
                Arrays.fill(line, 1, notSide, '`');  // side surface
            } else {  // side surface below bottom corner
                // create empty space before line
                Arrays.fill(line, 0, row - height, ' ');
                line[row - height] = '\\';  // bottom left edge 
                Arrays.fill(line, row - height + 1, notSide, '`');  // side surface
            }
            // build top surface
            if(row <length) {  // top surface above top edge
                line[notSide] = '\\';  // top left edge
                if(row == length - 1)  // front edge
                    Arrays.fill(line, notSide + 1, endOfLine, '_');
                else  // top surface
                    Arrays.fill(line, notSide + 1, endOfLine, '-');
                line[endOfLine] = '\\';  // back top edge
            } else {  // front surface below top edge
                line[notSide] = '|';  // front left edge
                if(row == length + height - 1)  // bottom edge
                    Arrays.fill(line, notSide + 1, endOfLine, '_');
                else  // front surface
                    Arrays.fill(line, notSide + 1, endOfLine, 'X');
                line[endOfLine] = '|';  // back front edge
            }
            System.out.println(line);
        }
    }

    public static String repeat(String str, int count) {
        return new String(new char[count]).replace("\0", str);
    }

    public static int getUserInt(Scanner sc, String prompt) {
        int input = -1;  // initialize input to prevent compile error
        boolean badInput = true;
        do {
            try {
                System.out.print(prompt);
                input = sc.nextInt();
                if(input <= 0)  // only accept positive numbers
                    System.out.println("\tPlease enter a positive number: ");
                else
                    badInput = false;
            } catch(InputMismatchException e) {
                // user entered a non-number
                System.out.println("\tThat is not a number. Try again: ");
                sc.nextLine();  // clear scanner of bad input
            }
        }while(badInput);
        return input;
    }
}