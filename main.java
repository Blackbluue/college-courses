/**
 * File: MillerRaymone_Week4Disc.java
 * Author: Miller, Raymone
 * Class:  CMIS 141 - Discussion 4
 * Creation Date: (10MAR21)
 * Description: Build a randomly generated quilt
 */
package com.miller.millerraymone_week4disc;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class MillerRaymone_Week4Disc {

    public static void main(String[] args) {
        // define quilt patterns
        Map<Integer, String> patterns = new HashMap<>();
        patterns.put(0, "}IV^\\A/^VI{");
        patterns.put(1, "\\|/-\\|/-\\|/");
        patterns.put(2, "/|\\-/|\\-/|\\");
        patterns.put(3, "*~^~^~^~^~*");
        patterns.put(4, ">_<_>_<_>_<");
        patterns.put(5, "=+-_\\_/_-+=");
        patterns.put(6, "|||||||||||");
        patterns.put(7, "___________");
        patterns.put(8, "-----------");
        patterns.put(9, "[/T_}-{_T\\]");
        patterns.put(10, "-({[<#>]})-");  // wont show in random
        String quiltStart = patterns.get(6) + "\n"
                + patterns.get(7) + "\n"
                + patterns.get(8);
        String quiltEnd = patterns.get(7) + "\n"
                + patterns.get(8) + "\n"
                + patterns.get(6);

        // get user input
        System.out.println("Lets make a quilt together. "
                + "How large do you want it?");
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of rows: ");
        int counter = Math.abs(sc.nextInt());

        int halfway;
        boolean odd;
        // if counter is odd, middle row will be preset
        if(counter % 2 != 0) {
            halfway = (counter + 1) / 2;
            odd = true;
        } else {
            halfway = counter / 2;
            odd = false;
        }

        // start quilt
        LinkedList<String> stack = new LinkedList<>();
        String pattern;
        System.out.println("\n" + quiltStart);
        while(counter > 0) {
            if(counter > halfway) {  // top half
                // randomly choose a quilt pattern
                int choice = (int) (Math.random() * 10);
                // build quilt from pattern
                pattern = patterns.get(choice);
                stack.add(pattern);
            }else if(odd && counter == halfway)  // center
                pattern = patterns.get(10);
            else  // bottom half
                pattern = stack.removeLast();
            System.out.println(pattern);
            counter--;
        }
        System.out.println(quiltEnd);
    }
}
