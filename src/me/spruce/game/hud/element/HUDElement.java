package me.spruce.game.hud.element;

import java.awt.*;

public abstract class HUDElement {

    public int x, y;

    public HUDElement(int x, int y){
        this.x = x;
        this.y = y;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
