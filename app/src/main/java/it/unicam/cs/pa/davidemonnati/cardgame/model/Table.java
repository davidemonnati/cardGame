package it.unicam.cs.pa.davidemonnati.cardgame.model;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.DefaultPlayerDeck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.PlayerDeck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.TableDeck;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private final TableDeck tableDeck;
    private final Card[] playedCards;
    private List<PlayerDeck> playerDecks;

    public Table(TableDeck tableDeck) {
        this.tableDeck = tableDeck;
        this.playedCards = new Card[2];
        initPlayerDeck();
    }

    private void initPlayerDeck() {
        this.playerDecks = new ArrayList<>();
        this.playerDecks.add(new DefaultPlayerDeck());
        this.playerDecks.add(new DefaultPlayerDeck());
    }

    public int tableDeckSize() {
        return tableDeck.getSize();
    }

    public Card takeCardFromDeck() {
        return tableDeck.removeCard();
    }

    public void playCard(int currentPlayer, Card card) {
        playedCards[currentPlayer] = card;
    }

    public Card[] getThrowingCards() {
        return playedCards;
    }

    public void insertIntoPlayerDeck(int currentPlayer) {
        playerDecks.get(currentPlayer).insert(playedCards[0]);
        playerDecks.get(currentPlayer).insert(playedCards[1]);
    }

    public PlayerDeck getPlayerDeck(int playerId) {
        return playerDecks.get(playerId);
    }
}
