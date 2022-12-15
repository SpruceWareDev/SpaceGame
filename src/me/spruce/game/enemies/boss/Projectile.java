package me.spruce.game.enemies.boss;

import me.spruce.game.Loop;
import me.spruce.game.objects.GameObject;
import me.spruce.game.objects.ObjectHandler;
import me.spruce.game.objects.ObjectType;
import me.spruce.game.player.Player;

import java.awt.*;

public class Projectile extends GameObject {

    private Player player;
    private float width, height;
    public float life;
    private long initTime;
    public float damage = 0;
    public Projectile(Player player, float x, float y, float width, float height, float timeMillis, float damage, Loop loop, ObjectHandler handler){
        super(x, y, ObjectType.Projectile, loop, handler);
        this.width = width;
        this.height = height;
        this.player = player;

        this.life = timeMillis;
        this.initTime = System.currentTimeMillis();

        this.damage = damage;
    }

    @Override
    public void tick() {
        life();
        move();
    }

    private void move(){
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
    }

    private void life(){
        if(System.currentTimeMillis() > initTime + life){
            handler.removeObject(this);
        }

        if (getBounds().intersects(player.getBounds())){
            handler.removeObject(this);
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, 64, 64);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, (int) width, (int) height);
    }
}
