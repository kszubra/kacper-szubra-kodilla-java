package tictactoe.mechanics;

import tictactoe.enumerics.CellStatus;
import tictactoe.enumerics.GameMode;

import java.io.Serializable;

public class GameCheckpoint implements Serializable {

    private String playerName;
    private CellStatus[][] gameMatrix;
    private boolean isPlayersTurn;
    private GameMode gameMode;

    public GameCheckpoint(String playerName, CellStatus[][] gameMatrix, boolean isPlayersTurn, GameMode gameMode) {
        this.playerName = playerName;
        this.gameMatrix = gameMatrix;
        this.isPlayersTurn = isPlayersTurn;
        this.gameMode = gameMode;
    }

    public GameMode getGameMode() {
        return gameMode;
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
