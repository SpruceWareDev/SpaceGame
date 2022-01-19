package me.spruce.game.state;

import me.spruce.game.Loop;
import me.spruce.game.state.states.GameState;
import me.spruce.game.state.states.menu.MenuState;

public class StateManager {

    private State currentState;

    private Loop loop;

    public StateManager(Loop loop){
        this.loop = loop;
        currentState = new MenuState(loop);
    }

    public void setCurrentState(State currentState) {
        this.currentState.elements.clear();
        this.currentState = currentState;
        loop.mouseInputManager.onStateChange(currentState);
    }

    public State getCurrentState() {
        return currentState;
    }
}
