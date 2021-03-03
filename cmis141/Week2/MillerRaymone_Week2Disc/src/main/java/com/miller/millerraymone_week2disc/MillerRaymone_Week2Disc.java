/*
 * Name: Miller, Raymone
 * Class/Section CMIS 141/6980
 * Date: (03/02/2021)
 */
package com.miller.millerraymone_week2disc;
import java.util.Scanner;

public class MillerRaymone_Week2Disc {
    public static void main(String[] args) {
        // Create scanner object for user input
        try( Scanner input = new Scanner(System.in)) {
            // Collect input for mass and velocity
            System.out.println(
                    "Lets calculate the Kinetic energy of an object in motion");
            System.out.print("What is the mass of the object, in kg? ");
            double mass = input.nextDouble();
            System.out.print("What is the velocity of the object, in m/s? ");
            double velocity = input.nextDouble();
            // Calculate kinetic energy
            int ke = kinetic_energy(mass, velocity);
            // Display output
            display_output(ke);
        }
    }

    /**
     * Kinetic energy formula.
     *
     * @param mass     The mass of the object.
     * @param velocity The velocity of the object, in m/s.
     *
     * @return The kinetic energy of the object, in joules.
     */
    private static int kinetic_energy(double mass, double velocity) {
        return (int) (0.5 * mass * Math.pow(velocity, 2));
    }

    /**
     * Display output to screen.
     *
     * @param kinetic_energy The kinetic energy of the object.
     */
    private static void display_output(int kinetic_energy) {
        String ke_str = convert_joules(kinetic_energy);
        if(kinetic_energy >= (int) Math.pow(10, 15))
            System.out.printf(
                    "That's %s of energy. That's more than the Tsar Bomba!\n",
                    ke_str);
        else if(kinetic_energy >= (int) (63 * Math.pow(10, 15)))
            System.out.printf(
                    "That's %s of energy. That's more than the Little Boy Bomb!\n",
                    ke_str);
        else if(kinetic_energy >= (int) (6 * Math.pow(10, 9)))
            System.out.printf(
                    "That's %s of energy. That's more than the energy of 1 barrel of exploding petroleum.\n",
                    ke_str);
        else if(kinetic_energy >= 1600)
            System.out.printf(
                    "That's %s of energy. That's about the power of a boxer's punch.\n",
                    ke_str);
        else
            System.out.printf("That's %s of energy.\n", ke_str);
    }

    /**
     * Convert the supplied joules based on magnitude. Returns a string.
     *
     * @param joules The kinetic energy of the object.
     *
     * @return String representation of the kinetic energy.
     */
    private static String convert_joules(int joules) {
        if(joules / (int) Math.pow(10, 12) > 0)  // Terajoules
            return String.valueOf(joules / (int) Math.pow(10, 12)) + "TJ";
        else if(joules / (int) Math.pow(10, 9) > 0)  // Gigajoules
            return String.valueOf(joules / (int) Math.pow(10, 9)) + "GJ";
        else if(joules / (int) Math.pow(10, 6) > 0)  // Megajoules
            return String.valueOf(joules / (int) Math.pow(10, 6)) + "MJ";
        else if(joules / (int) Math.pow(10, 3) > 0)  // Kilojoules
            return String.valueOf(joules / (int) Math.pow(10, 3)) + "kJ";
        else
            return String.valueOf(joules) + "J";

    }
}
