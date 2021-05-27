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
        LOW(10, 0.5),
        MEDIUM(15, 1.0),
        HIGH(25, 2.0);

        // % charge used each time the laser is fired
        private final int chargeUsage;
        // multiplier for powerOutput
        private final double outputMultiplier;

        PowerSetting(int chargeUsage, double outputMultiplier) {
            this.chargeUsage = chargeUsage;
            this.outputMultiplier = outputMultiplier;
        }

        public int chargeUsage() { return chargeUsage; }
        public double outputMultiplier() { return outputMultiplier; }
    }
    private enum LaserType {
        TYPE_GAS(5.0),
        TYPE_LIQUID(7.0),
        TYPE_SOLID(10.0);

        // base power output
        private final double baseOutput;

        LaserType(double baseOutput) {
            this.baseOutput = baseOutput;
        }

        public double baseOutput() { return baseOutput; }
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
    private double powerOutput;

    /**
     * Default constructor.
     */
    private Laser() {
        // build a laser with default values
        Laser(MEDIUM, TYPE_SOLID);
    }

    /**
     * Create a Laser object with the specific power setting and laser type.
     *
     * @param setting The power setting for the laser.
     * @param type The type for the laser.
     */
    public Laser(PowerSetting setting, LaserType type) {
        // initial charge is 100%
        this.charge = 100;
        // either PowerSetting or LaserType needs to be manually set before the other
        // since both setter methods refer to the other
        this.PowerSetting = setting;
        setType(type);
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
     * the charge is equal to or lower than the minimum requirement,
     * which is twice the amount needed to fire the laser at the current
     * power setting.
     */
    public void chargeBattery() {
        // check if the minimum reuirement for charging is met
        if(this.charge <= setting.chargeUsage * 2) {
            System.out.println("Charging battery...");
            this.charge = 100;
        } else {  // if not less than minimum reuirement, do not charge
            System.out.println("Battery not low enough.");
        }
    }

    /**
     * Return the current power setting for the laser.
     *
     * @return The laser's current power setting.
     */
    public PowerSetting getPowerSetting() {
        return this.setting;
    }

    /**
     * Set the power setting for the laser. This will also affect power output.
     *
     * @param setting The setting for the laser.
     */
    public void setPowerSetting(PowerSetting setting) {
        this.setting = setting;
        // the power setting also affects power output
        this.powerOutput = type.baseOutput * setting.outputMultiplier;
    }

    /**
     * Return the laser's current type.
     *
     * @return The laser's current type.
     */
    public LaserType getType() {
        return this.type;
    }

    /**
     * Set the laser type for this laser. This also affects the power output.
     *
     * @param type The new type for the laser.
     */
    public void setType(LaserType type) {
        this.type = type;
        // laser type also affects power output
        this.powerOutput = type.baseOutput * setting.outputMultiplier;
    }

    /**
     * Return the expected output of the laser if it would fire with the
     * current settings.
     *
     * @return The expected power output of the laser.
     */
    public double getPowerOutput() {
        return this.powerOutput;
    }

    /**
     * Fire the laser. Charge consumed is determined by the power setting.
     * The laser will not fire if the charge is not high enough.
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