package com.kodilla.rps.players;

import com.kodilla.rps.enumerics.ChoiceOption;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.kodilla.rps.enumerics.ChoiceOption.*;

public class ComputerPlayerTestSuite {

    ComputerPlayer testComputerplayer = new ComputerPlayer();

    @Test
    public void testGetName(){
        //When
        String expectedName = "Computer";
        String realName = testComputerplayer.getName();

        //Then
        Assert.assertEquals(expectedName, realName);
    }

    @Test
    public void testGetComputerChoice(){
        //Given
        List<ChoiceOption> testList = Arrays.asList(PAPER, SCISSORS, ROCK, SPOCK, LIZARD );

        //When
        ChoiceOption testChoice = testComputerplayer.getComputerChoice(SPOCK);

        //Then
        Assert.assertTrue(testList.contains(testChoice));

    }

    @Test
    public void testAddWonRound(){
        //Given
        testComputerplayer.addWonRound();

        //When
        int expectedWonRounds = 1;
        int realWonRounds = testComputerplayer.getWonRoundsNumber();

        //Then
        Assert.assertEquals(expectedWonRounds, realWonRounds);

    }

    @Test
    public void testGetWonRoundsNumber(){
        //Given
        ComputerPlayer testComputerPlayer = new ComputerPlayer();

        //When
        int expectedWonRounds = 0;
        int realWonRounds = testComputerPlayer.getWonRoundsNumber();

        //Then
        Assert.assertEquals(expectedWonRounds, realWonRounds);
    }

}
