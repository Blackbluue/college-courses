/**
 * File: VideoGame.java
 * Author: Miller, Raymone
 * Class:  CMIS 242 - Discussion 5
 * Creation Date: (18JUN21)
 * Description: Design 2 child classes, based off a video game class
 */

public abstract class VideoGame {
    private String title;
    private int maxPlayerCount;
    // total game play time in hours
    private int playTime;

    /**
     * Constructor for VideoGame.
     */
    protected VideoGame(String title, int maxPlayerCount) {
        this.title = title;
        this.maxPlayerCount = maxPlayerCount;
        this.playTime = 0;
    }

    /**
     * Returns the game's title.
     *
     * @return The game's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the maximum player count.
     *
     * @return The maximum player count.
     */
    public int getMaxPlayercount() {
        return maxPlayerCount;
    }

    /**
     * Play the video game, accumulating play time. Additional features apply based on
     * specific game type.
     */
    protected void playGame() {
        System.out.printf("Starting game %s\n", title);
        this.playTime++;
    }

    /**
     * Reset game state and delete any data
     */
    protected void deleteSave() {
        playTime = 0;
    }

    /**
     * Return the string representation of this object.
     *
     * @return The string representation of this object.
     */
    public String toString() {
        return String.format(
            "Game title: %s; Player count: %d; Play time: %d",
            title, maxPlayerCount, playTime);
    }
}