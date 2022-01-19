package me.spruce.game.gui.impl;

import me.spruce.game.Loop;
import me.spruce.game.font.FontRenderer;
import me.spruce.game.gui.ClickListener;
import me.spruce.game.gui.GuiElement;
import me.spruce.game.setting.Setting;

import java.awt.*;

public class GuiToggle extends GuiElement {

    private Loop loop;

    public int x, y, width, height;
    public Setting<Boolean> booleanSetting;
    public ClickListener clicker;

    public GuiToggle(int x, int y, int width, int height, Setting<Boolean> booleanSetting, Loop loop, ClickListener clicker) {
        super(x, y, width, height);
        this.loop = loop;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.booleanSetting = booleanSetting;
        this.clicker = clicker;

        setBounds(new Rectangle(x - (width / 2), y, width, height));
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints qualityHints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON );
        qualityHints.put(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY );
        g2d.setRenderingHints( qualityHints );
        g.fillRoundRect(x - (width / 2), y, width, height, 30, 30);
        FontRenderer.drawString(g, booleanSetting.name, x + 2, y + height / 2, true, Color.white, loop.fonts.font18);

        g.setColor(booleanSetting.getValue() ? Color.blue : Color.white);
        g.fillRoundRect(x + 60, y + (height / 2) - 10, 20, 20, 30, 30);
    }

    public void toggle(){
        this.booleanSetting.setValue(!booleanSetting.getValue());
    }

    @Override
    public void onClick(){
        clicker.onClick();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }
}
