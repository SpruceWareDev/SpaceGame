package me.spruce.game.level;

import me.spruce.game.Loop;
import me.spruce.game.font.FontRenderer;

import java.awt.*;

public class LevelTracker {

    public int score, level;

    public int currentHighScore = 0;
    public int newScore = 0;

    private Loop loop;

    public LevelTracker(Loop loop){
        this.loop = loop;
        score = 0;
        level = 1;
    }

    public void tick(){
        score++;
        if(score == (level * 500)){
            increaseLevel();
        }
    }

    public void render(Graphics g){
        FontRenderer.drawString(g, "Score : " + score, 20, 74, false, Color.black, loop.fonts.font18);
        FontRenderer.drawString(g, "Level : " + level, 20, 90, false, Color.black, loop.fonts.font18);
    }

    public void increaseLevel(){
        level++;
    }
}
