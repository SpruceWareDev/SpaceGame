package me.spruce.game.state.states;

import me.spruce.game.Loop;
import me.spruce.game.enemies.BasicEnemy;
import me.spruce.game.hud.HUD;
import me.spruce.game.hud.element.elements.PlayerHealthbar;
import me.spruce.game.level.LevelTracker;
import me.spruce.game.level.Spawner;
import me.spruce.game.objects.ObjectHandler;
import me.spruce.game.player.Player;
import me.spruce.game.state.State;
import me.spruce.game.util.MathUtils;

import java.awt.*;
import java.util.Random;

public class GameState extends State {

    public ObjectHandler objectHandler;
    public Player player;

    public Spawner spawner;
    public LevelTracker levelTracker;

    //HUD stuff
    public HUD hud;
    public PlayerHealthbar healthbar;

    public GameState(Loop loop){
        super("GameState", loop);
        init();
    }

    public void init(){
        objectHandler = new ObjectHandler();

        //player
        player = new Player(loop.width / 2 - 32, loop.height / 2 - 32, loop.keyInputManager, loop, objectHandler);
        objectHandler.addObject(player);

        // spawner
        levelTracker = new LevelTracker(loop);
        spawner = new Spawner(objectHandler, levelTracker, loop);

        //HUD
        hud = new HUD();

        healthbar = new PlayerHealthbar(player, 20, 20);
        hud.addHudElement(healthbar);

    }

    public void tick(){
        objectHandler.tick();
        hud.tick();
        levelTracker.tick();
        spawner.tick();
    }

    public void render(Graphics g){
        objectHandler.render(g);
        hud.render(g);
        levelTracker.render(g);
        spawner.render(g);
    }
}
