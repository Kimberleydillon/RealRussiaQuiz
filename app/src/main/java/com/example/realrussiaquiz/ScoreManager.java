package com.example.realrussiaquiz;

// A contract, a set of rules.
// In order to allow fragment to communicate to its activity.
// the fragment and the instaniated quiz fragment references the interface.
// only the main activity answers call.
// Interface is a set of rules that must be fufilled elsewhere, in this case main activity.

public interface ScoreManager {
    void addToScore();

    int getScore();
}
