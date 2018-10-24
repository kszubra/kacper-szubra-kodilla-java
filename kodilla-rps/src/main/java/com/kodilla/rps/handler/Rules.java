package com.kodilla.rps.handler;


import com.kodilla.rps.choices.ChoiceOption;
import com.kodilla.rps.choices.RoundResult;

import java.util.*;

import static com.kodilla.rps.choices.ChoiceOption.LIZARD;
import static com.kodilla.rps.choices.ChoiceOption.PAPER;
import static com.kodilla.rps.choices.ChoiceOption.ROCK;
import static com.kodilla.rps.choices.ChoiceOption.SCISSORS;
import static com.kodilla.rps.choices.ChoiceOption.SPOCK;

public class Rules {

    private static final Random RANDOM = new Random();

    private static final List<ChoiceOption> BEATEN_BY_ROCK = Arrays.asList(LIZARD, SCISSORS);

    private static final List<ChoiceOption> BEATEN_BY_PAPER = Arrays.asList(ROCK, SPOCK);

    private static final List<ChoiceOption> BEATEN_BY_SCISSORS = Arrays.asList(PAPER, LIZARD);

    private static final List<ChoiceOption> BEATEN_BY_SPOCK = Arrays.asList(SCISSORS, ROCK);

    private static final List<ChoiceOption> BEATEN_BY_LIZARD = Arrays.asList(PAPER, SPOCK);

    private static Map<ChoiceOption, List<ChoiceOption>> whoInputBeats = new HashMap<ChoiceOption, List<ChoiceOption>>(){
        {
            put(ROCK, BEATEN_BY_ROCK);
            put(PAPER, BEATEN_BY_PAPER);
            put(SCISSORS, BEATEN_BY_SCISSORS);
            put(SPOCK, BEATEN_BY_SPOCK);
            put(LIZARD, BEATEN_BY_LIZARD);
        }
    };

    private static final List<ChoiceOption> ROCK_LOSES_TO = Arrays.asList(PAPER, SPOCK);


    private static final List<ChoiceOption> paperkLosesTo = Arrays.asList(LIZARD, SPOCK);

    private static final List<ChoiceOption> scissorsLosesTo = Arrays.asList(SPOCK, ROCK);

    private static final List<ChoiceOption> spockLosesTo = Arrays.asList(LIZARD, PAPER);

    private static final List<ChoiceOption> lizardLosesTo = Arrays.asList(ROCK, SCISSORS);

    private static Map<ChoiceOption, List<ChoiceOption>> whoInputLosesTo = new HashMap<ChoiceOption, List<ChoiceOption>>(){
        {
            put(ROCK, ROCK_LOSES_TO);
            put(PAPER, paperkLosesTo);
            put(SCISSORS, scissorsLosesTo);
            put(SPOCK, spockLosesTo);
            put(LIZARD, lizardLosesTo);
        }
    };

    public static ChoiceOption giveRandomWinnerWith(ChoiceOption choice){
        int limit = whoInputLosesTo.get(choice).size();
        return whoInputLosesTo.get(choice).get(RANDOM.nextInt(limit));


    }

    public static ChoiceOption giveRandomLoserWith(ChoiceOption choice){
        int limit = whoInputBeats.get(choice).size();
        return whoInputBeats.get(choice).get(RANDOM.nextInt(limit));

    }

    public static RoundResult tellWinner (ChoiceOption first, ChoiceOption second){
        if(first.equals(second)){ // draw
            return RoundResult.DRAW;
        } if (whoInputBeats.get(first).contains(second)){ // second is on the list of items beaten by first - wins first
            return RoundResult.HUMAN_WINS;
        } else{
            return RoundResult.COMPUTER_WINS;
        }

    }

    public static void displayRules(){
        System.out.println("Welcome to the modified ROCK-PAPER-SCISSORS game. In this game you can choose:");
        System.out.println(
                "\n1: Rock. It beats SCISSORS and LIZARD" +
                "\n2: Paper. It beats ROCK and SPOCK" +
                "\n3: Scissors. It beats PAPER and LIZARD" +
                "\n4: Spock. It beats SCISSORS and ROCK"+
                "\n5: Lizard. It beats PAPER and SPOCK" +
                "\nx: exit game" +
                "\nn: start new game"+
                "\r\n ------------------------------------------------------------------------------");
    }

}
