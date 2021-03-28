/*
 * File: HernandezJuan_DiscWeek6.java
 * Author: Juan Hernandez
 * Class: CMIS 141/2212 - Discussion Week 6
 * Date: 03/27/2021
 * Description: A program to calculate the volume of a cylinder
 */


import java.util.Scanner;

public class HernandezJuan_DiscWeek6 {

	// Method for calculating volume of a cylinder
	public static double cylVol(double r, double h) {
		return Math.PI * Math.pow(r, 2) * h;
	}

    // Method for calculating surface area of a cylinder
    public static double cylSur(double r, double h) {
        // S = 2πr(h+r)
        return 2 * Math.PI * r * (h + r);
    }
	
	// Method for selecting units
	public static String unitsSel(int u) {
		String unit = "";
		if (u == 1) {
			unit = "cm";
		}
		else if (u == 2) {
			unit = "in";
		}
		else if (u == 3) {
			unit = "mm";
		}
		return unit;
	}

	public static void main(String[] args) {
		// Declare variable and open program for input
		Scanner userInput = new Scanner(System.in);
		int units;				// Will store selection of units from menu presented
		double radius = 0;		// Will store value for the radius of the cylinder
		double height = 0;		// Will store value for the height of the cylinder
		
		// Promp user for input. Starting with the units to be used. It references method
		System.out.print("This is a simple cylinder volume calculator\n");
		System.out.print("\nSelect the units you will be using: \n");
		System.out.print("1. Centimeters\n2. Inches\n3. Milimeters\n");
		units = userInput.nextInt();
		System.out.println();
		
		// Ensure selection of units is valid
		while (units <= 0 || units > 3) {
			System.out.print("Not a valid selection. Try again.\n");
			System.out.print("1. Centimeters\n2. Inches\n3. Milimeters\n");
			units = userInput.nextInt();
		}
		
		// Promp user to input values of the cylinder needed
		System.out.printf("Enter the radius of your cylinder in %s: ", unitsSel(units));
		radius = userInput.nextDouble();
		System.out.printf("Enter the height of your cylinder in %s: ", unitsSel(units));
		height = userInput.nextDouble();
		
		// Check at least that the values are positive numbers
		while (radius <= 0 || height <= 0) {
			System.out.print("\nValues need to be greater than 0. Try again.\n");
			System.out.printf("Enter the radius of your cylinder in %s: ", unitsSel(units));
			radius = userInput.nextDouble();
			System.out.printf("Enter the height of your cylinder in %s: ", unitsSel(units));
			height = userInput.nextDouble();
		}
		
		// Calculate using method and print result with appropiate units
		System.out.printf("\nThe volume of your cylinder is: %.2f %s3", cylVol(radius, height), unitsSel(units));
        System.out.printf("\nThe surface area of your cylinder is: %.2f %s\n", cylSur(radius, height), unitsSel(units));
		
		// Close scanner
		userInput.close();
	}
} // End of program