package me.spruce.game.player;

import me.spruce.game.Loop;
import me.spruce.game.input.KeyInput;
import me.spruce.game.objects.GameObject;
import me.spruce.game.objects.ObjectType;

import java.awt.*;

public class Player extends GameObject {

    public KeyInput keyListener;

    public Player(int x, int y, KeyInput keyListener, Loop loop){
        super(x, y, ObjectType.Player, loop);
        this.keyListener = keyListener;

        velX = 4;
        velY = 4;
    }

    @Override
    public void tick() {
        move();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(x, y, 32, 32);
    }

    public void move(){
        if(keyListener.wPressed) y -= velY;
        if(keyListener.sPressed) y += velY;
        if(keyListener.aPressed) x -= velX;
        if(keyListener.dPressed) x += velX;

        x = clampBounds(x, loop.width - 32, 0);
        y = clampBounds(y, loop.height - 32, 0);
    }

    public int clampBounds(int pos, int max, int min) {
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
