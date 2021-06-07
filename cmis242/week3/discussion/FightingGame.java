/**
 * File: FightingGame.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Discussion 3
 * Creation Date: (02JUN21)
 * Description: 
 */

public class FightingGame extends VideoGame {
    private int maxRounds;
    private int tournamentRound;

    public FightingGame(String title, int maxRounds) {
        super(title, 2);  // maxPlayerCount = 2
        this.tournamentRound = 1;
        // must have at least 1 round
        if(maxRounds <= 0)
            this.maxRounds = 1;
        else
            this.maxRounds = maxRounds;
    }

    public int getTournamentRound() {
        return tournamentRound;
    }

    public int getMaxRounds() {
        return maxRounds;
    }

    public void fightRound() {
        // check if fight is won
        if(Math.random() < 0.5) { // 50-50 chance true/false
            System.out.printf("Round %d victory!\n", tournamentRound);
            tournamentRound++;
            if(tournamentRound > maxRounds) {
                System.out.println("You are the CHAMPION!");
                tournamentRound = 1;
            }
        } else {
            System.out.printf("Round %d lost\n", tournamentRound);
            tournamentRound = 1;
        }
    }

    public void playGame() {
        // call super method to increment play time
        super.playGame();
        System.out.printf("Fighting in tournament round %d ", tournamentRound);
        fightRound();
    }

    public String toString() {
        String oldString = super.toString();
        String newString = String.format("; Max Rounds: %d; Current Round: %d;",
            maxRounds, tournamentRound);
        return oldString + newString; 
    }
}