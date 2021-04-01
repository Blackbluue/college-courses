/**
 * File: W7Arrays.java
 * Author: Daniels, Roderick
 * Class: CMIS141: Week 7 - Arrays
 * Creation Date: 04/01/2021
 * Description: This program creates and populated an array with some values
 *      and then passes that array to a method which squares all the values in
 *      the array.
 */
import java.util.Arrays;


public class W7Arrays {

    /**
     * Accepts an array of ints and squares them returning the resulting array
     * @param numbers: original array to square
     * @return: an array of squared numbers
     */
    public static int[] Squares(int[] numbers) {
        for (int index=0; index < numbers.length; index++) {
            numbers[index] = numbers[index] * numbers[index];
        }
        return numbers;
    }

    /**
     * Main entry point for the program. Initialize an integer array and pass
     * it to Squares() printing both the original and result
     * @param args: Unused
     */
    public static void main(String[] args) {
        int[] inputNums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 15};
        System.out.println("Original : " + Arrays.toString(inputNums));
        int[] resultNums = Squares(inputNums);
        System.out.println("Squares : " + Arrays.toString(resultNums));
    }
}