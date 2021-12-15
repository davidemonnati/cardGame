package it.unicam.cs.pa.davidemonnati.cardgame.model;

import java.util.Stack;

public class PlayerDeck {
    protected Stack<Card> cards;

    protected PlayerDeck(Stack<Card> cards) {
        this.cards = cards;
    }

    public static PlayerDeck empty() {
        return new PlayerDeck(new Stack<>());
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

    public Card getCard(int pos) {
        return cards.get(pos);
    }

    public int searchCard(Card card) {
        return cards.search(card);
    }

    /*public Stack<Card> getCards() {
        return cards;
    }*/
}
