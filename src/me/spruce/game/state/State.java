package me.spruce.game.state;

import java.awt.*;

public abstract class State {

    private String name;

    public State(String name) {
        this.name = name;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public String getName() {
        return name;
    }
}
