package tictactoe.mechanics;

import tictactoe.enumerics.CellStatus;

import java.util.Random;


public class Rules {

    public static final Random RANDOM_GENERATOR = new Random();

    public static CellStatus checkGameMatrixForWinner(CellStatus[][] gameMatrix){

        // rows

        if(gameMatrix[0][0].equals(gameMatrix[0][1]) && gameMatrix[0][0].equals(gameMatrix[0][2])) {
            return gameMatrix[0][0];
        }
        if(gameMatrix[1][0].equals(gameMatrix[1][1]) && gameMatrix[1][0].equals(gameMatrix[1][2])) {
            return gameMatrix[1][0];
        }
        if(gameMatrix[2][0].equals(gameMatrix[2][1]) && gameMatrix[2][0].equals(gameMatrix[2][2])) {
            return gameMatrix[2][0];
        }

        // columns

        if(gameMatrix[0][0].equals(gameMatrix[1][0]) && gameMatrix[0][0].equals(gameMatrix[2][0])) {
            return gameMatrix[0][0];
        }
        if(gameMatrix[0][1].equals(gameMatrix[1][1]) && gameMatrix[0][1].equals(gameMatrix[2][1])) {
            return gameMatrix[0][1];
        }
        if(gameMatrix[0][2].equals(gameMatrix[1][2]) && gameMatrix[0][2].equals(gameMatrix[2][2])) {
            return gameMatrix[0][2];
        }

        // diagonals

        if(gameMatrix[0][0].equals(gameMatrix[1][1]) && gameMatrix[0][0].equals(gameMatrix[2][2])) {
            return gameMatrix[0][0];
        }
        if(gameMatrix[0][2].equals(gameMatrix[1][1]) && gameMatrix[0][2].equals(gameMatrix[2][0])) {
            return gameMatrix[0][2];
        }

        return CellStatus.EMPTY;

    }
}
