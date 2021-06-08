/**
 * File: RPG.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Discussion 3
 * Creation Date: (02JUN21)
 * Description: Design 2 child classes, based off a video game class
 */

public class RPG extends VideoGame {
    // constants
    private static final int LEVEL_CAP = 100;
    private static final int EXP_CAP = 100;

    private String mainCharacterName;
    private int characterLevel;
    private int exp;

    /**
     * Constructor for RPG.
     */
    public RPG(String title, String mainCharacterName) {
        super(title, 1);  // maxPlayerCount = 1
        this.mainCharacterName = mainCharacterName;
        this.characterLevel = 1;
        this.exp = 0;
    }

    /**
     * Returns the main character's name.
     *
     * @return The main character's name.
     */
    public String getMainCharacterName() {
        return mainCharacterName;
    }

    /**
     * Returns the character's current level.
     *
     * @return The character's current level.
     */
    public int getCharacterLevel() {
        return characterLevel;
    }

    /**
     * Gain experience for the main character. Level will rise when exp hits the cap.
     */
    public void gainExp() {
        // note that exp has no upper limit if level cap is reached
        exp += 10;
        // level up if exp hits threshold
        if(exp >= EXP_CAP && characterLevel < LEVEL_CAP) {
            System.out.printf("%s has leveled up!\n", mainCharacterName);
            characterLevel++;
            exp = 0;
        }
    }

    /**
     * Play the video game, accumulating play time. Additional features apply based on
     * specific game type.
     */
    public void playGame() {
        // call super method to increment play time
        super.playGame();
        System.out.printf("%s has gone adventuring...\n", mainCharacterName);
        gainExp();
    }

    /**
     * Return the string representation of this object.
     *
     * @return The string representation of this object.
     */
    public String toString() {
        String oldString = super.toString();
        String newString = String.format("; Character Name: %s; Character Level: %d; Experience: %d",
            mainCharacterName, characterLevel, exp);
        return oldString + newString; 
    }
}