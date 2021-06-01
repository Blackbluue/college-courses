/**
 * File: MillerRaymone_Week2Disc.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Discussion 2
 * Creation Date: (25MAY21)
 * Description: Model of a Laser
 */

import java.util.ArrayList;
import java.util.List;

public class MillerRaymone_Week1Disc {
    public static void main(String[] args) {
        // list of all laser types and power settings
        List<Laser> lasers = new ArrayList<>();
        lasers.add(new Laser(Laser.LOW, Laser.TYPE_GAS));
        lasers.add(new Laser(Laser.MEDIUM, Laser.TYPE_GAS));
        lasers.add(new Laser(Laser.HIGH, Laser.TYPE_GAS));
        lasers.add(new Laser(Laser.LOW, Laser.TYPE_LIQUID));
        lasers.add(new Laser(Laser.MEDIUM, Laser.TYPE_LIQUID));
        lasers.add(new Laser(Laser.HIGH, Laser.TYPE_LIQUID));
        lasers.add(new Laser(Laser.LOW, Laser.TYPE_SOLID));
        lasers.add(new Laser(Laser.MEDIUM, Laser.TYPE_SOLID));
        lasers.add(new Laser(Laser.HIGH, Laser.TYPE_SOLID));


        // print assignment header
        header();

        // test laser functionality
        for(Laser laser: lasers)
            multifire(laser, 2);
    }

    public static void header() {
        System.out.println("Name: Miller, Raymone");
        System.out.println("CMIS 242/6383");
        System.out.println("Date: (05/31/2021)\n");
    }

    public static void multifire(Laser laser, int chargeLimit) {
        int recharged = 0;
        while(recharged < chargeLimit) {
            double output = laser.fireLaser();
            System.out.println(laser);
            if(output == 0) {
                laser.chargeBattery();
                recharged++;
            }
            System.out.println();
        }
    }
}
