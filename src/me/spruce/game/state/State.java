package me.spruce.game.state;

import me.spruce.game.Loop;
import me.spruce.game.gui.GuiElement;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class State {

    public CopyOnWriteArrayList<GuiElement> elements;

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
