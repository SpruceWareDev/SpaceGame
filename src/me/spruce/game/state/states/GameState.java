package me.spruce.game.state.states;

import me.spruce.game.state.State;

import java.awt.*;

public class GameState extends State {

    public GameState(){
        super("GameState");
    }

    public void tick(){

    }

    public void render(Graphics g){
        g.setColor(Color.black);
        g.fillRect(100, 100, 100, 100);
        g.setColor(Color.white);
    }
}
