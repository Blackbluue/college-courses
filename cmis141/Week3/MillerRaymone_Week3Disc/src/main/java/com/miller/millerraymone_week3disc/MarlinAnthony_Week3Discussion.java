/** Marlin, Anthony
 * CMIS 141 6980
* 08 March 2021
* Week 3 Discussion
**/
package com.miller.millerraymone_week3disc;

import java.util.Scanner;

public class MarlinAnthony_Week3Discussion {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // import scanner

	// Introdcution followed by questions to determine user personality via input.
        System.out.print(
                "This program will determine your personality type based on "
                + "simple responses about yourself! Just hit enter, answer "
                + "some questions by inputting the number associated with "
                + "your response and enjoy the fun!\n\n");

        System.out.println(
                "If you're at a party, do you want to be (1)surrounded by "
                + "friends, or do you (2) tend to stick to the outsides and "
                + "just enjoy the music: ");
        int ie = scan.nextInt();

        System.out.println(
                "\nAwesome! Now, do you (3) Go to work JUST to collect a "
                + "paycheck; or do you (4)go because you believe your work "
                + "has meaning and you enjoy it: ");
        int ns = scan.nextInt();

        System.out.println(
                "\nGreat, halfway there! Now, do you tend to rely more on "
                + "your (5) gut feeling, or (6) your logical mind when it "
                + "comes to making decisions: ");
        int tf = scan.nextInt();

        System.out.println(
                "\nFinally, would you say you're more of a (7) decision "
                + "maker, or (8) an information seeker: ");
  	int pj = scan.nextInt();

  	// if else statements to determine output based on user input during questions

        if(ie == 1)
            System.out.print("You're extroverted, ");
        else if(ie == 2)
            System.out.print("You're introverted, ");
        else
            System.out.print("You don't follow rules, ");

        if(ns == 3)
            System.out.print("You're more of a sensory type personality, ");
        else if(ns == 4)
            System.out.print("You're more of an intuitive personality, ");
        else
            System.out.print("You're more of a rebel personality, ");

        if(tf == 5)
            System.out.print("You tend to rely and depend more on feelings, ");
        else if(tf == 6)
            System.out.print(
                    "You tend to rely and depend more on your thoughts, ");
        else
            System.out.print("You tend to rely and depend more on chance, ");

        if(pj == 7)
            System.out.print(
                    "and You can also be described as a person of judgement!");
        else if(pj == 8)
            System.out.print(
                    "and You can also be described as a person of perception!");
        else
            System.out.print(
                    "and You can also be described as a person of spontaneity!");

        System.out.println();

        System.out.print(
                "Thanks for playing along all you introverts and extroverts!");

        scan.close();
    }
} // end of program
