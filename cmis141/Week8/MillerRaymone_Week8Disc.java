 /**
  * File: MillerRaymone_Week8Disc.java
  * Author: Miller, Raymone
  * Class:  CMIS 141 - Discussion 8
  * Creation Date: (09APR21)
  * Description: Model of a PS4 gaming system
  */

package com.miller.millerraymone_week7disc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MillerRaymone_Week7Disc {
    public static void main(String[] args) {
        PS4 ps4 = new PS4("Blackbluue", 100);
        ps4.installGame("Borderlands", 6);
        ps4.uninstallGame("Warframe");
    }

    public static class PS4 {
        private boolean poweredOn;  // default initialized to false
        private String psnUser;
        private String gameLoaded;
        private Map<String, Double> library;
        private double usedMemory;  // default initialized to 0
        private double totalMemory;

        public PS4(String psnUser, int totalMemory) {
            this.psnUser = psnUser;
            this.totalMemory = totalMemory;
            this.library = new HashMap<>();
            this.gameLoaded = "";
        }

        /**
         * Returns if this PS4 is powered on.
         *
         * @return if this PS4 is powered on.
         */
        public boolean poweredOn() {
            return this.poweredOn;
        }

        /**
         * Sets the PS4's power status. The PS4 cannot be operated while it is powered off.
         *
         * @param status The status to set this PS4's powered state to.
         */
        public void setPower(boolean status) {
            this.poweredOn = status;
            if(this.poweredOn)
                System.out.println("Starting up...");
            else
                System.out.println("Shutting down...");
        }

        /**
         * Returns the PSN username of the current user.
         *
         * @return The username of the current active PSN user. 
         */
        public String psnUser() {
            return psnUser;
        }

        /**
         * Sets the active PSN user account. The username cannot
         * be null or an empty string.
         *
         * @param username The user account to set to active.
         * @return true if the username was successfully changed.
         */
        public boolean setPsnUser(String username) {
            // username cannot be empty
            if(username == null || username.equals("")) {
                System.out.println("Please enter a uesrname.");
                return false;
            }
            this.psnUser = username;
            System.out.printf("%s has logged in.\n", this.psnUser);
            return true;
        }

        /**
         * Returns the currently loaded game.
         * If no game is loaded, an empty string is returned.
         *
         * @return The currently loaded game title.
         */
        public String gameLoaded() {
            return gameLoaded;
        }

        /**
         * Change the currently loaded game. The game title cannot
         * be null or an empty string. The game also must already be installed
         * into the game library.
         *
         * @param gameTitle The game title to load.
         * @return true if the game was successfully loaded
         */
        public boolean loadGame(String gameTitle) {
            // gameTitle cannot be empty
            if(gameTitle == null || gameTitle.equals("")) {
                System.out.println("Please enter a game title.");
                return false;
            } else if(!this.library.containsKey(gameTitle)) {
                System.out.println("Game title not in library.");
                return false;
            }
            this.gameLoaded = gameTitle;
            System.out.printf("%s has been loaded and is ready to play.\n",
                gameTitle);
            return true;
        }

        /**
         * Return the currently installed game library for this PS4.
         * The returned map will be unmodifiable, but will show any
         * updates made to the library through this class.
         *
         * @return An unmodifiable view of the game library.
         */
        public Map<String, Double> library() {
            // return an unmodifiable view
            return Collections.unmodifiableMap(this.library);
        }

        /**
         * Install a game into this PS4's game library. The game will be rejected
         * if the title is empty, it is already installed, the memory is <= 0,
         * or if installing it will max out the system's total memory.
         *
         * @param gameTitle The title of the game.
         * @param memory The amount of memory the game uses.
         * @return true if the game was successfully installed.
         */
        public boolean installGame(String gameTitle, double memory) {
            if(this.library.containsKey(gameTitle)) {
                System.out.println("Game already installed.");
                return false;
            } else if(gameTitle == null || gameTitle.equals("")) {
                System.out.println("Please enter a game title.");
                return false;
            } else if(memory <= 0) {
                System.out.println("Please enter a memory greater than 0.");
                return false;
            } else if (this.usedMemory + memory > this.totalMemory) {
                System.out.println("Memory full; cannot install game.");
                return false;
            }
            this.library.put(gameTitle, memory);
            System.out.printf("%s has been installed.\n", gameTitle);
            return true;
        }

        /**
         * Uninstalls the game with the specified title from the PS4's library.
         * The game is guaranteed to not be uninstalled after a call to this method.
         * If the game was not installed prior, 0 will be returned.
         *
         * @param gameTitle The title of the game to uninstall.
         * @return the amount of memory that was released after uninstalling
         */
        public double uninstallGame(String gameTitle) {
            System.out.printf("Uninstalling %s...\n", gameTitle);
            Double memory = this.library.remove(gameTitle);
            if(memory == null) {
                System.out.printf("%fGB of memory freed\n")
            }
            return memory == null ? 0: memory;
        }

        /**
         * Returns the total amount of currently used memory.
         *
         * @return The amount of currently used memory.
         */
        public double usedMemory() {
            return this.usedMemory;
        }
    }
}