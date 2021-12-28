package it.unicam.cs.pa.davidemonnati.cardgame.model.deck;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;

import java.util.Collections;
import java.util.Stack;

public class DefaultTableDeck implements TableDeck {
    private final Stack<Card> cards;

    private DefaultTableDeck(Stack<Card> cards) {
        this.cards = cards;
    }

    public static DefaultTableDeck empty() {
        return new DefaultTableDeck(new Stack<>());
    }

    @Override
    public void insert(Card card) {
        cards.push(card);
    }

    @Override
    public Card removeCard() {
        return cards.pop();
    }

    @Override
    public Card getCard(int pos) {
        return cards.get(pos);
    }

    @Override
    public void randomizeDeck() {
        Collections.shuffle(cards);
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
