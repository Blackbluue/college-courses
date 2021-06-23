/**
 * File: MillerRaymone_Week5Disc.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Discussion 5
 * Creation Date: (18JUN21)
 * Description: Design 2 child classes, based off a video game class
 */

public class MillerRaymone_Week5Disc {
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
        game.deleteSave();
        game2.deleteSave();
        System.out.println(game + "\n");
        System.out.println(game2 + "\n");
        System.out.println("The winner is: " + game2.fightExhibition("Ryu", "Ken"));
        System.out.println("The winner is: " + game2.fightExhibition("Akuma"));
    }
}