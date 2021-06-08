/**
 * File: MillerRaymone_Week3Disc.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Discussion 3
 * Creation Date: (02JUN21)
 * Description: Design 2 child classes, based off a video game class
 */

public class MillerRaymone_Week3Disc {
    public static void main(String[] args) {
        RPG game = new RPG("Final Fantasy X", "Tidus");
        FightingGame game2 = new FightingGame("Tekken", 4);

        System.out.println(game + "\n");
        game.playGame();
        for(int i = 0; i < 10; i++)
            game.playGame();
        System.out.println("\n" + game + "\n");

        System.out.println(game2 + "\n");
        game2.playGame();
        for(int i = 0; i < 6; i++)
            game2.playGame();
        System.out.println("\n" + game2 + "\n");
    }
}