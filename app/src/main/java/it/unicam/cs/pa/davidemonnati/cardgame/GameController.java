package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.DefaultPlayer;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Player;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final List<Player> players = new ArrayList<>();
    private GameCoordinator gameCoordinator;
    private int currentPlayer;

    public GameController() {
        initGameCoordinator();
        genPlayer();
        this.currentPlayer = 0;
    }

    public void play() {
        while (doAction()) ;
    }

    private boolean doAction() {
        return true;
    }

    private void initGameCoordinator() {
        gameCoordinator = new GameCoordinator();
    }

    private void genPlayer() {
        Player player1 = new DefaultPlayer(0, "Davide");
        Player player2 = new DefaultPlayer(1, "Riccardo");
        this.players.add(player1);
        this.players.add(player2);
    }
}
