package tictactoe.mechanics;

import org.junit.Assert;
import org.junit.Test;
import tictactoe.enumerics.CellStatus;

import static tictactoe.enumerics.CellStatus.CIRCLE;
import static tictactoe.enumerics.CellStatus.CROSS;
import static tictactoe.enumerics.CellStatus.EMPTY;

public class RulesTestSuite {

    @Test
    public void testCheckGameMatrixForWinner(){
        //Given
        CellStatus[][] testMatrix = {
                {CROSS, CROSS, CROSS},
                {EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY}
        };

        //When
        CellStatus expectedResult = CROSS;

        //Then
        Assert.assertEquals(expectedResult, Rules.checkGameMatrixForWinner(testMatrix));

    }

    @Test
    public void testCheckGameMatrixForWinner2(){
        //Given
        CellStatus[][] testMatrix = {
                {CROSS, CIRCLE, CROSS},
                {EMPTY, CROSS, EMPTY},
                {EMPTY, EMPTY, CROSS}
        };

        //When
        CellStatus expectedResult = CROSS;

        //Then
        Assert.assertEquals(expectedResult, Rules.checkGameMatrixForWinner(testMatrix));

    }

    @Test
    public void testCheckGameMatrixForWinner3(){
        //Given
        CellStatus[][] testMatrix = {
                {CROSS, CIRCLE, CIRCLE},
                {EMPTY, CROSS, CIRCLE},
                {EMPTY, EMPTY,CIRCLE}
        };

        //When
        CellStatus expectedResult = CIRCLE;

        //Then
        Assert.assertEquals(expectedResult, Rules.checkGameMatrixForWinner(testMatrix));

    }

    @Test
    public void testCheckGameMatrixForWinner4(){
        //Given
        CellStatus[][] testMatrix = {
                {CROSS, CIRCLE, CROSS},
                {EMPTY, CROSS, CIRCLE},
                {EMPTY, EMPTY,CIRCLE}
        };

        //When
        CellStatus expectedResult = EMPTY;

        //Then
        Assert.assertEquals(expectedResult, Rules.checkGameMatrixForWinner(testMatrix));

    }

    @Test
    public void testCheckGameMatrixForWinner5(){
        //Given
        CellStatus[][] testMatrix = {
                {CIRCLE, CROSS, CIRCLE},
                {CIRCLE, CROSS, CROSS},
                {CIRCLE, CIRCLE,CROSS}
        };

        //When
        CellStatus expectedResult = CIRCLE;

        //Then
        Assert.assertEquals(expectedResult, Rules.checkGameMatrixForWinner(testMatrix));

    }
}
