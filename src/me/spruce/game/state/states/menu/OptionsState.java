package me.spruce.game.state.states.menu;

import me.spruce.game.Loop;
import me.spruce.game.font.FontRenderer;
import me.spruce.game.gui.GuiElement;
import me.spruce.game.gui.impl.GuiToggle;
import me.spruce.game.setting.Setting;
import me.spruce.game.state.State;

import java.awt.*;

public class OptionsState extends State {

    public OptionsState(Loop loop){
        super("Options", loop);
        for(Setting<?> s : loop.settingsManager.settings){
            Setting<?> setting = s;

            if(s.getValue() instanceof Boolean){
                GuiToggle toggle = new GuiToggle(loop.width / 2, loop.height / 3, 200, 50, (Setting<Boolean>) setting, loop, () ->{
                    Setting<Boolean> Bsetting = (Setting<Boolean>) setting;
                    Bsetting.setValue(!Bsetting.getValue());
                });
                elements.add(toggle);
            }
        }
    }

    @Override
    public void tick() {
        elements.forEach(GuiElement::tick);

        if (loop.keyInputManager.escPressed){
            loop.stateManager.setCurrentState(new MenuState(loop));
        }
    }

    @Override
    public void render(Graphics g) {
        FontRenderer.drawString(g, "Options", loop.width / 2, loop.height / 4, true, Color.black, loop.fonts.font50);
        elements.forEach(element ->{
            element.render(g);
        });
    }
}
