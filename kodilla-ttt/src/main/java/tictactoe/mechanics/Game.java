package tictactoe.mechanics;

import tictactoe.enumerics.CellStatus;
import tictactoe.enumerics.GameMode;

import java.util.Arrays;

public class Game {

    private final int MATRIX_RAWS = 3;
    private final int MATRIX_COLUMNS = 3;
    private String humanPlayerName;
    private CellStatus[][] gameMatrix;
    private CellStatus winner;
    private GameMode gameMode;
    private boolean humanTurn;
    private boolean humanStarts;

    public Game(InitialGameData initialData) {
        this.humanPlayerName = initialData.getPlayerName();
        int random = Rules.RANDOM_GENERATOR.nextInt(2);
        if(random == 0){
            humanStarts = true;
        } else{
            humanStarts = false;
        }

        this.gameMatrix = new CellStatus[MATRIX_RAWS][MATRIX_COLUMNS];
        for(int a = 0; a < MATRIX_RAWS; a++){
            for(int b = 0; b < MATRIX_COLUMNS; b++){
                gameMatrix[a][b] = CellStatus.EMPTY;
            }
        }

        this.winner = CellStatus.EMPTY;
        this.gameMode = initialData.getGameMode();

    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public CellStatus getWinner() {
        return winner;
    }

    public void setWinner(CellStatus winner) {
        this.winner = winner;
    }

    public CellStatus[][] getGameMatrix() {
        return gameMatrix;
    }


    public String getHumanPlayerName() {return this.humanPlayerName;}
    public boolean getHumanTurn() {return this.humanTurn;}
    public void setGameMatrixValue(int row, int column, CellStatus statusToSet){
        this.gameMatrix[row][column] = statusToSet;
    }

    public void setHumanTurn(boolean valueToSet){
        this.humanTurn = valueToSet;
    }

    public boolean getHumanStarts() {
        return humanStarts;
    }

    public void play() {

        if(!humanStarts){ // computer's opening move
            humanTurn = false;

            if(gameMode.equals(GameMode.RANDOM)){
                // RANDOM MOVE
            } else {
                // STRATEGIC MOVE
            }
        }

        while(winner == CellStatus.EMPTY) {

            humanTurn = true;
            // WAIT FOR MOVE
            while(humanTurn){
                /**
                 * prevents computer making move before human. Loop condition changed by board clicking in TicTacToeRunner
                 */
            }
            // MAKE COMPUTER MOVE
            gameMatrix[1][1] = CellStatus.CIRCLE;


            winner = Rules.checkGameMatrixForWinner(gameMatrix);
            if(winner.equals(CellStatus.CROSS)){ // Human wins

                // THINGS TO DO WHEN HUMAN WINS

            } else if(winner.equals(CellStatus.CIRCLE)){ // Computer wins

                // THINGS TO DO WHEN COMPUTER WINS
            } else if(!(Arrays.asList(gameMatrix).contains(CellStatus.EMPTY))){ // Draw

            }


        }


        }


    }



