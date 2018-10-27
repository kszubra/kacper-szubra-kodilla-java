package com.kodilla.rps.players;

import com.kodilla.rps.enumerics.ChoiceOption;
import com.kodilla.rps.handler.Rules;

import java.util.Random;

public class ComputerPlayer implements PlayerInterface {
    private static final Random RANDOM_GENERATOR = new Random();
    private static final int INITIAL_WON_ROUNDS_COUNTER = 0;
    private static final int BOUND = 3;
    private int wonRoundsNumber = INITIAL_WON_ROUNDS_COUNTER;


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
        int decider = RANDOM_GENERATOR.nextInt(BOUND);
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
