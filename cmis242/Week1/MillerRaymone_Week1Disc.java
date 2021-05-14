 /**
  * File: MillerRaymone_Week1Disc.java
  * Author: Miller, Raymone
  * Class:  CMIS 242 - Discussion 1
  * Creation Date: (14MAY21)
  * Description: Model of a Laser
  */

package com.miller.millerraymone_week1disc;

public class MillerRaymone_Week1Disc {
    public static void main(String[] args) {
        Laser laser = new Laser();

        // print assignment header
        header();

        // print output displaying functionality of laser
        System.out.println(laser);
        laser.fireLaser();
        System.out.println(laser);
        laser.fireLaser();
        laser.fireLaser();
        System.out.println(laser);
        laser.chargeBattery();
        laser.fireLaser();
        laser.fireLaser();
        System.out.println(laser);
        laser.chargeBattery();
        System.out.println(laser);
    }

    public static void header() {
        System.out.println("Name: Miller, Raymone");
        System.out.println("CMIS 242/6383");
        System.out.println("Date: (05/14/2021)\n");
    }

    public static class Laser {
        private int charge;

        public Laser() {
            // initial charge is 100%
            this.charge = 100;
        }

        /**
         * Return the current charge of the laser.
         *
         * @return An int representing the current charge of the laser.
         */
        public int getCharge() {
            return this.charge;
        }

        /**
         * Charge the battery of the laser to 100%. Can only be done if
         * the charge is 50% or lower.
         */
        public void chargeBattery() {
            if(this.charge <= 50) { // check if charge is less than 50%
                System.out.println("Charging battery...");
                this.charge = 100;
            } else {  // if not less than or equal to 50%, do not charge
                System.out.println("Battery not low enough.");
            }
        }

        /**
         * Fire the laser. Each firing using 10% charge. The laser will not
         * fire if the charge is 0%.
         *
         * @return An int representing the charge of the laser after firing.
         */
        public int fireLaser() {
            if(this.charge <= 0) {  // only fire laser if it has a charge
                System.out.println("Battery has no charge left.");
            } else {
                System.out.println("Firing laser..");
                this.charge -= 10;
            }
            return this.charge;  // return current charge of laser
        }

        public String toString() {
            return String.format("The Laser currently has a charge of %d", this.charge);
        }
    }
}