/ /**
  * File: MillerRaymone_Week2Disc.java
  * Author: Miller, Raymone
  * Class:  CMIS 242 - Discussion 2
  * Creation Date: (25MAY21)
  * Description: Model of a Laser
  */

package com.miller.millerraymone_week2disc;

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
}