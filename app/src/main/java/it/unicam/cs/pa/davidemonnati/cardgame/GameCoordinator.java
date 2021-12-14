package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.Player;

import java.util.ArrayList;
import java.util.List;

public class GameCoordinator {
    private final List<Player> players = new ArrayList<>();
    private final GameController gameController;
    private int currentPlayer;

    public GameCoordinator(Player player1, Player player2) {
        this.gameController = new GameController();
        this.players.add(player1);
        this.players.add(player2);
        this.currentPlayer = 0;
    }

    public void play() {
        while (doAction()) ;
    }

    private boolean doAction() {
        currentPlayer = opponentPlayer(currentPlayer);
        return true;
    }

    private int opponentPlayer(int i) {
        return (i + 1) % 2;
    }

    private void takeFirstCards(int num) {
        int playerCards = players.get(currentPlayer).getPlayerDeck().getCards().size();
        if (playerCards == 0)
            gameController.takeMultipleCards(num, players.get(currentPlayer));
    }

    private void throwCard(Integer pos) {
        gameController.playCard(players.get(currentPlayer), pos);
    }
}
