package tictactoe.mechanics;

import tictactoe.enumerics.CellStatus;

public class GameCheckpoint {

    private String playerName;
    private CellStatus[][] gameMatrix;
    private boolean isPlayersTurn;

    public GameCheckpoint(String playerName, CellStatus[][] gameMatrix, boolean isPlayersTurn) {
        this.playerName = playerName;
        this.gameMatrix = gameMatrix;
        this.isPlayersTurn = isPlayersTurn;
    }

    public String getPlayerName() {
        return playerName;
    }

    public CellStatus[][] getGameMatrix() {
        return gameMatrix;
    }

    public boolean isPlayersTurn() {
        return isPlayersTurn;
    }
}
