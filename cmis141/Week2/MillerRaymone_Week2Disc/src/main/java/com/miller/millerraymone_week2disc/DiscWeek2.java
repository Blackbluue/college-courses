/**
 * Grotans,John CMIS 141/2212 (02/22/2021)
 * 
 * Week 2 - Input and Arithmetic
 * 
 * A Java program which prompts a user for two numerical values as input, 
 * does some calculation on them and then prints the result 
 * along with a meaningful message to the console.
 *
 */

import java.util.Scanner; // Using Scanner for user input.
import java.lang.Math;    // Using Math class for square root operation.

public class DiscWeek2 {

	public static void main(String[] args) {
		
		Scanner scanint = new Scanner(System.in); // Create reference named scanint of type Scanner.
		
		// Ask for user input.
		System.out.println("Grotans,John CMIS 141/2212 (02/22/2021)\n");
		System.out.println("JOHN'S PYTHAGOREAN THEOREM CALCULATOR!"); // Program title.
		System.out.println("   |\\");
		System.out.println("   | \\");
		System.out.println(" A |  \\ C");
		System.out.println("   |   \\");
		System.out.println("   |____\\");
		System.out.println("     B");
		
		System.out.print("Enter integer number for side A of right triangle: ");
		int SideA = scanint.nextInt(); // Wait for user to type in integer number.
		
		System.out.print("Enter integer number for side B of right triangle: ");
		int SideB = scanint.nextInt(); // Wait for user to type in integer number.
		
		// Calculate the length of side C.
		double SideC = Math.sqrt((SideA * SideA) + (SideB * SideB)); //Pythagorean theorem.
				
		// Display the output.
		System.out.println("The length of side C is: " + SideC); // Print result of calculation.
		System.out.println(""); // Print an empty line.
		System.out.println("Pythagorean theorem states that " + SideC + " = the sqaure root of " + 
				SideA + "^2" + " + " + SideB + "^2"); // Print student data.
		
		// Close the scanners.
		scanint.close();
		
	} // End of main.

} // End of class DiscWeek2.
