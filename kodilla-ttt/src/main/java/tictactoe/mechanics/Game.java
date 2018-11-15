package tictactoe.mechanics;

import tictactoe.enumerics.CellStatus;
import tictactoe.enumerics.GameMode;

import java.util.Arrays;

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

    public Game(InitialGameData initialData) {
        this.humanPlayerName = initialData.getPlayerName();
        this.winner = CellStatus.EMPTY;
        this.gameMode = initialData.getGameMode();
        this.humanStarts = verifyIfHumanStarts();
        this.gameMatrix = createBoard();
    }

    private CellStatus[][] createBoard() {
        CellStatus[][] gameMatrix = new CellStatus[MATRIX_ROWS][MATRIX_COLUMNS];

        for (int a = 0; a < MATRIX_ROWS; a++) {
            for (int b = 0; b < MATRIX_COLUMNS; b++) {
                gameMatrix[a][b] = CellStatus.EMPTY;
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

        if (gameMatrix[randomRow][randomColumn].equals(CellStatus.EMPTY)) {
            setComputerChoiceFor(randomRow, randomColumn);
            System.out.println("Chosen cell: row " + randomRow + " column " + randomColumn);

        } else {
            makeRandomComputerMove();
        }
    }

    private void makeStrategicComputerMove() {

        int howManyEmptyCells = (int)Arrays.stream(gameMatrix)
                .flatMap(Arrays::stream)
                .filter(e->e.equals(CellStatus.EMPTY))
                .count();

        //checks if it's opening move
        if(howManyEmptyCells == NUMBER_OF_MATRIX_FIELDS) {

            int randomCornerToPlay = Rules.RANDOM_GENERATOR.nextInt(4);
            switch(randomCornerToPlay){
                // Top left corner
                case 0:
                    setComputerChoiceFor(0, 0);
                // Bottom left corner
                case 1:
                    setComputerChoiceFor(MATRIX_ROWS-1, 0);
                // Top right corner
                case 2:
                    setComputerChoiceFor(0, MATRIX_COLUMNS-1);
                //Bottom right corner
                case 3:
                    setComputerChoiceFor(MATRIX_ROWS-1, MATRIX_COLUMNS-1);
            }

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



