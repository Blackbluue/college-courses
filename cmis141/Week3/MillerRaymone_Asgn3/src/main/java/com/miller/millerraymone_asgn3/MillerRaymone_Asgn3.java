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
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MillerRaymone_Asgn3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean repeat = true;
        String input;

        do {
            System.out.print("Do you want to enter student's data? Yes/No => ");
            input = sc.nextLine().toLowerCase();
            switch(input) {
                case "yes" ->
                    printOutput(getStudentInfo());
                case "no" ->
                    repeat = false;
                default ->
                    System.out.println("Invalid input");
            }
        }while(repeat == true);
        System.out.println("Thank you for using the grade calculation program");
    }

    public static Map<String, String> getStudentInfo() {
        //define variables
        Scanner sc = new Scanner(System.in);
        Map<String, String> info = new HashMap<>();

        // get student name
        System.out.print("Enter student's name => ");
        info.put("name", sc.nextLine());

        // get student grades
        System.out.print(
                "Enter student's grades separated by space: A1 A2 Ex P => ");
        List<String> values = Arrays.asList(sc.nextLine().split(" "));
        List<String> keys = Arrays.asList("A1 A2 Exam Participation".split(" "));
        Map<String, String> grades = IntStream.range(0, keys.size()).boxed().
                collect(Collectors.toMap(keys::get, values::get));
        // calculate final grade
        String finalGrade = String.valueOf(
                Integer.valueOf(grades.get("A1")) * 0.25
                + Integer.valueOf(grades.get("A2")) * 0.25
                + Integer.valueOf(grades.get("Exam")) * 0.4
                + Integer.valueOf(grades.get("Participation")) * 0.1);
        grades.put("Final course grade", finalGrade);
        for(int i = 0; i < grades.size(); i++) {

        }
        info.put("grades", finalGrade);
        return info;
    }

    public static void printOutput(Map<String, String> info) {

    }
}
