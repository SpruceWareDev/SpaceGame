package me.spruce.game.hud.element.elements;

import me.spruce.game.hud.element.HUDElement;
import me.spruce.game.player.Player;
import me.spruce.game.state.states.GameState;

import java.awt.*;

public class PlayerHealthbar extends HUDElement {

    Player player;

    public PlayerHealthbar(Player player, int x, int y){
        super(x, y);
        this.player = player;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(x, y, 200, 32);
        g.setColor(Color.red);
        g.fillRect(x, y, player.health * 2, 32);
    }
}
