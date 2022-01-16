package me.spruce.game.player;

import me.spruce.game.Loop;
import me.spruce.game.input.KeyInput;
import me.spruce.game.objects.GameObject;
import me.spruce.game.objects.ObjectHandler;
import me.spruce.game.objects.ObjectType;
import me.spruce.game.state.states.GameState;
import me.spruce.game.trail.Trail;

import java.awt.*;

public class Player extends GameObject {

    public KeyInput keyListener;

    public float health = 100;

    public Player(float x, float y, KeyInput keyListener, Loop loop, ObjectHandler handler){
        super(x, y, ObjectType.Player, loop, handler);
        this.keyListener = keyListener;

        velX = 6;
        velY = 6;
    }

    @Override
    public void tick() {
        move();
        health = clampBounds(health, 100.0f, 0.0f);
        collision();

        handler.addObject(new Trail((int) x, (int) y, 32, 32, 0.12f, Color.black, loop, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect((int) x, (int) y, 32, 32);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 32 ,32);
    }

    public void move(){
        if(keyListener.wPressed) y -= velY;
        if(keyListener.sPressed) y += velY;
        if(keyListener.aPressed) x -= velX;
        if(keyListener.dPressed) x += velX;

        x = clampBounds(x, loop.width - 32, 0);
        y = clampBounds(y, loop.height - 32, 0);
    }

    public void collision(){
        handler.object.forEach(gameObject -> {
            switch(gameObject.getType()){
                case BasicEnemy:
                case SmartEnemy:
                    if(getBounds().intersects(gameObject.getBounds())){
                        health--;
                    }
                    break;

                case AdvancedEnemy:
                    if(getBounds().intersects(gameObject.getBounds())){
                        health-= 2;
                    }
                    break;
            }
        });
    }

    public float clampBounds(float pos, float max, float min) {
        if(pos >= max){
            return pos = max;
        }
        else if (pos <= min){
            return pos = min;
        }
        else{
            return pos;
        }
    }
}
