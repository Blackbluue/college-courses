package com.miller.millerraymone_week1disc;

public class MillerRaymone_Week1Disc {
    public static void main(String[] args) {
        UsedCar car = new UsedCar(2012, 50_000, 2);
        car.displayInfo();
        int trip = 106;  // miles to drive each trip
        // iterate over 12 trips
        for(int i = 0; i <= 11; i++) {
            int drove = car.driveCar(trip);
            System.out.printf("\tCar drove %d miles\n", drove);
            car.displayInfo();
            if(car.getGas() == 0) {
                System.out.println("Filling up...");
                car.addGas(40);
            }
        }
        
    }
    
    public static class UsedCar {

        //attribute
        private int year;
        private int miles;
        private int gas;
        // tracks miles driven since last gas fill up
        private int milesSinceFillup;
        // Miles per Gallon
        private static final int MPG = 25;

        //Constructor
        public UsedCar(int y, int m, int gas) {
            year = y;
            miles = m > 0 ? m : 0;
            // gas tank limit is 40 gal
            if(gas <= 0)
                this.gas = 0;
            else if(gas >= 40)
                this.gas = 40;
            else
                this.gas = gas;
            this.milesSinceFillup = 0;
        }
        
        /**
         * Add gas to the car's tank. The tank's limit is 40 gal, so any excess gas
         * will be discarded. Negative values are ignored.
         */
        public void addGas(int gas) {
            if(gas > 0) {  // only add gas if positive
                // gas cannot exceed 40 gal
                this.gas = this.gas + gas >= 40 ? 40 : this.gas + gas;
                // reset miles since last fill up
                this.milesSinceFillup = 0;
            }
        }

        /**
         * Return the current gas amount, in gallons.
         *
         * @return the current gas amount.
         */
        public int getGas() {
            return this.gas;
        }

        /**
         * Drive the car a set amount of miles. Adjusts mileage and gas tank accordingly.
         * Car drives 25 miles per gallon. If the car does not have enough gas to drive
         * the whole trip, it will stop part way.
         *
         * @param miles The amount of miles intended to drive.
         * @return The amount of miles actually driven.
         */
        public int driveCar(int miles) {
            if(miles < 0) {  // ignore negative miles
                System.out.println("Cannot drive negative miles.");
                return 0;
            }
            int milesDriven = 0;
            // check if driven enough to reduce gas tank
            if(this.milesSinceFillup + miles >= this.MPG) {
                while(this.gas > 0 && miles > 0) {
                    // this portion of trip will reduce gas
                    if(miles >= this.MPG - this.milesSinceFillup) {
                        // find out how much you can drive before gas goes down
                        int tripBlock = this.MPG - this.milesSinceFillup;
                        miles -= tripBlock;
                        this.gas--;  // siphone 1 gal of gas
                        this.milesSinceFillup = 0; // reset fill up counter
                        milesDriven += tripBlock;
                    } else {  // remaining trip will not reduce gas 
                        this.milesSinceFillup += miles;
                        milesDriven += miles;
                        miles = 0;
                    }
                }
            } else  // will not reduce gas tank
                if(this.gas > 0) {  // check if tank is empty 
                    this.milesSinceFillup += miles;
                    milesDriven += miles;
                }
            this.miles += milesDriven;
            return milesDriven;
        }

        //Method
        public void displayInfo() {
            System.out.println("Car [Year: " + year + ", Milage: " + miles +", Gas: " + gas + "]");
        }

    }
}