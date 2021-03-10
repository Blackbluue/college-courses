/**
 * File: MillerRaymone_Week3Disc.java
 * Author: Miller, Raymone
 * Class:  CMIS 141 – Discussion 3
 * Creation Date: (08MAR21)
 * Description:  Number guessing game
 */
package com.miller.millerraymone_week3disc;

import java.util.Scanner;

public class MillerRaymone_Week3Disc {
    public static void main(String[] args) {
        int answer = (int) (Math.random() * 100);

        System.out.println("Lets play a game! Guess the number I'm thinking of");
        try( Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number between 0 and 99: ");
            int input = sc.nextInt();
            int difference = Math.abs(answer - input);
            if(input >= 100 || input < 0)
                System.out.println("That number wasn't even the range.");
            else if(difference == 0)
                System.out.println("Congrats, you guessed my number!");
            else if(difference <= 20)
                System.out.println("So close. Try again next time!");
            else if(difference <= 50)
                System.out.println("Getting warmer, but you have while to go.");
            else
                System.out.println("Not even close. Are you even trying?");
        }
    }
}
