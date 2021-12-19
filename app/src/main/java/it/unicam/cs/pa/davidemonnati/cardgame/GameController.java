package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.*;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.BriscolaRank;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.BriscolaSeed;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola.*;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final List<Player> players;
    private final BriscolaDeck tableDeck;
    private List<PlayerDeck> playerDecks;
    private int currentPlayer;

    public GameController(List<Player> players) {
        this.players = players;
        this.tableDeck = BriscolaDeck.empty();
        initTableDeck();
        initPlayerDecks();
        this.currentPlayer = 0;
    }

    private void takeCard() {
        if (tableDeck.getSize() > 0) {
            Card toTake = tableDeck.removeCard();
            playerDecks.get(currentPlayer).insertCard(toTake);
        }
    }

    private void initTableDeck() {
        for (int i = 0; i < 4; i++) {
            tableDeck.insertCard(new Asso(BriscolaSeed.values()[i]));
            tableDeck.insertCard(new Tre(BriscolaSeed.values()[i]));
            tableDeck.insertCard(new Fante(BriscolaSeed.values()[i]));
            tableDeck.insertCard(new Cavallo(BriscolaSeed.values()[i]));
            tableDeck.insertCard(new Re(BriscolaSeed.values()[i]));

            tableDeck.insertCard(new Liscio(BriscolaSeed.values()[i], BriscolaRank.DUE));
            tableDeck.insertCard(new Liscio(BriscolaSeed.values()[i], BriscolaRank.QUATTRO));
            tableDeck.insertCard(new Liscio(BriscolaSeed.values()[i], BriscolaRank.CINQUE));
            tableDeck.insertCard(new Liscio(BriscolaSeed.values()[i], BriscolaRank.SEI));
            tableDeck.insertCard(new Liscio(BriscolaSeed.values()[i], BriscolaRank.SETTE));
        }
        tableDeck.randomizeDeck();
    }

    private void initPlayerDecks() {
        this.playerDecks = new ArrayList<>();
        playerDecks.add(PlayerDeck.empty());
        playerDecks.add(PlayerDeck.empty());
    }

    private void initPlayersCard() {
        for (int i = 0; i < 2; i++) {
            takeFirstCards(3);
            opponentPlayer();
        }
        opponentPlayer();
    }

    public void play() {
        boolean status = true;
        initPlayersCard();

        do {
            for (int i = 0; i < 2; i++) {
                status = doAction();
                if (!status)
                    break;
            }
            rule();
        } while (status);

        System.out.println("Ho finito");
        System.out.println("Punteggio player1: " + players.get(0).getScore());
        System.out.println("Punteggio player2: " + players.get(1).getScore());
        System.out.println("Totale: " + (players.get(1).getScore() + players.get(0).getScore()));
    }

    private boolean doAction() {
        int numCardToPlay = 0;
        playCard(numCardToPlay);
        takeCard();
        opponentPlayer();

        return playerDecks.get(currentPlayer).getSize() != 0;
    }

    private void takeFirstCards(Integer num) {
        if (playerDecks.get(currentPlayer).getSize() == 0) {
            for (int i = 0; i < num; i++) {
                takeCard();
            }
        }
    }

    private void playCard(Integer pos) {
        Card toPlay = playerDecks.get(currentPlayer).removeCard(pos);
        tableDeck.playCard(currentPlayer, toPlay);
    }

    private void rule() {
        Card player1ThrowedCard = tableDeck.getPlayer1ThrowingCard();
        Card player2ThrowedCard = tableDeck.getPlayer2ThrowingCard();
        int scoreCard1 = player1ThrowedCard.getScore();
        int scoreCard2 = player2ThrowedCard.getScore();
        if (player1ThrowedCard.getScore() > player2ThrowedCard.getScore()) {
            players.get(0).setScore(scoreCard1 + scoreCard2);
        } else {
            players.get(1).setScore(scoreCard1 + scoreCard2);
        }
        tableDeck.initThrowingCards();
    }

    private void opponentPlayer() {
        this.currentPlayer = (currentPlayer + 1) % 2;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }
}
