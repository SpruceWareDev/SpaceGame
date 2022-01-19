package me.spruce.game.gui.impl;

import me.spruce.game.font.FontRenderer;
import me.spruce.game.gui.ClickListener;
import me.spruce.game.gui.GuiElement;

import java.awt.*;

public class GuiButton extends GuiElement {

    public String text;
    public int x, y, width, height;
    public Color backgroundColor, textColor;
    public Font font;
    public ClickListener clicker;

    public GuiButton(String text, int x, int y, int width, int height, Color backgroundColor, Color textColor, Font font, ClickListener clicker) {
        super(x, y, width, height);
        this.text = text;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        this.font = font;
        this.clicker = clicker;

        setBounds(new Rectangle(x - (width / 2), y, width, height));
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(backgroundColor);
        Graphics2D g2d = (Graphics2D) g;
        RenderingHints qualityHints = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON );
        qualityHints.put(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY );
        g2d.setRenderingHints( qualityHints );
        g.fillRoundRect(x - (width / 2), y, width, height, 30, 30);
        FontRenderer.drawString(g, text, x - (width / 2) + width / 2, y + height / 2, true, textColor, font);
    }

    @Override
    public void onClick(){
        clicker.onClick();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }
}
