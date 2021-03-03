/*
 * Name: Miller, Raymone
 * Class/Section CMIS 141/6980
 * Date: (03/01/2021)
 */
package com.miller.millerraymone_asgn1;

import java.util.Scanner;

/**
 *
 * @author miller
 */
public class MillerRaymone_Asgn1 {
    public static void main(String[] args) {
        // Define varaibles
        int student_id;
        double curr_gpa;
        int curr_creds;
        double ovr_gpa;
        int ovr_creds;
        double new_gpa;
        // Initialize varaibles with user input
        try( Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter student ID: ");
            student_id = sc.nextInt();
            System.out.print("Enter current class grade in GPA format: ");
            curr_gpa = sc.nextDouble();
            System.out.print("Enter current class number of credits: ");
            curr_creds = sc.nextInt();
            System.out.print("Enter overall GPA: ");
            ovr_gpa = sc.nextDouble();
            System.out.print("Enter overall number of credits: ");
            ovr_creds = sc.nextInt();
        }
        // Calculate new gpa
        new_gpa = ((curr_gpa * curr_creds) + (ovr_gpa * ovr_creds))
                / (curr_creds + ovr_creds);
        // Display output
        System.out.println("\nSTUDENT DATA:");
        System.out.printf("Student ID: %d\n", student_id);
        System.out.printf("Current class GPA: %.3f\n", curr_gpa);
        System.out.printf("Current class credits: %d\n", curr_creds);
        System.out.printf("Overall GPA: %.3f\n", ovr_gpa);
        System.out.printf("Overall credits: %d\n", ovr_creds);
        System.out.printf("NEW GPA: %.3f\n", new_gpa);
    }
}
