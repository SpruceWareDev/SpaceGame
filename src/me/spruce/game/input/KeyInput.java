package me.spruce.game.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    public boolean wPressed = false;
    public boolean aPressed = false;
    public boolean sPressed = false;
    public boolean dPressed = false;

    public boolean spacePressed = false;

    public void keyPressed(KeyEvent event){
        int key = event.getKeyCode();
        switch (key){
            case 87:
                wPressed = true;
                break;

            case 65:
                aPressed = true;
                break;

            case 83:
                sPressed = true;
                break;

            case 68:
                dPressed = true;
                break;

            case KeyEvent.VK_SPACE:
                spacePressed = true;
                break;
        }
    }

    public void keyReleased(KeyEvent event){
        int key = event.getKeyCode();
        switch (key){
            case 87:
                wPressed = false;
                break;

            case 65:
                aPressed = false;
                break;

            case 83:
                sPressed = false;
                break;

            case 68:
                dPressed = false;
                break;

            case KeyEvent.VK_SPACE:
                spacePressed = false;
                break;
        }
    }

}
