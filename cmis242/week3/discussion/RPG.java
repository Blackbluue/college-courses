/**
 * File: RPG.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Discussion 3
 * Creation Date: (02JUN21)
 * Description: 
 */

public class RPG extends VideoGame {
    private String mainCharacterName;
    private int characterLevel;

    public RPG(String title, String mainCharacterName) {
        super(title, 1);
        this.mainCharacterName = mainCharacterName;
        this.characterLevel = 1;
    }

    public String getMainCharacterName() {
        return mainCharacterName;
    }

    public int getCharacterLevel() {
        return characterLevel;
    }

    public void levelUp() {
        if(characterLevel < 100)
            characterLevel++;
    }

    public void playGame() {
        // call super method to increment play time
        super.playGame();
    }
}