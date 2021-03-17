/**
 * File: MillerRaymone_Asgn3.java
 * Author: Miller, Raymone
 * Class:  CMIS 141 - Assignment 3
 * Creation Date: (12MAR21)
 * Description: Calculate a student's grade
 */
package com.miller.millerraymone_asgn3;

import java.util.*;

public class MillerRaymone_Asgn3 {

    public static void main(String[] args) {
        Map<String, Integer> input = getInput();
        String message = "WELCOME";

        List<String> matHalf = new ArrayList<>();
        for(int row = 0; row < input.get("height") / 2; row++) {
            String patternString = repeat(".|.", (row * 2 + 1));
            String lineString = repeat("-", (input.get("width") - patternString.length()) / 2);
            matHalf.add(lineString + patternString + lineString);
        }

        for(String pattern: matHalf) {
            System.out.println(pattern);
        }
        System.out.println(repeat("-", input.get("width") / 2 - (message.length() / 2)) + message + repeat("-", input.get("width") / 2 - (message.length() / 2)));
        Collections.reverse(matHalf);
        for(String pattern: matHalf) {
            System.out.println(pattern);
        }
    }

    public static String repeat(String str, int count) {
        return new String(new char[count]).replace("\0", str);
    }

    public static Map<String, Integer> getInput() {
        System.out.print("How high should the mat be? Enter an odd number: ");
        try(Scanner sc = new Scanner(System.in)) {
            int height;
            boolean goodInput = false;
            do {
                height = sc.nextInt();
                if(height % 2 == 0)
                    System.out.print("Height must be an odd number: ");
                else if(height <= 3)
                    System.out.print("Height must be greater than 3: ");
                else
                    goodInput = true;
            }while(goodInput == false);
            return Map.of("height", height, "width", height * 3);
        }
    }
}
