package it.unicam.cs.pa.davidemonnati.cardgame.model;

import java.util.Stack;

public class PlayerDeck {
    protected Stack<Card> cards = new Stack<>();

    protected PlayerDeck(Stack<Card> cards) {
        this.cards = cards;
    }

    public static PlayerDeck empty() {
        return new PlayerDeck(new Stack());
    }

    public void insertCard(Card card) {
        cards.push(card);
    }

    protected Card popCard() {
        return cards.pop();
    }

    public Card removeCard(int i) {
        return cards.remove(i);
    }

    public int getSize() {
        return cards.size();
    }

    public Stack<Card> getCards() {
        return cards;
    }
}
