/**
 * File: MillerRaymone_Asgn3.java
 * Author: Miller, Raymone
 * Class:  CMIS 141 - Assignment 3
 * Creation Date: (12MAR21)
 * Description: Calculate a student's grade
 */
package com.miller.millerraymone_asgn3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MillerRaymone_Asgn3 {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            String test;
            do {
                System.out.print("Test: ");
                test = sc.nextLine();
                System.out.println(test);
                temp(sc);
            }while(!test.equals("end"));
        }
    }

    public static void temp(Scanner sc) {
        System.out.print("Inner Test: ");
        String test = sc.nextLine();
        System.out.println(test);
    }
}
