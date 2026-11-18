package com.example.Arbitrio.utils;

public class FiniteStateMachineState {
    private final String currentState;

    private final String nextState;

    private final String processType;

    FiniteStateMachineState(String currentState, String nextState, String processType){
        this.currentState = currentState;
        this.nextState = nextState;
        this.processType = processType;
    }
}
