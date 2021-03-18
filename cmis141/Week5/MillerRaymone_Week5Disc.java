
 /**
  * File: MillerRaymone_Week5Disc.java
  * Author: Miller, Raymone
  * Class:  CMIS 141 - Discussion 5
  * Creation Date: (12MAR21)
  * Description: Build a Welcome mat,
                 size determined by user input
  */

package com.miller.millerraymone_week5disc;

import java.util.*;
import java.util.function.BiFunction;

public class MillerRaymone_Week5Disc {

    public static void main(String[] args) {
        String MESSAGE = "WELCOME";  // center message
        // get user input
        Map<String, Integer> input = getInput();
        int heightHalf = input.get("height") / 2;
        int messageBuffer = input.get("width") / 2 - (MESSAGE.length() / 2);
        BiFunction<String, Integer, String> repeat = 
            (str, count) -> new String(new char[count]).replace("\0", str);

        // will contain the patterns to be printed
        List<String> matHalf = new ArrayList<>();
        // for loop for main program
        for(int row = 0; row < input.get("height"); row++) {
            if(row < heightHalf) {  // top half of mat
                // build pattern
                String patternString = repeat.apply(".|.", (row * 2 + 1));
                String lineString = repeat.apply(
                    "-", (input.get("width") - patternString.length()) / 2);
                String pattern = lineString + patternString + lineString;
                // add pattern to list for later retrieval
                matHalf.add(0, pattern);
                // print pattern line
                System.out.println(pattern);
            } else if(row == heightHalf) {  // middle of mat
                // print center message
                System.out.println(
                    repeat.apply("-", messageBuffer)
                    + MESSAGE
                    + repeat.apply("-", messageBuffer));
            } else {  // bottom of mat
                // print bottom half of mat from patterns previosuly created
                System.out.println(matHalf.get(row - (heightHalf) - 1));
            }
        }
    }

    public static Map<String, Integer> getInput() {
        System.out.print("How high should the mat be? Enter an odd number: ");
        // open scanner with auto-close try-with-resources
        try(Scanner sc = new Scanner(System.in)) {
            int height = 0;  // initialize height to avoid compile error
            boolean goodInput = false;  // sentinal value
            do {
                try {  // wrap in try  to catch scanner exception
                    height = sc.nextInt();
                    // validate input
                    if(height % 2 == 0)
                        System.out.print("Height must be an odd number: ");
                    else if(height <= 3)
                        System.out.print("Height must be greater than 3: ");
                    else
                        goodInput = true;
                } catch(InputMismatchException e) {
                    // user entered a non-number
                    System.out.print("Please enter a whole number: ");
                    sc.nextLine();  // clear scanner of bad input
                }
                
            }while(goodInput == false);
            // return input in a Map
            return Map.of("height", height, "width", height * 3);
        }
    }
}
