package com.kodilla.rps.players;



public class HumanPlayer implements PlayerInterface {
    private String name;
    private int wonRoundsNumber;

    public HumanPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getWonRoundsNumber() {
        return this.wonRoundsNumber;
    }

    @Override
    public void addWonRound() {
        this.wonRoundsNumber++;
    }

}
