package me.spruce.game;

import me.spruce.game.state.StateManager;

public class Game {

    public static String VERSION = "0.0.1";

    public Loop gameLoop;

    public Game(){
        gameLoop = new Loop("SpaceGame - " + VERSION + " | Developer special edition!", 1000, 800);
        gameLoop.start();
    }
}
