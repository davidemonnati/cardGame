package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.Player;

import java.util.ArrayList;
import java.util.List;

public class GameCoordinator {
    private final List<Player> players = new ArrayList<>();
    private int currentPlayer;

    public GameCoordinator() {
        this.currentPlayer = 0;
    }

    public void play() {
        while (doAction()) ;
    }

    private boolean doAction() {
        this.currentPlayer = opponentPlayer(currentPlayer);
        return true;
    }

    private int opponentPlayer(int i) {
        return (i + 1) % 2;
    }
}
