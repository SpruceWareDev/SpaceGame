package me.spruce.game.state.states.menu;

import me.spruce.game.Loop;
import me.spruce.game.font.FontRenderer;
import me.spruce.game.gui.ClickListener;
import me.spruce.game.gui.GuiElement;
import me.spruce.game.gui.impl.GuiButton;
import me.spruce.game.state.State;
import me.spruce.game.state.states.GameState;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class MenuState extends State {

    private Loop loop;

    private GuiButton startButton;
    private GuiButton optionsButton;

    public MenuState(Loop loop){
        super("Menu", loop);
        this.loop = loop;
        // start button
        startButton = new GuiButton("Start", loop.width / 2, loop.height / 3, 200, 50, Color.black, Color.white, loop.fonts.font18, () -> {
            loop.stateManager.setCurrentState(new GameState(loop));
        });
        elements.add(startButton);

        // Options button
        optionsButton = new GuiButton("Options", loop.width / 2, loop.height / 2 - 70, 200, 50, Color.black, Color.white, loop.fonts.font18, () -> {
            loop.stateManager.setCurrentState(new OptionsState(loop));
        });
        elements.add(optionsButton);
    }

    @Override
    public void tick() {
        elements.forEach(GuiElement::tick);
    }

    @Override
    public void render(Graphics g) {
        FontRenderer.drawString(g, "Wave Thingy", loop.width / 2, loop.height / 4, true, Color.black, loop.fonts.font50);
        elements.forEach(element ->{
            element.render(g);
        });
    }
}
