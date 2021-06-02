/**
 * File: RPG.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Discussion 3
 * Creation Date: (02JUN21)
 * Description: 
 */

public class RPG extends VideoGame {
    private static final int LEVEL_CAP = 100;
    private static final int EXP_CAP = 100;

    private String mainCharacterName;
    private int characterLevel;
    private int exp;

    public RPG(String title, String mainCharacterName) {
        super(title, 1);
        this.mainCharacterName = mainCharacterName;
        this.characterLevel = 1;
        this.exp = 0;
    }

    public String getMainCharacterName() {
        return mainCharacterName;
    }

    public int getCharacterLevel() {
        return characterLevel;
    }

    public void levelUp() {
        // level cap is 100
        if(characterLevel < LEVEL_CAP)
            characterLevel++;
    }

    public void playGame() {
        // call super method to increment play time
        super.playGame();
        System.out.printf("%s has gone adventuring...\n", mainCharacterName);
        // gain exp
        exp += 10;
        // level up if exp hits threshold
        if(exp >= EXP_CAP && characterLevel < LEVEL_CAP) {
            System.out.printf("%s has leveled up!\n", mainCharacterName);
            levelUp();
            exp = 0;
        }
    }

    public String toString() {
        String oldString = super.toString();
        String newString = String.format("; Character name: %s; Character level: %d; Experience: %d",
            mainCharacterName, characterLevel, exp);
        return oldString + newString; 
    }
}