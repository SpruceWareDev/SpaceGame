package me.spruce.game.trail;

import me.spruce.game.Loop;
import me.spruce.game.objects.GameObject;
import me.spruce.game.objects.ObjectHandler;
import me.spruce.game.objects.ObjectType;

import java.awt.*;

public class Trail extends GameObject {

    private float alpha = 1;
    public Color trailColor;

    public int width, height;
    public float life;

    public ObjectHandler handler;

    public Trail(int x, int y, int width, int height, float life, Color color, Loop loop, ObjectHandler handler){
        super(x, y, ObjectType.Trail, loop, handler);
        this.trailColor = color;
        this.width = width;
        this.height = height;
        this.life = life;
        this.handler = handler;
    }

    @Override
    public void tick() {
        if(alpha > life){
            alpha -= life - 0.001f;
        }else{
            handler.removeObject(this);
        }
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        g.setColor(trailColor);
        g.fillRect(x, y, width, height);


        g2d.setComposite(makeTransparent(1));
    }

    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return AlphaComposite.getInstance(type, alpha);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}