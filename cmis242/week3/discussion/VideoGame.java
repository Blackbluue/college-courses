/**
 * File: VideoGame.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Discussion 3
 * Creation Date: (02JUN21)
 * Description: 
 */

public class VideoGame {
    private String title;
    private int maxPlayerCount;
    private int playTime;

    protected VideoGame(String title, int maxPlayerCount) {
        this.title = title;
        this.maxPlayerCount = maxPlayerCount;
        this.playTime = 0;
    }

    public String getTitle() {
        return title;
    }

    public int getMaxPlayercount() {
        return maxPlayerCount;
    }

    protected void playGame() {
        System.out.printf("Starting game %s\n", title);
        this.playTime++;
    }

    public String toString() {
        return String.format(
            "Game title: %s; Player count: %d; Play time: %d",
            title, maxPlayerCount, playTime);
    }
}