package tictactoe.mechanics;

import java.io.Serializable;

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

        if(lostByPlayer == 0) {
            winLoseRatio = (double) wonByPlayer;
        } else {
            winLoseRatio = (double)wonByPlayer / (double)lostByPlayer;
        }
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
        return Math.round(winLoseRatio *100.0) / 100.0;
    }

    @Override
    public String toString() {
        return "Won games: " + wonByPlayer + " | Lost games: " + lostByPlayer + " | W/L ratio: " + roundDouble() + "\r\n";
    }
}
