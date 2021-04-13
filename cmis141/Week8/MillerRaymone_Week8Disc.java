 /**
  * File: MillerRaymone_Week8Disc.java
  * Author: Miller, Raymone
  * Class:  CMIS 141 - Discussion 8
  * Creation Date: (09APR21)
  * Description: Model of a PS4 gaming system
  */

package com.miller.millerraymone_week7disc;

import java.util.*;
import java.util.Map.Entry;
import java.util.function.Predicate;

public class MillerRaymone_Week7Disc {
    // constants for menu choices
    public static final int EXIT = 0;
    public static final int POWER = 1;
    public static final int USER = 2;
    public static final int ISNTALL = 3;
    public static final int UNINSTALL = 4;
    public static final int LOAD = 5;
    public static final int MEMORY = 6;
    public static final int LIBRARY = 7;
    public static final int PLAY = 8;
    public static final int DIAG = 9;
    // open scanner
    public static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Your PS4 System is starting up\n");

        PS4 ps4 = new PS4(100);
        System.out.println();
        int choice;
        // do-while loop to control program flow
        do {
            choice = displayMenu();
            switch(choice) {
                case POWER:
                    ps4.pressPower();
                    break;
                case USER:
                    setUser(ps4);
                    break;
                case ISNTALL:
                    if(installGame(ps4))
                        System.out.println("\tGame successfully installed.\n");
                    else 
                        System.out.println("\tGame not installed.\n");
                    break;
                case UNINSTALL:
                    if(uninstallGame(ps4))
                        System.out.println("\tGame successfully uninstalled.\n");
                    else 
                        System.out.println("\tGame not uninstalled.\n");
                    break;
                case LOAD:
                    if(loadGame(ps4))
                        System.out.println("\tGame successfully loaded/unloaded.\n");
                    else 
                        System.out.println("\tGame not loaded/unloaded.\n");
                    break;
                case MEMORY:
                    adjustMemory(ps4);
                    break;
                case LIBRARY:
                    printLibrary(ps4);
                    break;
                case PLAY:
                    ps4.playGame();
                    break;
                case DIAG:
                    ps4.printDiagnostics();
                    break;
                case EXIT:
                    if(ps4.poweredOn())
                        ps4.pressPower();
                    break;
            }
        } while(choice != EXIT);
    }

    /**
     * Display menu and collect user iput.
     *
     * @return An int representing the user's choice.
     */
    public static int displayMenu() {
        int choice;
        // print menu options
        System.out.println(
            "1. Power On/Off System\n" + 
            "2. Set User\n" + 
            "3. Install Game\n" + 
            "4. Uninstall Game\n" + 
            "5. Load Game\n" + 
            "6. Adjust Memory\n" +
            "7. Print Game Library\n" + 
            "8. Play Game\n" + 
            "9. Print Diagnostics\n" +
            "0. Exit\n"
        );
        // get use input, caste to int
        return (int) getUserNumber("Enter your menu choice: ",
            input -> input < EXIT || input > DIAG);
    }

    /**
     * Sets the current user for the PS4.
     *
     * @param ps4 the PS4 system.
     */
    public static void setUser(PS4 ps4) {
        System.out.print("\tWhich user do you want to log in as? ");
        String user = SC.nextLine();
        ps4.setPsnUser(user);
    }

    /**
     * Installs a game into the PS4.
     *
     * @param ps4 the PS4 system.
     * @return true if the game was successfully installed.
     */
    public static boolean installGame(PS4 ps4) {
        System.out.print("\tWhat is the name of the game to install? ");
        String game = SC.nextLine();

        double memory = getUserNumber("\tHow much memory is this game in GB? ",
            input -> input <= 0);
        return ps4.installGame(game, memory);
    }

    /**
     * Uninstalls a game from the PS4.
     *
     * @param ps4 the PS4 system.
     * @return true if the game was successfully uninstalled.
     */
    public static boolean uninstallGame(PS4 ps4) {
        System.out.print("\tWhat is the name of the game to uninstall? ");
        String game = SC.nextLine();
        return ps4.uninstallGame(game) > 0 ? true : false;
    }

    /**
     * load/unload a game from the PS4.
     *
     * @param ps4 the PS4 system.
     * @return true if the game was successfully loaded/unloaded.
     */
    public static boolean loadGame(PS4 ps4) {
        System.out.print("\tWhat is the name of the game to load? A blank line unloads the current game: ");
        String game = SC.nextLine();
        return ps4.loadGame(game);
    }

    /**
     * Add or remove memory for the drive in this PS4.
     *
     * @param ps4 the PS4 system.
     */
    public static void adjustMemory(PS4 ps4) {
        double drive = getUserNumber(
            "\tHow much memory is this new drive in GB? Negative values reduce drive size: ",
            input -> input <= 0);
        ps4.adjustMemory(drive);
    }

    /**
     * Print all the installed games on this PS4.
     *
     * @param ps4 the PS4 system.
     */
    public static void printLibrary(PS4 ps4) {
        if(ps4.library().size() == 0)
            System.out.println("\tNo games in library\n");
        else 
            for(Entry<String, Double> game: ps4.library().entrySet())
                System.out.printf("\t%s <-> %,.2fGB\n", game.getKey(), game.getValue());
    }

    /**
     * Collect user numerical input. Accepts a prompt and a predicate to determine
     * valid values for input.
     *
     * @param prompt The prompt to print to the screen.
     * @param invalid A Predicate used to determine invalid input.
     * @return a number from user input.
     */
    public static double getUserNumber(String prompt, Predicate<Double> invalid) {
        double input = -1;  // initialize input to prevent compile error
        boolean badInput = true;
        do {
            try {
                System.out.print(prompt);
                input = Double.valueOf(SC.nextLine());
                if(invalid.test(input))  // test input
                    System.out.println("\tNumber is invalid. try again");
                else
                    badInput = false;
            } catch(NumberFormatException e) {
                // user entered a non-number
                System.out.println("\tThat is not a number. Try again");
            }
        } while(badInput);
        return input;
    }

    /**
     * A class representing a PS4 gaming console. Keep in mind that most operations that
     * modify the state of the system require the system to be powered on to operate, with
     * the exception of modifying the total memory which requires the system to be off.
     */
    public static class PS4 {
        private boolean poweredOn;
        private String psnUser;
        private String gameLoaded;
        private Map<String, Double> library;
        private double usedMemory;  // default initialized to 0.0
        private double totalMemory;
        private int playtime;  // default initialized to 0

        public PS4(int totalMemory) {
            this.library = new HashMap<>();
            this.psnUser = "Guest";
            this.gameLoaded = "";
            this.adjustMemory(totalMemory);
            this.pressPower();
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
         * Switches the PS4's power status. The PS4 cannot be operated while it is powered off.
         *
         * @return The current power status.
         */
        public boolean pressPower() {
            if(!this.poweredOn) {
                System.out.println("\tStarting up...");
                this.poweredOn = true;
                this.printDiagnostics();
            } else {
                this.loadGame("");
                System.out.println("\tShutting down...");
                this.poweredOn = false;
            }
            return this.poweredOn;
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
            if(!this.poweredOn) {
                System.out.println("\tThe system cannot be operated while powered off.\n");
                return false;
            } else if(username == null || username.equals("")) {
                // username cannot be empty
                System.out.println("\tPlease enter a uesrname.\n");
                return false;
            }
            this.psnUser = username;
            System.out.printf("\t%s has logged in.\n\n", this.psnUser);
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
         * Change the currently loaded game. If the game title is null or an empty string,
         * the current game will be unloaded. The game must already be installed
         * into the game library to load.
         *
         * @param gameTitle The game title to load.
         * @return true if the game was successfully loaded or unloaded
         */
        public boolean loadGame(String gameTitle) {
            // power must be on to use system
            if(!this.poweredOn) {
                System.out.println("\tThe system cannot be operated while powered off.\n");
                return false;
            } else if((gameTitle == null || gameTitle.equals(""))) {
                if(!this.gameLoaded.equals(""))
                    System.out.println("\tThe currently loaded game has been unloaded.\n");
                this.gameLoaded = "";
                return true;
            } else if(!this.library.containsKey(gameTitle)) {
                System.out.printf("\t%s is not in the library.\n\n", gameTitle);
                return false;
            } else {
                this.gameLoaded = gameTitle;
                System.out.printf("\t%s has been loaded and is ready to play.\n\n",
                    gameTitle);
                return true;
            }
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
            // power must be on to use system
            if(!this.poweredOn) {
                System.out.println("\tThe system cannot be operated while powered off.\n");
                return false;
            } else if(this.library.containsKey(gameTitle)) {
                System.out.println("\tGame already installed.\n");
                return false;
            } else if(gameTitle == null || gameTitle.equals("")) {
                System.out.println("\tPlease enter a game title.\n");
                return false;
            } else if(memory <= 0) {
                System.out.println("\tPlease enter a memory greater than 0GB.\n");
                return false;
            } else if (this.remainingMemory() < memory) {
                System.out.println("\tMemory full; cannot install game.\n");
                return false;
            }
            this.library.put(gameTitle, memory);
            this.usedMemory += memory;
            System.out.printf("\t%s has been installed. %,.2fGB of memory remaining.\n\n",
                gameTitle, this.remainingMemory());
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
            // power must be on to use system
            if(!this.poweredOn) {
                System.out.println("\tThe system cannot be operated while powered off.\n");
                return -1;
            }
            System.out.printf("\tUninstalling %s...\n", gameTitle);
            if(this.gameLoaded.equals(gameTitle))
                this.loadGame("");
            Double temp = this.library.remove(gameTitle);
            double memory = (temp == null ? 0: temp);
            System.out.printf("\t%,.2fGB of memory freed\n\n", memory);
            this.usedMemory -= memory;
            return memory;
        }

        /**
         * Returns the total amount of currently used memory.
         *
         * @return The amount of currently used memory.
         */
        public double usedMemory() {
            return this.usedMemory;
        }

        /**
         * Returns the total memory available for the PS4.
         *
         * @return The total amount of memory for the PS4.
         */
        public double totalMemory() {
            return this.totalMemory;
        }

        /**
         * Returns the amount of memory remaining and available for this PS4.
         *
         * @return The remaining amount of memory for this PS4.
         */
        public double remainingMemory() {
            return this.totalMemory - this.usedMemory;
        }

        /**
         * Adjust the memory drive of the PS4. This method can be used to add or remove
         * memory, but the new total memory must be greater than or equal to the current
         * used memory count. The system also must be powered off to adjust.
         *
         * @param memory The memory to add or remove.
         * @return The new total memory.
         */
        public double adjustMemory(double memory) {
            if(this.poweredOn) {
                System.out.println("\tCannot adjust memory while the system is on.\n");
                return -1;
            } else if(this.totalMemory + memory < this.usedMemory) {
                System.out.println("\tPlease enter a drive with more memory.\n");
                return -1;
            }
            this.totalMemory += memory;
            System.out.printf("\tReading drive. %,.2fGB of total memory, %,.2fGB available.\n\n",
                this.totalMemory, this.remainingMemory());
            return this.totalMemory;
        }

        /**
         * Start playing the currently loaded game. Tracks play time in 1 hour intervals.
         * Keep in mind that hours played as "Guest" user are not tracked.
         */
        public void playGame() {
            // power must be on to use system
            if(!this.poweredOn) {
                System.out.println("\tThe system cannot be operated while powered off.\n");
                return;
            } else if(this.gameLoaded.equals("")) {
                System.out.println("\tNo game has been loaded.\n");
                return;
            }
            System.out.printf("\t%s played %s for an hour...\n\n", this.psnUser,
                this.gameLoaded);
            if(!this.psnUser.equals("Guest"))
                this.playtime++;
        }

        /**
         * Displays the diagnostics for the PS4 system.
         */
        public void printDiagnostics() {
            System.out.println("\tPrinting diagnostics...");
            System.out.printf(
                "\t\tSystem powered on status: %b\n" +
                "\t\tCurrently signed in as: %s\n" +
                "\t\tGame loaded: %s\n" +
                "\t\tInstalled game library count: %d\n" +
                "\t\tTotal memory: %,.2fGB; Memory used: %,.2fGB; Remaining memory: %,.2fGB\n" +
                "\t\tTotal play time across all games: %d hours\n\n",
                this.poweredOn, this.psnUser, this.gameLoaded, this.library.size(),
                this.totalMemory, this.usedMemory, this.remainingMemory(), this.playtime
            );
        }
    }
}