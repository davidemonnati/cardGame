package it.unicam.cs.pa.davidemonnati.cardgame.model.deck;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;

import java.util.Stack;

public class DefaultPlayerDeck implements PlayerDeck {
    Stack<Card> cards;

    public DefaultPlayerDeck() {
        this.cards = new Stack<>();
    }

    @Override
    public void insert(Card card) {
        this.cards.push(card);
    }

    @Override
    public int getSize() {
        return cards.size();
    }

    @Override
    public int search(Card card) {
        return cards.search(card);
    }
}
