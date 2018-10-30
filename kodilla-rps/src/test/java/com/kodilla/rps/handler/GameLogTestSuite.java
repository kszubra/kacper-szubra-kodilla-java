package com.kodilla.rps.handler;

import com.kodilla.rps.enumerics.ChoiceOption;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

import static com.kodilla.rps.enumerics.ChoiceOption.ROCK;
import static com.kodilla.rps.enumerics.ChoiceOption.SCISSORS;

public class GameLogTestSuite {

    @Test
    public void testToString(){
        //Given
        LocalDateTime testTime = LocalDateTime.of(2018,10,28,13, 55, 14);
        ChoiceOption testHumanChoice = SCISSORS;
        ChoiceOption testComputerChoice = ROCK;
        String testResult = "Computer won";
        GameLog testGameLog = new GameLog(testTime, testHumanChoice, testComputerChoice, testResult);

        //When
        String expectedString = "2018-10-28 13:55:14: player chose: SCISSORS, computer chose: ROCK, result: Computer won";
        String realString = testGameLog.toString();

        //Then
        Assert.assertTrue(expectedString.equals(realString));

    }
}
