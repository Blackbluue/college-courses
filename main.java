/**
 * File: MillerRaymone_Week4Disc.java
 * Author: Miller, Raymone
 * Class:  CMIS 141 – Discussion 4
 * Creation Date: (10MAR21)
 * Description:
 */
package com.miller.millerraymone_week4disc;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;

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
        patterns.put(6, "-({[<#>]})-");
        patterns.put(7, "___________");
        patterns.put(8, "-----------");
        patterns.put(9, "[/T_}-{_T\\]");
        patterns.put(10, "|||||||||||");  // wont show in random
        patterns.put(11, "___________");  // wont show in random
        patterns.put(12, "-----------");  // wont show in random
        String quiltStart = patterns.get(10) + "\n"
            + patterns.get(11) + "\n"
            + patterns.get(12) + "\n";
        String quiltEnd = patterns.get(11) + "\n"
            + patterns.get(12) + "\n"
            + patterns.get(10) + "\n";

        // get user input
        System.out.println("Lets make a quilt together. "
            + "How large do you want it?");
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of rows: ");
        int counter, rows = sc.nextInt();
        if(rows % 2 != 0)  // check if odd, need even rows
            rows--;
        
        // start quilt
        LinkedList<String> stack = new LinkedList<>();
        String pattern;
        System.out.println("\n" + quiltStart);
        while(counter > 0) {
            if(counter / 2 > rows / 2) {  // top half
                // randomly choose a quilt pattern
                int choice = (int) (Math.random() * 100) / 10;
                // build quilt from pattern
                pattern = patterns.get(choice);
                stack.add(pattern);
            } else if(counter / 2 == rows / 2) {
                pattern = patterns.get(6);
            } else {
                pattern = stack.removeLast();
            }
            System.out.println(pattern);
            counter--;
        }
        System.out.println(quiltEnd);
    }
}
