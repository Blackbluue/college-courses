 /**
  * File: MillerRaymone_Week7Disc.java
  * Author: Miller, Raymone
  * Class:  CMIS 141 - Discussion 7
  * Creation Date: (30MAR21)
  * Description: Finds the prime factors of a
                 randomly generated array of integers
  */

package com.miller.millerraymone_week7disc;

import java.util.List;
import java.util.ArrayList;

public class MillerRaymone_Week7Disc {
    public static void main(String[] args) {
        int min = 1;
        int max = 150;
        int length = 10;
        String[] arr = new String[length];

        System.out.println(
            "This program finds the prime factors of a " + 
            "randomly generated array of integers.\n");
        for(int i = 0; i < length; i++)
            arr[i] = String.valueOf((int) (Math.random() * (max - min + 1) + min));

        System.out.println("{" + String.join(", ", arr) + "}\n");
        factorInts(arr);
        for(String factors: arr)
            System.out.println(factors);
    }

    public static void factorInts(String[] arr) {
        for(int i = 0; i < arr.length; i++)
            arr[i] = arr[i] + " = " + factor(Integer.parseInt(arr[i]));
    }

    public static String factor(int number) {
        List<String> factors = new ArrayList<>();
        for(int i = 2; i< number; i++) {
            while(number % i == 0) {
                factors.add(String.valueOf(i));
                number = number / i;
            }
        }
        if(number > 2 || factors.size() == 0)
            factors.add(String.valueOf(number));

        return String.join(" * ", factors);
    }
}