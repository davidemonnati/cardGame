package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.Card;
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
        boolean status = true;
        do {
            for (int i = 0; i < 2; i++) {
                status = doAction();
                if (!status)
                    break;
            }
            rule();
        } while (status);
    }

    private boolean doAction() {
        //throwCard();
        //takeCardFromTable();
        currentPlayer = opponentPlayer(currentPlayer);

        return players.get(currentPlayer).getPlayerDeckSize() != 0;
    }

    private int opponentPlayer(int i) {
        return (i + 1) % 2;
    }

    private void takeFirstCards(int playerID, int num) {
        int playerCards = players.get(playerID).getPlayerDeck().getCards().size();
        if (playerCards == 0)
            gameController.takeMultipleCards(num, players.get(playerID));
    }

    private void throwCard(Integer pos) {
        gameController.playCard(players.get(currentPlayer), pos);
    }

    private void takeCardFromTable() {
        if (gameController.getDeckSize() > 0)
            gameController.takeCard(players.get(currentPlayer));
    }

    private void rule() {
        Card player1ThrowedCard = gameController.getBriscolaDeck().getPlayer1ThrowingCard();
        Card player2ThrowedCard = gameController.getBriscolaDeck().getPlayer2ThrowingCard();
        int scoreCard1 = player1ThrowedCard.getRankValue().getScore();
        int scoreCard2 = player2ThrowedCard.getRankValue().getScore();
        if (scoreCard1 > scoreCard2) {
            players.get(0).setScore(scoreCard1 + scoreCard2);
        } else {
            players.get(1).setScore(scoreCard1 + scoreCard2);
        }
        gameController.getBriscolaDeck().initThrowingCards();
    }
}
