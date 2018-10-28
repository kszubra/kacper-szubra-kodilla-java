package com.kodilla.rps.handler;

import com.kodilla.rps.enumerics.ChoiceOption;
import com.kodilla.rps.enumerics.RoundResult;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.kodilla.rps.enumerics.ChoiceOption.PAPER;
import static com.kodilla.rps.enumerics.ChoiceOption.ROCK;
import static com.kodilla.rps.enumerics.ChoiceOption.SPOCK;
import static com.kodilla.rps.enumerics.RoundResult.HUMAN_WINS;

public class RulesTestSuite {

    @Test
    public void testGiveRandomWinnerWith(){
        //When
        ChoiceOption example = Rules.giveRandomWinnerWith(ROCK);
        List<ChoiceOption> testRockLosesTo = Arrays.asList(PAPER, SPOCK);

        //Then
        Assert.assertTrue(testRockLosesTo.contains(example));
    }

    @Test
    public void testGiveRandomLoserrWith(){
        //When
        ChoiceOption example = Rules.giveRandomLoserWith(PAPER);
        List<ChoiceOption> testBeatenByPaper = Arrays.asList(ROCK, SPOCK);

        //Then
        Assert.assertTrue(testBeatenByPaper.contains(example));
    }

    @Test
    public void testTellWinner(){
        //When
        ChoiceOption humanChoice = PAPER;
        ChoiceOption computerChoice = ROCK;
        RoundResult realResult = Rules.tellWinner(humanChoice, computerChoice);
        RoundResult expectedResult = HUMAN_WINS;

        //Then
        Assert.assertEquals(expectedResult, realResult);
    }
}
