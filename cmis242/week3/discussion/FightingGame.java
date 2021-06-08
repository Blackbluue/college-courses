/**
 * File: FightingGame.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Discussion 3
 * Creation Date: (02JUN21)
 * Description: Design 2 child classes, based off a video game class
 */

public class FightingGame extends VideoGame {
    private int maxRounds;
    private int tournamentRound;

    /**
     * Constructor for FightingGame.
     */
    public FightingGame(String title, int maxRounds) {
        super(title, 2);  // maxPlayerCount = 2
        this.tournamentRound = 1;
        // must have at least 1 round
        if(maxRounds <= 0)
            this.maxRounds = 1;
        else
            this.maxRounds = maxRounds;
    }

    /**
     * Return the current tournament round.
     *
     * @return The current torunament round.
     */
    public int getTournamentRound() {
        return tournamentRound;
    }

    /**
     * Return the maximum tournament rounds.
     *
     * @return The maximum tournament rounds.
     */
    public int getMaxRounds() {
        return maxRounds;
    }

    /**
     * Fight a round in the tournament, advancing if the fight is won.
     */
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

    /**
     * Play the video game, accumulating play time. Additional features apply based on
     * specific game type.
     */
    public void playGame() {
        // call super method to increment play time
        super.playGame();
        System.out.printf("Fighting in tournament round %d ", tournamentRound);
        fightRound();
    }

    /**
     * Return the string representation of this object.
     *
     * @return The string representation of this object.
     */
    public String toString() {
        String oldString = super.toString();
        String newString = String.format("; Max Rounds: %d; Current Round: %d;",
            maxRounds, tournamentRound);
        return oldString + newString; 
    }
}