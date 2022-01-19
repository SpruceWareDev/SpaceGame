package me.spruce.game.state;

import me.spruce.game.Loop;
import me.spruce.game.state.states.GameState;
import me.spruce.game.state.states.menu.MenuState;

public class StateManager {

    private State currentState;

    public StateManager(Loop loop){
        currentState = new MenuState(loop);
    }

    public void setCurrentState(State currentState) {
        this.currentState.elements.clear();
        this.currentState = currentState;
    }

    public State getCurrentState() {
        return currentState;
    }
}
