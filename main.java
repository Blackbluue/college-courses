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
        Scanner sc = new Scanner(System.in);
        boolean repeat = true;

        do {
            System.out.print("Do you want to enter student's data? Yes/No => ");
            input = sc.nextLine().toLowerCase();
            if(input == "yes")
                printOutput(getStudentInfo());
            else if(input == "no")
                repeat = false;
            else
                System.out.println("Invalid input");
       } while(repeat == true);
       System.out.println("Thank you for using the grade calculation program");
    }

    public static Map<String, String> getStudentInfo() {
        Scanner sc = new Scanner(System.in);
        Map<String, String> info = new HashMap<>();

        System.out.print("Enter student's name => ");
        info.put("name", sc.nextLine());

        System.out.print("Enter student's grades separated by space: A1 A2 Ex P => ");
        int[] grades = Arrays.asList(sc.nextLine().split(" ")).
            mapToInt(grade -> Integer.valueOf(grade)).
            toArray();
    }

    public static void printOutput(Map<String, String> info) {

    }
}
