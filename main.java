/*
 * File: HernandezJuan_DiscWeek7.java
 * Author: Juan Hernandez
 * Class: CMIS 141/2212 - Discussion Week 7
 * Date: 04/04/2021
 * Description: A program that generates a random group of 10 positive integers between a range indicated by the user. The program does a couple of calculation
 * and organizes the numbers in a decreasing pattern.
 */

import java.util.Arrays;
import java.util.Scanner;

public class HernandezJuan_DiscWeek7 {
		
	// Define method that takes value and simply multiplies it by 7
	public static int multBy7(int n) {
		n = n*7;
		return n;
	}
	
	public static void main(String[] args) {
		// Declare variable and open program for input
		Scanner userInput = new Scanner(System.in);
		int lowLim;									// Will store lower limit of the range
		int uppLim;									// Will store upper limit of the range
		int num[] = new int[10];					// Randomly generated list of positive integers between the limits indicated by user
		boolean notValidOrd = true;					// To validate order and the low and upper limits
		boolean notValidSize = true;				// To validate size of range
		int randInt = 0;							// Will store the random integer that then is sent to the array to be stored
		
		System.out.println("Create a random list of 10 whose range your define"
				+ "numbers and have a couple of things done to them.");
		
		// Ask user to define the limits
		System.out.print("Enter the lower and upper limits separated by a space and press enter: ");
		lowLim = userInput.nextInt();
		uppLim = userInput.nextInt();
		userInput.nextLine();
		
		// Ensure limit values are ok. Lower limit needs to be less than upper limit
		// Difference needs to be at least 10 in order to generate a list of 10 numbers
		if(lowLim >= uppLim || uppLim - lowLim < 10) {
			while (lowLim >= uppLim || uppLim - lowLim < 10) {
				if(lowLim >= uppLim) {
					System.out.println("The upper limit needs to be greater then the lower limit.");
					notValidOrd = true;
				}
				if(Math.abs(uppLim - lowLim) < 10) {
					System.out.println("The range needs to be greater");
					notValidSize = true;
				}
				System.out.println("\nTry again: ");
				System.out.print("\nEnter the value limits, lower and upper; separated by space: ");
				lowLim = userInput.nextInt();
				uppLim = userInput.nextInt();
				
				if (lowLim <= uppLim && uppLim - lowLim >= 10) {
					break;
				}
			}		
		}
		// Generate random list of integers within limits
		for (int i = 0; i<num.length && randInt < uppLim; i++) {
			randInt = (int)(Math.random()*(uppLim - lowLim)+lowLim);
			num[i] = randInt;
		}
		System.out.print("\nThis is the initial list of random positive integers: \n");
		for (int h = 0; h<num.length; h++) {
			System.out.printf("%d ", num[h]);
		}
		
		// Sort the numbers that are multiples of 2 and prints them out
		System.out.println("\n\nOf the initial group, these numbers that are multiples of 2: ");
		for (int i = 0 ; i<num.length; i++) {
			if(num[i]%2 == 0) {
				System.out.printf("%d ", num[i]);
			}
		}
		
		// Call for the method to multiply each value of the original list by 7 and print it out
		System.out.println("\n\nEach one of the initial numbers multiplied by 7 is as follows: ");
		
		for (int j = 0; j < num.length; j++) {
			System.out.printf("%d ", multBy7(num[j]));
		}
		
		// Sort the initial group of numbers and print them out
		Arrays.sort(num);
		System.out.println("\n\nThis is the list initial numbers now sorted in ascending order: ");
		for (int i = 0 ; i<num.length; i++) {
			System.out.printf("%d ", num[i]);
		}
		userInput.close();
	}

} // End of program
