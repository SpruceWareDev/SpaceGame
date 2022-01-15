package me.spruce.game.hud;

import me.spruce.game.hud.element.HUDElement;

import java.awt.*;
import java.util.LinkedList;

public class HUD {

    public LinkedList<HUDElement> hudElements = new LinkedList<>();

    public void tick(){
        hudElements.forEach(HUDElement::tick);
    }

    public void render(Graphics g){
        hudElements.forEach(element -> {element.render(g);});
    }

    public void addHudElement(HUDElement element){
        hudElements.add(element);
    }

    public void removeHudElement(HUDElement element){
        hudElements.remove(element);
    }

    public LinkedList<HUDElement> getHudElements() {
        return hudElements;
    }
}
