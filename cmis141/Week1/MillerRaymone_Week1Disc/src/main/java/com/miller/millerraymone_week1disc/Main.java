package com.miller.millerraymone_week1disc;

import java.util.Scanner;

class Main {

    static void runGreeting(String name, int age) {
        /**
         * Method that prints a simple greeting
         */
        System.out.printf(
                "Hello %s! Doesn't it feel great to be %d years old?!\n",
                name, age);
    }

    static int getInput() {
        /**
         * Method that gets the input then calls runGreeting
         */
        String name;
        int age = 0;
        String temp_age;
        boolean bad_input = true;  // input validation flag

        try( Scanner input = new Scanner(System.in)) { // scanner obj
            // closing the scanner object with try-with-resources
            System.out.println("What is your name?");
            name = input.nextLine();  // get the next line

            System.out.println("How old are you?");
            do {
                temp_age = input.nextLine();  // get the next line
                try {
                    age = Integer.parseInt(temp_age);// check temp_age for valid input
                    bad_input = false;
                }catch(NumberFormatException e) {
                    // if not, ask for a new number
                    System.out.println("Please enter a number.");
                    // check the num again and again and again!!!
                }
            }while(bad_input);
        }

        runGreeting(name, age); // call runGreeting()
        return age;
    }

    static void reply(int age) {
        int legal_age = 21;

        if(age >= legal_age) {
            System.out.println("Yes it does! I can party all night long.");
        }else {
            System.out.println("Not really. I don't get to have any fun.");
        }
    }

    public static void main(String[] args) {
        int age = getInput(); // call getInput()
        reply(age);  // call reply()
    }
}
