package me.spruce.game.state;

import me.spruce.game.Loop;
import me.spruce.game.state.states.GameState;

public class StateManager {

    private State currentState;

    public StateManager(Loop loop){
        setCurrentState(new GameState(loop));
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getCurrentState() {
        return currentState;
    }
}
