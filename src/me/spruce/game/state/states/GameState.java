package me.spruce.game.state.states;

import me.spruce.game.Loop;
import me.spruce.game.enemies.BasicEnemy;
import me.spruce.game.hud.HUD;
import me.spruce.game.hud.element.elements.PlayerHealthbar;
import me.spruce.game.objects.ObjectHandler;
import me.spruce.game.player.Player;
import me.spruce.game.state.State;
import me.spruce.game.util.MathUtils;

import java.awt.*;
import java.util.Random;

public class GameState extends State {

    public ObjectHandler objectHandler;
    public Player player;

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

        // test enemys
        Random r = new Random();
        for(int i = 0; i < 5; i++) {
            objectHandler.addObject(new BasicEnemy(r.nextInt(1000), r.nextInt(800), loop, objectHandler));
        }

        //HUD
        hud = new HUD();

        healthbar = new PlayerHealthbar(player, 20, 20);
        hud.addHudElement(healthbar);

    }

    public void tick(){
        objectHandler.tick();
        hud.tick();
    }

    public void render(Graphics g){
        objectHandler.render(g);
        hud.render(g);
    }
}
