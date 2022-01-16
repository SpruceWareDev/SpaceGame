package me.spruce.game.enemies;

import me.spruce.game.Loop;
import me.spruce.game.objects.GameObject;
import me.spruce.game.objects.ObjectHandler;
import me.spruce.game.objects.ObjectType;
import me.spruce.game.player.Player;
import me.spruce.game.trail.Trail;

import java.awt.*;

public class SmartEnemy extends GameObject {

    private Player player;

    public SmartEnemy(float x, float y, Loop loop, ObjectHandler handler) {
        super(x, y, ObjectType.SmartEnemy, loop, handler);
        handler.object.forEach(gameObject -> {
            if(gameObject.getType().equals(ObjectType.Player)){
                player = (Player) gameObject;
            }
        });
        velX = 2;
        velY = 2;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() - 8;
        float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));

        velX = (float) ((-1.0/distance) * diffX);
        velY = (float) ((-1.0/distance) * diffY);

        if(x >= loop.width){
            velX = -2;
        }
        if(y >= loop.height){
            velY = -2;
        }
        if(x <= 0){
            velX = 2;
        }
        if(y <= 0){
            velY = 2;
        }

        handler.addObject(new Trail((int) x, (int) y, 16, 16, 0.1f, Color.cyan, loop, handler));
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
