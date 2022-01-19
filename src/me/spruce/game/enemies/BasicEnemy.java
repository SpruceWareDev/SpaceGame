package me.spruce.game.enemies;

import me.spruce.game.Loop;
import me.spruce.game.objects.GameObject;
import me.spruce.game.objects.ObjectHandler;
import me.spruce.game.objects.ObjectType;
import me.spruce.game.trail.Trail;

import java.awt.*;
import java.util.Random;

public class BasicEnemy extends GameObject {

    Random random = new Random();

    public BasicEnemy(float x , float y, Loop loop, ObjectHandler handler){
        super(x, y, ObjectType.BasicEnemy, loop, handler);

        velX = 4;
        velY = 4;
    }

    @Override
    public void tick() {
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

        handler.addObject(new Trail((int) x, (int) y, 16, 16, 0.1f, Color.red, loop, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, 16, 16);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }
}
