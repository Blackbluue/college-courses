 /**
  * File: MillerRaymone_Week7Disc.java
  * Author: Miller, Raymone
  * Class:  CMIS 141 - Discussion 7
  * Creation Date: (30MAR21)
  * Description: Finds the prime factors of a
                 randomly generated array of integers
  */

package com.miller.millerraymone_week7disc;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MillerRaymone_Week7Disc {
    public static void main(String[] args) {
        int min = 1;  // minimum value for random number
        int max = 150;  // maximum value for random number
        int length = 10;  // length of array
        String[] arr = new String[length];  // array for random numbers

        System.out.println(
            "This program finds the prime factors of a " + 
            "randomly generated array of integers.\n");
        // loop to generate random numbers and populate array
        for(int i = 0; i < length; i++)
            arr[i] = String.valueOf((int) (Math.random() * (max - min + 1) + min));

        // print current contents of array
        System.out.println(Arrays.toString(arr) + "\n");
        // factor numbers in array
        factorInts(arr);
        // print new contents of array
        for(String factors: arr)
            System.out.println(factors);
    }

    /**
     * Takes an array of strings, each element representing an integer.Then
     * factors each number and replaces each element in the array with the
     * factors.
     *
     * @param arr An array of strings, each representing an integer.
     */
    public static void factorInts(String[] arr) {
        // loop over the array, and factor each number
        for(int i = 0; i < arr.length; i++)
            arr[i] = arr[i] + " = " + factor(Integer.parseInt(arr[i]));
    }

    /**
     * Take a single integer, finding all the factors.
     * 
     * @param number The number to factor.
     * @return a string stating all the factors of the number.
     */
    public static String factor(int number) {
        // list to hold factors of number
        List<String> factors = new ArrayList<>();
        // for-loop to check each number less than the base number
        for(int i = 2; i< number; i++) {
            // loop to check if i is a factor
            while(number % i == 0) {
                factors.add(String.valueOf(i));
                number = number / i;
            }
        }
        // if the last number is greater than 2, or if there are no factors,
        // add number to the factors list
        if(number > 2 || factors.isEmpty())
            factors.add(String.valueOf(number));

        // return a string stating the factors of the original number
        return String.join(" * ", factors);
    }
}