package tictactoe.mechanics;

import tictactoe.enumerics.CellStatus;
import tictactoe.enumerics.GameMode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static tictactoe.enumerics.CellStatus.EMPTY;

public class Game {

    private static final int BOUND = 2;
    private static final int MATRIX_ROWS = 3;
    private static final int MATRIX_COLUMNS = 3;
    private static final int NUMBER_OF_MATRIX_FIELDS = MATRIX_COLUMNS * MATRIX_ROWS;
    private static final int HUMAN_STARTS = 0;
    private String humanPlayerName;
    private CellStatus[][] gameMatrix;
    private CellStatus winner;
    private GameMode gameMode;
    private boolean humanTurn;
    private boolean humanStarts;
    private int computerChoiceRow;
    private int computerChoiceColumn;
    private Map<String, List<CellStatus>> mapOfAvaiableLinesInGameMatrix;

    public Game(InitialGameData initialData) {
        this.humanPlayerName = initialData.getPlayerName();
        this.winner = EMPTY;
        this.gameMode = initialData.getGameMode();
        this.humanStarts = verifyIfHumanStarts();
        this.gameMatrix = createBoard();
        this.mapOfAvaiableLinesInGameMatrix = Rules.makeMapOfLineCoordinatesInMatrix(gameMatrix);
    }

    private CellStatus[][] createBoard() {
        CellStatus[][] gameMatrix = new CellStatus[MATRIX_ROWS][MATRIX_COLUMNS];

        for (int a = 0; a < MATRIX_ROWS; a++) {
            for (int b = 0; b < MATRIX_COLUMNS; b++) {
                gameMatrix[a][b] = EMPTY;
            }
        }
        return gameMatrix;
    }

    private boolean verifyIfHumanStarts() {
        int random = Rules.RANDOM_GENERATOR.nextInt(BOUND);

        return random == HUMAN_STARTS;
    }

    public CellStatus getWinner() {
        return winner;
    }

    public CellStatus[][] getGameMatrix() {
        return gameMatrix;
    }

    public String getHumanPlayerName() {
        return this.humanPlayerName;
    }

    public boolean getHumanTurn() {
        return this.humanTurn;
    }

    public boolean getHumanStarts() {
        return humanStarts;
    }

    public int getComputerChoiceRow() {
        return computerChoiceRow;
    }

    public int getComputerChoiceColumn() {
        return computerChoiceColumn;
    }

    public void setWinner(CellStatus winner) {
        this.winner = winner;
    }

    public void setGameMatrixValue(int row, int column, CellStatus statusToSet) {
        this.gameMatrix[row][column] = statusToSet;
    }

    public void setHumanTurn(boolean valueToSet) {
        this.humanTurn = valueToSet;
    }

    private void makeRandomComputerMove() {
        int randomRow = Rules.RANDOM_GENERATOR.nextInt(MATRIX_ROWS);
        int randomColumn = Rules.RANDOM_GENERATOR.nextInt(MATRIX_COLUMNS);

        if (gameMatrix[randomRow][randomColumn].equals(EMPTY)) {
            setComputerChoiceFor(randomRow, randomColumn);
            System.out.println("Chosen cell: row " + randomRow + " column " + randomColumn);

        } else {
            makeRandomComputerMove();
        }
    }

    private boolean checkIfHaveAnyFreeCorner() {
        return ((gameMatrix[0][0].equals(EMPTY)) || (gameMatrix[MATRIX_ROWS-1][0].equals(EMPTY)) || (gameMatrix[0][MATRIX_COLUMNS-1].equals(EMPTY)) || (gameMatrix[MATRIX_ROWS-1][MATRIX_COLUMNS-1].equals(EMPTY)));
    }

    public void playRandomCorner(){

        if(checkIfHaveAnyFreeCorner()) {
            int randomCornerToPlay = Rules.RANDOM_GENERATOR.nextInt(4);

            //Top left corner
            if(randomCornerToPlay == 0 && gameMatrix[0][0].equals(EMPTY)) {
                setComputerChoiceFor(0,0);
            }
            //Bottom left corner
            else if(randomCornerToPlay == 1 && gameMatrix[MATRIX_ROWS-1][0].equals(EMPTY)) {
                setComputerChoiceFor(MATRIX_ROWS-1,0);
            }
            //Top right corner
            else if(randomCornerToPlay == 2 && gameMatrix[0][MATRIX_COLUMNS-1].equals(EMPTY)) {
                setComputerChoiceFor(0,MATRIX_COLUMNS-1);
            }
            //Bottom right corner
            else if(randomCornerToPlay == 3 && gameMatrix[MATRIX_ROWS-1][MATRIX_COLUMNS-1].equals(EMPTY)) {
                setComputerChoiceFor(MATRIX_ROWS-1, MATRIX_COLUMNS-1);
            }
            //If random corner is taken, try again
            else {
                playRandomCorner();
            }
        }
    }


    public void playOppositeCornerTo(int row, int column) {
        int oppositeRow = 0;
        int oppositeColumn = 0;

        if(row == 0) {
            oppositeRow = MATRIX_ROWS-1;
        } else if (row == MATRIX_ROWS-1) {
            oppositeRow = 0;
        }

        if(column == 0) {
            oppositeColumn = MATRIX_COLUMNS-1;
        } else if (column == MATRIX_COLUMNS-1) {
            oppositeColumn = 0;
        }

        if(gameMatrix[oppositeRow][oppositeColumn].equals(EMPTY)){
            setComputerChoiceFor(oppositeRow, oppositeColumn);
        }

    }

    private void makeStrategicComputerMove() {

        int howManyEmptyCells = (int)Arrays.stream(gameMatrix)
                .flatMap(Arrays::stream)
                .filter(e->e.equals(EMPTY))
                .count();

        //checks if it's opening move
        if(howManyEmptyCells == NUMBER_OF_MATRIX_FIELDS) {
            playRandomCorner();
        }

    }

    private void setComputerChoiceFor(int row, int column) {
        gameMatrix[row][column] = CellStatus.CIRCLE;
        computerChoiceRow = row;
        computerChoiceColumn = column;
    }

    public void makeComputerMove() {
        if (!humanTurn) {

            if (gameMode.equals(GameMode.RANDOM)) {
                makeRandomComputerMove();
            } else if (gameMode.equals(GameMode.STRATEGIC)) {
                makeStrategicComputerMove();
            }
        }

        humanTurn = true;
    }


}



