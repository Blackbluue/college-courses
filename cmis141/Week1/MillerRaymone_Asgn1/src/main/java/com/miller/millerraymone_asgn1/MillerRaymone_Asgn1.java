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
    /*
    (3) Displays the input data along with new GPA to the console

    Enter student id: 6543
    Enter current class grade in GPA format (e.g. 3.5): 3.5
    Enter current class number of credits: 3
    Enter overall GPA: 4.0
    Enter overall number of credits: 12
    STUDENT DATA:
    Student id: 6543
    Current class GPA: 3.5
    Current class credits:3
    Overall GPA: 3.5
    Overall credits:3
    NEW GPA: 3.9

     */
    public static void main(String[] args) {
        int student_id;
        double curr_gpa;
        int curr_creds;
        double ovr_gpa;
        int ovr_creds;
        double new_gpa;
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
        new_gpa = (curr_gpa * curr_creds) + (ovr_gpa * ovr_creds)
                / (curr_creds + ovr_creds);
        System.out.println("\nSTUDENT DATA:");
        System.out.printf("Student ID: %d", student_id);
        System.out.printf("Current class GPA: %f", curr_gpa);
        System.out.printf("Current class credits: %d", curr_creds);
        System.out.printf("Overall GPA: %f", ovr_gpa);
        System.out.printf("Overall credits: %d", ovr_creds);
        System.out.printf("NEW GPA: %f", new_gpa);
    }
}
