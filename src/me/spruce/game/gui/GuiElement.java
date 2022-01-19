package me.spruce.game.gui;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class GuiElement {

    public int x, y, width, height;
    public boolean hovered = false;
    public Rectangle bounds;

    public GuiElement(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public void onMouseMove(MouseEvent e) {
        hovered = bounds.contains(e.getX(), e.getY());
    }

    public void onMouseRelease(MouseEvent e) {
        if(hovered)
            onClick();
    }

    public void onClick(){

    }

    public Rectangle getBounds(){
        return bounds;
    }

    public void setBounds(Rectangle rect){
        this.bounds = rect;
    }

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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
