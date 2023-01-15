package me.spruce.game.level;

import me.spruce.game.Loop;
import me.spruce.game.enemies.AdvancedEnemy;
import me.spruce.game.enemies.BasicEnemy;
import me.spruce.game.enemies.SmartEnemy;
import me.spruce.game.enemies.boss.SimpleBoss;
import me.spruce.game.font.FontRenderer;
import me.spruce.game.font.Fonts;
import me.spruce.game.objects.ObjectHandler;
import me.spruce.game.objects.ObjectType;

import java.awt.*;
import java.util.Random;

public class Spawner {

    private ObjectHandler handler;
    private LevelTracker tracker;
    private Loop loop;

    Random random = new Random();

    private int currentEnemies = 1;
    private boolean bossFight = false;
    private int bossStartLevel = 0;

    public Spawner(ObjectHandler handler, LevelTracker tracker, Loop loop){
        this.handler = handler;
        this.loop = loop;
        this.tracker = tracker;
    }

    public void tick(){
        if(currentEnemies == tracker.level){
            currentEnemies++;
            if (!bossFight) {
                handler.addObject(new BasicEnemy(random.nextInt(1000), random.nextInt(800), loop, handler));
                if (tracker.level % 2 == 0){
                    handler.addObject(new AdvancedEnemy(random.nextInt(1000), random.nextInt(800), loop, handler));
                }
                else if (tracker.level % 5 == 0){
                    handler.addObject(new SmartEnemy(random.nextInt(1000), random.nextInt(800), loop, handler));
                }
            }

            if (tracker.level % 10 == 0 && !bossFight) {
                handler.removeAllEnemies();
                bossFight = true;
                bossStartLevel = tracker.level;
                handler.addObject(new SimpleBoss(random.nextInt(1000), random.nextInt(800), loop, handler));
            }

            if (tracker.level == bossStartLevel + 5 && bossFight){
                bossFight = false;
                handler.removeAllEnemies();
            }
        }
    }

    public void render(Graphics g){
        if(tracker.level == 10) {
            FontRenderer.drawString(g, "Boss Fight", loop.width / 2, 20, true, Color.black, loop.fonts.font22);
        }
    }
}
