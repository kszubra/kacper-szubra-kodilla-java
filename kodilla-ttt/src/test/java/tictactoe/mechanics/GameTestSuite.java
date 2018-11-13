package tictactoe.mechanics;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tictactoe.enumerics.CellStatus;
import tictactoe.enumerics.GameMode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameTestSuite {

    Game testGame = new Game(new InitialGameData("testName", GameMode.RANDOM));

    @Test
    public void testGameMatrixCreation(){
        //Given
        CellStatus[][] testMatrix = testGame.getGameMatrix();

        //When
        CellStatus expectedStatus = CellStatus.EMPTY;

        CellStatus realStatus00 = testMatrix[0][0];
        CellStatus realStatus01 = testMatrix[0][1];
        CellStatus realStatus02 = testMatrix[0][2];
        CellStatus realStatus10 = testMatrix[1][0];
        CellStatus realStatus11 = testMatrix[1][1];
        CellStatus realStatus12 = testMatrix[1][2];
        CellStatus realStatus20 = testMatrix[2][0];
        CellStatus realStatus21 = testMatrix[2][1];
        CellStatus realStatus22 = testMatrix[2][2];

        //Then
        Assert.assertEquals(expectedStatus, realStatus00);
        Assert.assertEquals(expectedStatus, realStatus01);
        Assert.assertEquals(expectedStatus, realStatus02);
        Assert.assertEquals(expectedStatus, realStatus10);
        Assert.assertEquals(expectedStatus, realStatus11);
        Assert.assertEquals(expectedStatus, realStatus12);
        Assert.assertEquals(expectedStatus, realStatus20);
        Assert.assertEquals(expectedStatus, realStatus21);
        Assert.assertEquals(expectedStatus, realStatus22);

    }


    @Test
    public void testMakeRandomComputerMove(){
        //Given
        testGame.makeComputerMove();

        //When
        boolean expectedCircle = true;
        List<CellStatus> matrixElements = Arrays.stream(testGame.getGameMatrix())
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        boolean realCircle = matrixElements.contains(CellStatus.CIRCLE);

        //Then
        Assert.assertEquals(expectedCircle, realCircle);


    }

}
