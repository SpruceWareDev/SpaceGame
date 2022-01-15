package me.spruce.game.objects;

import me.spruce.game.Loop;

import java.awt.*;

public abstract class GameObject {

    public Loop loop;
    protected int x,y;
    protected ObjectType type;
    protected int velX, velY;

    public GameObject(int x, int y, ObjectType type, Loop loop){
        this.loop = loop;
        this.x = x;
        this.y = y;
        this.type = type;
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

    public ObjectType getType() {
        return type;
    }

    public void setType(ObjectType type) {
        this.type = type;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
}
