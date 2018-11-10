package tictactoe.mechanics;

import tictactoe.enumerics.CellStatus;
import tictactoe.enumerics.GameMode;
import tictactoe.enumerics.GameWinner;

public class Game {

    private final int MATRIX_RAWS = 3;
    private final int MATRIX_COLUMNS = 3;
    //private Player humanPlayer;
    //private Player computerPlayer;
    private CellStatus[][] gameMatrix;
    private GameWinner winner;
    private GameMode gameMode;

    public Game(InitialGameData initialData) {

        this.gameMatrix = new CellStatus[MATRIX_RAWS][MATRIX_COLUMNS];
        for(int a = 0; a < MATRIX_RAWS; a++){
            for(int b = 0; b < MATRIX_COLUMNS; b++){
                gameMatrix[a][b] = CellStatus.EMPTY;
            }
        }

        this.winner = GameWinner.NONE;
        this.gameMode = initialData.getGameMode();



    }
}
