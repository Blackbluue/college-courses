 /**
  * File: Laser.java
  * Author: Miller, Raymone
  * Class:  CMIS 242 - Discussion 2
  * Creation Date: (25MAY21)
  * Description: Model of a Laser
  */

public static class Laser {
    // enum declarations
    public enum PowerSetting {
        LOW(10, 1, "Low"),
        MEDIUM(15, 2, "Medium"),
        HIGH(25, 5, "High");

        // % charge used each time the laser is fired
        private final int chargeUsage;
        // multiplier for powerOutput
        private final int outputMultiplier;
        private final String setting;

        PowerSetting(int chargeUsage, int outputMultiplier, String setting) {
            this.chargeUsage = chargeUsage;
            this.outputMultiplier = outputMultiplier;
            this.setting = setting;
        }

        public int chargeUsage() { return chargeUsage; }
        public int outputMultiplier() { return outputMultiplier; }
        public String setting() { return setting; }
    }
    private enum LaserType {
        TYPE_GAS, TYPE_LIQUID, TYPE_SOLID
    }
    // constant declarations
    public static final PowerSetting LOW = PowerSetting.LOW;
    public static final PowerSetting MEDIUM = PowerSetting.MEDIUM;
    public static final PowerSetting HIGH = PowerSetting.HIGH;
    public static final LaserType TYPE_GAS = LaserType.TYPE_GAS;
    public static final LaserType TYPE_LIQUID = LaserType.TYPE_LIQUID;
    public static final LaserType TYPE_SOLID = LaserType.TYPE_SOLID;

    // laser cannot fire if charge too low
    private int charge;
    // affects charge usage and power output
    private PowerSetting setting;
    // determines powr output
    private LaserType type;
    // energy output of the laser
    private int powerOutput;

    /**
     * Default constructor.
     */
    private Laser() {
        // initial charge is 100%
        this.charge = 100;
        this.setting = MEDIUM;
        this.type = TYPE_SOLID;
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

    public 

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