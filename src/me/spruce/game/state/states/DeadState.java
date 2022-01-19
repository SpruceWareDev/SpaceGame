package me.spruce.game.state.states;

import me.spruce.game.Loop;
import me.spruce.game.font.FontRenderer;
import me.spruce.game.state.State;
import me.spruce.game.state.states.menu.MenuState;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class DeadState extends State {

    public int score, level;
    public DeadState(Loop loop, int score, int level) {
        super("DeadState", loop);
        this.score = score;
        this.level = level;
    }

    @Override
    public void tick() {
        if(loop.keyInputManager.spacePressed){
            loop.stateManager.setCurrentState(new GameState(loop));
        }

        if (loop.keyInputManager.escPressed){
            loop.stateManager.setCurrentState(new MenuState(loop));
        }
    }

    @Override
    public void render(Graphics g) {
        FontRenderer.drawString(g, "You died, very sad day indeed :(", loop.width / 2, loop.height / 3, true, Color.black, loop.fonts.font50);
        FontRenderer.drawString(g, "Total Score " + score, loop.width / 2, (loop.height / 2) - 80, true, Color.black, loop.fonts.font18);
        FontRenderer.drawString(g, "Level Reached " + level, loop.width / 2, (loop.height / 2) - 60, true, Color.black, loop.fonts.font18);

        FontRenderer.drawString(g, "Press esc to go to the main menu", 10, 20, false, Color.black, loop.fonts.font22);
        FontRenderer.drawString(g, "Press space to continue", loop.width / 2, (loop.height - 100), true, Color.black, loop.fonts.font22);
    }
}
