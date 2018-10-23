package com.kodilla.rps.players;

import com.kodilla.rps.choices.ChoiceOption;
import com.kodilla.rps.handler.Rules;

import java.util.Random;

public class ComputerPlayer implements PlayerInterface {
    private int wonRoundsNumber;
    Random rng = new Random();

    @Override
    public String getName() {
        return "Computer";
    }

    @Override
    public int getWonRoundsNumber() {
        return this.wonRoundsNumber;
    }

    @Override
    public void addWonRound() {
        this.wonRoundsNumber++;
    }

    public ChoiceOption getComputerChoice(ChoiceOption humanChoice){
        int decider = rng.nextInt(3);
        ChoiceOption decision;
        switch (decider){
            case 0:
                decision = Rules.giveRandomWinnerWith(humanChoice); // winning
                break;
            case 1:
                decision = humanChoice; // drawing
                break;
             default:
                 decision = Rules.giveRandomLoserWith(humanChoice); // losing
        }

        System.out.println("Computer's choice: "+decision);
        return decision;
    }

}
