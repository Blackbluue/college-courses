/**
 * File: MillerRaymone_Asgn6.java
 * Author: Miller, Raymone
 * Class:  CMIS 141 - Assignment 6
 * Creation Date: (31MAR21)
 * Description: Collects uer input to store arrays of student names and
                grades. Then displays all names/grades and uses wwritten
                methods to determine the lowest and highest grades.
 */

package com.miller.millerraymone_asgn6;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;

public class MillerRaymone_Asgn6 {
    public static void main(String[] args) {
        // open scanner
        Scanner sc = new Scanner(System.in);
        String[] students;  // list of student names
        double[] grades;  // list of student grades
        // get user input for number of students
        int numStudents = (int) getUserNumber(sc,
            "How many students do you want to enter: ", input -> input <= 0);

        // initialize arrays
        students = new String[numStudents];
        grades = new double[numStudents];
        // loop to get input for student names and grades
        for(int i = 0; i < numStudents; i++) {
            System.out.printf("Student %d:\n", i + 1);
            System.out.print("\tEnter student's name: ");
            students[i] = sc.nextLine();
            grades[i] = getUserNumber(sc, "\tEnter student's score (0-100): ",
                input -> input < 0 || input > 100);
        }

        // loop to print contents of students and grades arrays
        for(int i = 0; i < numStudents; i++)
            System.out.printf("\n%s\t%.2f", students[i], grades[i]);

        // get index of lowest/highest grades
        int lowestGradeIndex = lowestGrade(grades);
        int highestGradeIndex = highestGrade(grades);
        // display output
        System.out.printf(
            "\n\n%s has the highest score => %.2f and %s has the lowest score => %.2f\n",
            students[highestGradeIndex], grades[highestGradeIndex],
            students[lowestGradeIndex], grades[lowestGradeIndex]);
    }

    public static double getUserNumber(
        Scanner sc, String prompt, Predicate<Double> invalid) {
        double input = -1;  // initialize input to prevent compile error
        boolean badInput = true;
        do {
            try {
                System.out.print(prompt);
                input = Double.valueOf(sc.nextLine());
                if(invalid.test(input))  // test input
                    System.out.println("\tNumber is invalid. try again");
                else
                    badInput = false;
            } catch(InputMismatchException e) {
                // user entered a non-number
                System.out.println("\tThat is not a number. Try again");
                sc.nextLine();  // clear scanner of bad input
            }
        } while(badInput);
        return input;
    }

    public static int lowestGrade(double[] grades) {
        int lowestIndex = 0;  // result
        for(int i = 1; i < grades.length; i++)
            if(grades[i] < grades[lowestIndex])  // check number
                lowestIndex = i;  // update result
        return lowestIndex;
    }

    public static int highestGrade(double[] grades) {
        int highestIndex = 0;  //result
        for(int i = 1; i < grades.length; i++)
            if(grades[i] > grades[highestIndex])  // check number
                highestIndex = i;  // update result
        return highestIndex;
    }
}