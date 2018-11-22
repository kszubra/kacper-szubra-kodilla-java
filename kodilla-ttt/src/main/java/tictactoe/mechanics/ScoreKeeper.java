package tictactoe.mechanics;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ScoreKeeper implements Serializable {
    private int wonByPlayer;
    private int lostByPlayer;
    private double winLoseRatio;

    public ScoreKeeper() {
        this.wonByPlayer = 0;
        this.lostByPlayer = 0;
        this.winLoseRatio = 0.0;
    }

    public int getWonByPlayer() {
        return wonByPlayer;
    }

    public void addWonByPlayer() {
        wonByPlayer++;
        winLoseRatio = (double)wonByPlayer / (double)lostByPlayer;
    }

    public int getLostByPlayer() {
        return lostByPlayer;
    }

    public void addLostByPlayer() {
        lostByPlayer++;
        winLoseRatio = (double)wonByPlayer / (double)lostByPlayer;
    }

    public double getWinLoseRatio() {
        return roundDouble();
    }

    private double roundDouble() {
        return BigDecimal.valueOf(winLoseRatio).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
    }

    @Override
    public String toString() {
        return "Won games: " + wonByPlayer + " | Lost games: " + lostByPlayer + " | W/L ratio: " + roundDouble() + "\r\n";
    }
}
