/**
 * File: MillerRaymone_Week3Disc.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Discussion 3
 * Creation Date: (02JUN21)
 * Description: 
 */

public class MillerRaymone_Week3Disc {
    public static void main(String[] args) {
        RPG game = new RPG("Mad Max", "Max");
        System.out.println(game);
        game.playGame();
        for(int i = 0; i < 10; i++)
            game.playGame();
        System.out.println(game);
        FightingGame game2 = new FightingGame("Tekken", 4);
        System.out.println(game2);
        game2.playGame();
        for(int i = 0; i < 5; i++)
            game2.playGame();
        System.out.println(game2);
    }
}