package com.kodilla.rps.players;

import org.junit.Assert;
import org.junit.Test;


public class HumanPlayerTestSuite {

    HumanPlayer testHumanPlayer = new HumanPlayer("John Rambo");

    @Test
    public void testGetName(){
        //When
        String expectedName = "John Rambo";
        String realName = testHumanPlayer.getName();

        //Then
        Assert.assertEquals(expectedName, realName);
    }

    @Test
    public void testAddWonRound(){
        //Given
        testHumanPlayer.addWonRound();

        //When
        int expectedWonRounds = 1;
        int realWonRounds = testHumanPlayer.getWonRoundsNumber();

        //Then
        Assert.assertEquals(expectedWonRounds, realWonRounds);

    }

    @Test
    public void testGetWonRoundsNumber(){
        //Given
        HumanPlayer testHumanPlayer = new HumanPlayer("John Rambo");

        //When
        int expectedWonRounds = 0;
        int realWonRounds = testHumanPlayer.getWonRoundsNumber();

        //Then
        Assert.assertEquals(expectedWonRounds, realWonRounds);
    }
}
