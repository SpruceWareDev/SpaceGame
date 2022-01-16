package me.spruce.game.objects;

import me.spruce.game.Loop;

import java.awt.*;

public abstract class GameObject {

    public ObjectHandler handler;
    public Loop loop;
    protected float x,y;
    protected ObjectType type;
    protected float velX, velY;

    public GameObject(float x, float y, ObjectType type, Loop loop, ObjectHandler handler){
        this.loop = loop;
        this.x = x;
        this.y = y;
        this.type = type;
        this.handler = handler;
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public abstract Rectangle getBounds();

    public float getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public float getY() {
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

    public float getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public float getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
}
