package com.kodilla.rps.handler;

import com.kodilla.rps.choices.ChoiceOption;
import java.util.*;
import java.util.List;

import static com.kodilla.rps.choices.ChoiceOption.*;

public class Rules {

    private static List<ChoiceOption> beatenByRock = new ArrayList<ChoiceOption>(){
        {
            add(scissors);
            add(lizard);
        }
    };

    private static List<ChoiceOption> beatenByPaper = new ArrayList<ChoiceOption>(){
        {
            add(rock);
            add(spock);
        }
    };

    private static List<ChoiceOption> beatenByScissors = new ArrayList<ChoiceOption>(){
        {
            add(paper);
            add(lizard);
        }
    };

    private static List<ChoiceOption> beatenBySpock = new ArrayList<ChoiceOption>(){
        {
            add(scissors);
            add(rock);
        }
    };

    private static List<ChoiceOption> beatenByLizard = new ArrayList<ChoiceOption>(){
        {
            add(paper);
            add(spock);
        }
    };

    private static Map<ChoiceOption, List<ChoiceOption>> whoInputBeats = new HashMap<ChoiceOption, List<ChoiceOption>>(){
        {
            put(rock, beatenByRock);
            put(paper, beatenByPaper);
            put(scissors, beatenByScissors);
            put(spock, beatenBySpock);
            put(lizard, beatenByLizard);
        }
    };

    private static List<ChoiceOption> rockLosesTo = new ArrayList<ChoiceOption>(){
        {
            add(paper);
            add(spock);
        }
    };

    private static List<ChoiceOption> paperkLosesTo = new ArrayList<ChoiceOption>(){
        {
            add(lizard);
            add(scissors);
        }
    };

    private static List<ChoiceOption> scissorsLosesTo = new ArrayList<ChoiceOption>(){
        {
            add(spock);
            add(rock);
        }
    };

    private static List<ChoiceOption> spockLosesTo = new ArrayList<ChoiceOption>(){
        {
            add(lizard);
            add(paper);
        }
    };

    private static List<ChoiceOption> lizardLosesTo = new ArrayList<ChoiceOption>(){
        {
            add(rock);
            add(scissors);
        }
    };

    private static Map<ChoiceOption, List<ChoiceOption>> whoInputLosesTo = new HashMap<ChoiceOption, List<ChoiceOption>>(){
        {
            put(rock, rockLosesTo);
            put(paper, paperkLosesTo);
            put(scissors, scissorsLosesTo);
            put(spock, spockLosesTo);
            put(lizard, lizardLosesTo);
        }
    };

    public static ChoiceOption giveRandomWinnerWith(ChoiceOption choice){
        Random rng = new Random();
        int limit = whoInputLosesTo.get(choice).size();
        return whoInputLosesTo.get(choice).get(rng.nextInt(limit));


    }

    public static ChoiceOption giveRandomLoserWith(ChoiceOption choice){
        Random rng = new Random();
        int limit = whoInputBeats.get(choice).size();
        return whoInputBeats.get(choice).get(rng.nextInt(limit));

    }

    public static int tellWinner (ChoiceOption first, ChoiceOption second){
        if(first.equals(second)){ // draw
            return 0;
        } if (whoInputBeats.get(first).contains(second)){ // second is on the list of items beaten by first - wins first
            return 1;
        } else{
            return 2;
        }

    }

    public static void displayRules(){
        System.out.println("Welcome to the modified rock-paper-scissors game. In this game you can choose:");
        System.out.println(
                "\n1: Rock. It beats scissors and lizard" +
                "\n2: Paper. It beats rock and spock" +
                "\n3: Scissors. It beats paper and lizard" +
                "\n4: Spock. It beats scissors and rock"+
                "\n5: Lizard. It beats paper and spock" +
                "\nx: exit game" +
                "\nn: start new game"+
                "\r\n ------------------------------------------------------------------------------");
    }

}
