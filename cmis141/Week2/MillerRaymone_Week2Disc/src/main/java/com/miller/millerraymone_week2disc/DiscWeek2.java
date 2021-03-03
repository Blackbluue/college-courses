/**
 * Grotans,John CMIS 141/2212 (02/22/2021)
 *
 * Week 2 - Input and Arithmetic
 *
 * A Java program which prompts SideA user for two numerical values as input,
 * does some calculation on them and then prints the result
 * along with SideA meaningful message to the console.
 *
 */
package com.miller.millerraymone_week2disc;

import java.util.Scanner; // Using Scanner for user input.
// import java.lang.Math;    // Using Math class for square root operation.
// Don't need to import from java.lang

public class DiscWeek2 {

    public static void main(String[] args) {
        Scanner scanint = new Scanner(System.in); // Create reference named scanint of type Scanner.

        // Ask for user input.
        System.out.println("Grotans,John CMIS 141/2212 (02/22/2021)\n");
        System.out.println("JOHN'S PYTHAGOREAN THEOREM CALCULATOR!"); // Program title.
        System.out.println("AND RAYMONE'S TRIANGULAR PRISM VOLUME CALCULATOR!");
        System.out.println("   |\\");
        System.out.println("   | \\");
        System.out.println(" A |  \\ C");
        System.out.println("   |   \\");
        System.out.println("   |____\\");
        System.out.println("     B");

        System.out.print("Enter integer number for side A of right triangle: ");
        int sideA = scanint.nextInt(); // Wait for user to type in integer number.

        System.out.print("Enter integer number for side B of right triangle: ");
        int sideB = scanint.nextInt(); // Wait for user to type in integer number.

        System.out.print("Enter integer number for height of prism: ");
        int height = scanint.nextInt();

        // Calculate the length of side C.
        int sideC = (int) Math.sqrt((sideA * sideA) + (sideB * sideB)); //Pythagorean theorem.

        // Calculate the volume of the prism.
        double volume = 0.25 * height * Math.sqrt(
                (sideA + sideB + sideC) * (sideB + sideC - sideA)
                * (sideC + sideA - sideB) * (sideA + sideB - sideC));

        // Display the output.
        System.out.println("\nThe length of side C is: " + sideC); // Print result of calculation.
        System.out.printf("The volume is %f\n", volume);
        System.out.println(); // Print an empty line.
        System.out.println(
                "Pythagorean theorem states that " + sideC + " = the sqaure root of "
                + sideA + "^2" + " + " + sideB + "^2"); // Print student data.
        System.out.printf(
                "Volume of the triangular prism is 1/4 * %d * "
                + "√((%d + %d + %d)(%d + %d - %d)(%d + %d - %d)(%d + %d - %d)) = %f\n",
                height, sideA, sideB, sideC, sideB, sideC, sideA, sideC, sideA,
                sideB, sideA, sideB, sideC, volume);

        // Close the scanners.
        scanint.close();

    } // End of main.

} // End of class DiscWeek2.
