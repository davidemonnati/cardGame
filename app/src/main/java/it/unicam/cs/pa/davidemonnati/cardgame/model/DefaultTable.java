package it.unicam.cs.pa.davidemonnati.cardgame.model;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.DefaultPlayerDeck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.PlayerDeck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.TableDeck;

import java.util.ArrayList;
import java.util.List;

public class DefaultTable implements Table {
    private final TableDeck tableDeck;
    private Card[] playedCards;
    private List<PlayerDeck> playerDecks;

    public DefaultTable(TableDeck tableDeck) {
        this.tableDeck = tableDeck;
        resetPlayedCards();
        initPlayerDeck();
    }

    private void initPlayerDeck() {
        this.playerDecks = new ArrayList<>();
        this.playerDecks.add(new DefaultPlayerDeck());
        this.playerDecks.add(new DefaultPlayerDeck());
    }

    @Override
    public int tableDeckSize() {
        return tableDeck.getSize();
    }

    @Override
    public Card takeCardFromDeck() {
        return tableDeck.removeCard();
    }

    @Override
    public void playCard(int currentPlayer, Card card) {
        playedCards[currentPlayer] = card;
    }

    @Override
    public Card[] getPlayedCards() {
        return playedCards;
    }

    @Override
    public void insertIntoPlayerDeck(int currentPlayer) {
        playerDecks.get(currentPlayer).insert(playedCards[0]);
        playerDecks.get(currentPlayer).insert(playedCards[1]);
    }

    @Override
    public PlayerDeck getPlayerDeck(int playerId) {
        return playerDecks.get(playerId);
    }

    @Override
    public void resetPlayedCards() {
        this.playedCards = new Card[2];
    }
}
