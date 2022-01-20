package me.spruce.game.enemies.boss;

import me.spruce.game.Loop;
import me.spruce.game.objects.GameObject;
import me.spruce.game.objects.ObjectHandler;
import me.spruce.game.objects.ObjectType;
import me.spruce.game.trail.Trail;

import java.awt.*;
import java.util.Random;

public class SimpleBoss extends GameObject {

    private Loop loop;
    private ObjectHandler handler;

    Random random = new Random();

    public SimpleBoss(float x, float y, Loop loop, ObjectHandler handler) {
        super(x, y, ObjectType.Boss, loop, handler);
        this.loop = loop;
        this.handler = handler;

        velX = 6;
        velY = 6;
    }

    @Override
    public void tick() {
        move();

        handler.addObject(new Trail((int) x, (int) y, 64, 64, 0.1f, Color.gray, loop, handler));
    }

    public void move(){
        x += velX;
        y += velY;
        if(x >= loop.width){
            velX = (-4 - random.nextFloat());
        }
        if(y >= loop.height){
            velY = (-4 - random.nextFloat());
        }
        if(x <= 0){
            velX = (4 + random.nextFloat());
        }
        if(y <= 0){
            velY = (4 + random.nextFloat());
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int) x, (int) y, 64, 64);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 64, 64);
    }
}
