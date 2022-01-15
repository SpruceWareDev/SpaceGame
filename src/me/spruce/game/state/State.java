package me.spruce.game.state;

import me.spruce.game.Loop;

import java.awt.*;

public abstract class State {

    public Loop loop;

    private String name;

    public State(String name, Loop loop) {
        this.loop = loop;
        this.name = name;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public String getName() {
        return name;
    }
}
