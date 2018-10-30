package com.kodilla.rps;

import com.kodilla.rps.handler.Rules;

public class RpsRunner {

    public static void main(String[] args) {

        Rules.displayRules();
        Game newGame = new Game();
        newGame.startNewGame();
    }
}
