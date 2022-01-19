package me.spruce.game.input;

import me.spruce.game.Loop;
import me.spruce.game.gui.GuiElement;
import me.spruce.game.state.State;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.concurrent.CopyOnWriteArrayList;

public class MouseInput implements MouseListener, MouseMotionListener {

    public boolean leftPressed = false;
    public boolean rightPressed = false;
    public int mouseX = 0, mouseY = 0;

    public CopyOnWriteArrayList<GuiElement> elements;

    public MouseInput(Loop loop) {
        this.elements = loop.stateManager.getCurrentState().elements;
    }
    @Override
    public void mousePressed(MouseEvent e) {
        switch(e.getButton()){
            case 1:
                leftPressed = true;
                break;

            case 3:
                rightPressed = true;
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch(e.getButton()){
            case 1:
                leftPressed = false;
                break;

            case 3:
                rightPressed = false;
                break;
        }

        elements.forEach(element -> {
            element.onMouseRelease(e);
        });
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        elements.forEach(element -> {
           element.onMouseMove(e);
        });
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    public void onStateChange(State newState){
        this.elements = newState.elements;
    }
}
