 /**
  * File: MillerRaymone_Week6Disc.java
  * Author: Miller, Raymone
  * Class:  CMIS 141 - Discussion 6
  * Creation Date: (22MAR21)
  * Description: 
  */

package com.miller.millerraymone_week6disc;

public class MillerRaymone_Week6Disc {
    public static void main(String[] args) {
        printSquare(5, 10);
        printCube(5, 8, 4);
    }

    public static double getVolume(double length, double width, double height) {
        return length * width * height;
    }

    public static void printSquare(int length, int width) {
        for(int row = 0; row < length; row++) {
            for(int column = 0; column < width; column++) {
                if(row == 0 || row == length - 1) {
                    System.out.print("-");
                } else if(column == 0 || column == width - 1) {
                    System.out.print("|");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }

    public static void printCube(int length, int width, int height) {
        // horizontal edge
        String horizEdge = new String(new char[width]).replace("\0", "_");
        String topLine = new String(new char[width]).replace("\0", "-");
        System.out.print(" " + horizEdge);  // cube back top
        for(int row = 0; row < length + height; row++) {
            if(row < height)
                System.out.print("|");  // back vertical wall
            System.out.println();
        }
    }
}