package me.spruce.game.state;

import me.spruce.game.state.states.GameState;

public class StateManager {

    private State currentState;

    public StateManager(){
        setCurrentState(new GameState());
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getCurrentState() {
        return currentState;
    }
}
