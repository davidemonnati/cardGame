package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.*;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola.BriscolaRank;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola.BriscolaSeed;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola.*;
import it.unicam.cs.pa.davidemonnati.cardgame.model.DefaultHand;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.DefaultTableDeck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.TableDeck;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final Status status;
    private final List<Player> players;
    private Table table;
    private List<Hand> hands;
    private int currentPlayer;

    public GameController(List<Player> players) {
        this.status = new Status();
        this.players = players;
        initTableDeck();
        initHands();
        this.currentPlayer = 0;
    }

    private void takeCard() {
        if (table.tableDeckSize() > 0) {
            Card toTake = table.takeCardFromDeck();
            hands.get(currentPlayer).takeCard(toTake);
        }
    }

    private void initTableDeck() {
        TableDeck tableDeck = DefaultTableDeck.empty();
        for (int i = 0; i < 4; i++) {
            tableDeck.insert(new Asso(BriscolaSeed.values()[i]));
            tableDeck.insert(new Tre(BriscolaSeed.values()[i]));
            tableDeck.insert(new Fante(BriscolaSeed.values()[i]));
            tableDeck.insert(new Cavallo(BriscolaSeed.values()[i]));
            tableDeck.insert(new Re(BriscolaSeed.values()[i]));

            tableDeck.insert(new Liscio(BriscolaSeed.values()[i], BriscolaRank.DUE));
            tableDeck.insert(new Liscio(BriscolaSeed.values()[i], BriscolaRank.QUATTRO));
            tableDeck.insert(new Liscio(BriscolaSeed.values()[i], BriscolaRank.CINQUE));
            tableDeck.insert(new Liscio(BriscolaSeed.values()[i], BriscolaRank.SEI));
            tableDeck.insert(new Liscio(BriscolaSeed.values()[i], BriscolaRank.SETTE));
        }
        tableDeck.randomizeDeck();
        this.table = new DefaultTable(tableDeck);
    }

    private void initHands() {
        this.hands = new ArrayList<>();
        hands.add(new DefaultHand());
        hands.add(new DefaultHand());
    }

    private void initPlayersCard() {
        for (int i = 0; i < 2; i++) {
            takeFirstCards(3);
            opponentPlayer();
        }
        opponentPlayer();
    }

    public void play() {
        initPlayersCard();

        do {
            for (int i = 0; i < 2; i++) {
                if (!doAction())
                    status.changeStatus();

                if (!status.isStatus())
                    break;
            }
            rule();
        } while (status.isStatus());
    }

    private boolean doAction() {
        int numCardToPlay = 0;
        playCard(numCardToPlay);
        takeCard();
        opponentPlayer();

        return hands.get(currentPlayer).getSize() != 0;
    }

    private void takeFirstCards(Integer num) {
        if (hands.get(currentPlayer).getSize() == 0) {
            for (int i = 0; i < num; i++) {
                takeCard();
            }
        }
    }

    private void playCard(Integer pos) {
        Card toPlay = hands.get(currentPlayer).playCard(pos);
        table.playCard(currentPlayer, toPlay);
    }

    private void rule() {
        Card player1ThrowedCard = table.getPlayedCards()[0];
        Card player2ThrowedCard = table.getPlayedCards()[1];
        int scoreCard1 = player1ThrowedCard.getScore();
        int scoreCard2 = player2ThrowedCard.getScore();
        if (player1ThrowedCard.getScore() > player2ThrowedCard.getScore()) {
            players.get(0).setScore(scoreCard1 + scoreCard2);
            table.insertIntoPlayerDeck(0);
        } else {
            players.get(1).setScore(scoreCard1 + scoreCard2);
            table.insertIntoPlayerDeck(1);
        }
    }

    private void opponentPlayer() {
        this.currentPlayer = (currentPlayer + 1) % 2;
    }
}
