/**
 * File: MillerRaymone_Asgn3.java
 * Author: Miller, Raymone
 * Class:  CMIS 141 - Assignment 3
 * Creation Date: (12MAR21)
 * Description: Calculate a student's grade using user
 *              input, then displays results
 */
package com.miller.millerraymone_asgn3;

import java.util.*;
import java.util.stream.IntStream;

public class MillerRaymone_Asgn3 {

    public static void main(String[] args) {
        // open scanner with resources for auto-closing
        try(Scanner sc = new Scanner(System.in)) {
            // declare necessary variables
            boolean repeat = true;
            String input;
            // loop until user says to stop
            do {
                // collect user input
                System.out.print(
                    "Do you want to enter student's data? Yes/No => ");
                input = sc.nextLine();
                // decide whether to continue or exit program
                switch(input.toLowerCase()) {
                    case "yes":
                        printOutput(getStudentInfo(sc));
                        break;
                    case "no":
                        repeat = false;
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            }while(repeat == true);
            System.out.println(
                "Thank you for using the grade calculation program");
        }
    }

    public static Map<String, String> getStudentInfo(Scanner sc) {
        //define variables
        Map<String, String> info = new HashMap<>();
        // get student name
        System.out.print("Enter student's name => ");
        info.put("name", sc.nextLine());

        // get student grades
        System.out.print(
                "Enter student's grades separated by space: A1 A2 Ex P => ");
        String temp = sc.nextLine();
        List<String> values = Arrays.asList(temp.split(" "));
        List<String> keys = Arrays.asList("A1 A2 Ex P".split(" "));
        IntStream.range(0, keys.size()).
                forEach(index ->
                    info.put(keys.get(index), values.get(index)));
        // calculate final grade
        String finalGrade = String.valueOf(
                Integer.valueOf(info.get("A1")) * 0.25
                + Integer.valueOf(info.get("A2")) * 0.25
                + Integer.valueOf(info.get("Ex")) * 0.4
                + Integer.valueOf(info.get("P")) * 0.1);
        info.put("final", finalGrade);
        return info;
    }

    public static void printOutput(Map<String, String> info) {
        // print output
        System.out.printf("Student Name: %s\n", info.get("name"));
        System.out.printf(
                "A1=%s A2=%s Exam=%s Participation=%s Final course grade=%s\n",
                info.get("A1"), info.get("A2"), info.get("Ex"), info.get("P"),
                info.get("final"));
    }
}
