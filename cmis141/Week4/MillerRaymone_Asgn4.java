/**
 * File: MillerRaymone_Asgn4.java
 * Author: Miller, Raymone
 * Class:  CMIS 141 - Assignment 4
 * Creation Date: (19MAR21)
 * Description: 
 */

 package com.miller.millerraymone_asgn4;

 public class MillerRaymone_Asgn4 {
    public static void main(String[] args) {
        buildTriangle(6);
        System.out.println();
        buildDiamond(6);
    }

    public static void buildTriangle(int rows) {
        for(int rowNum = 0; rowNum < rows; rowNum++) {
            for(int rowLength = 0; rowLength <= rowNum; rowLength++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
    public static void buildDiamond(int sideLength) {
        for(int rowNum = 0; rowNum < sideLength * 2 - 1; rowNum++) {
            if(rowNum <= sideLength) {
                for(int rowLength = 0; rowLength < sideLength + rowNum; rowLength++)
                    if(rowLength <= sideLength - rowNum)
                        System.out.print(" ");
                    else
                        System.out.print("#");
            } else {
                for(int rowLength = sideLength - rowNum; rowLength > 0; rowLength--) {
                    if(rowLength <= sideLength - rowNum)
                        System.out.print("-");
                    else
                        System.out.print("#");
                }
            }
            System.out.println();
        }
    }
 }