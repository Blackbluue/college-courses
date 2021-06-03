/**
 * File: FightingGame.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Discussion 3
 * Creation Date: (02JUN21)
 * Description: 
 */

import java.util.Random;

public class FightingGame extends VideoGame {
    // 4 rounds in a 16-entry tournament
    private static final int MAX_ROUND = 4;
    // made static so the pseudo randomness is not reset
    private static final Random FIGHT_CHECKER = new Random();

    private int tournamentRound;

    public FightingGame(String title) {
        super(title, 2);  // maxPlayerCount = 2
        this.tournamentRound = 1;
    }

    public int getTournamentRound() {
        return tournamentRound;
    }

    public void fightRound() {
        // check if fight is won
        if(FIGHT_CHECKER.nextBoolean()) {
            System.out.printf("Round %d victory!\n", tournamentRound);
            tournamentRound++;
            if(tournamentRound > MAX_ROUND) {
                System.out.println("You are the CHAMPION!");
                tournamentRound = 0;
            }
        } else {
            System.out.printf("Round %d lost\n", tournamentRound);
            tournamentRound = 0;
        }
    }

    public void playGame() {
        // call super method to increment play time
        super.playGame();
        System.out.printf("Fighting in tournament round %d", tournamentRound);
        fightRound();
    }
}