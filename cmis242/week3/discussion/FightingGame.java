/**
 * File: FightingGame.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Discussion 3
 * Creation Date: (02JUN21)
 * Description: 
 */

public class FightingGame extends VideoGame {
    private static final int MAX_ROUND = 4;
    private int gameRound;
    public FightingGame(String title) {
        super(title, 2);
        this.gameRound = 1;
    }

    public int getGameRound() {
        return gameStage;
    }

    public void advanceRound() {

    }

    public void playGame() {
        super.playGame();
        System.out.printf("Fighting in tournament round %d", gameRound);

    }
}