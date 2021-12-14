package it.unicam.cs.pa.davidemonnati.cardgame.model;

import java.util.Collections;
import java.util.Stack;

public class BriscolaDeck extends PlayerDeck {
    private Card asso;
    private Card[] throwingCards;

    private BriscolaDeck(Stack<Card> cards) { //tavolo
        super(cards);
        initThrowingCards();
    }

    public static BriscolaDeck empty() {
        return new BriscolaDeck(new Stack<>());
    }

    public void setAsso() {
        this.asso = popCard();
    }

    public Card getAsso() {
        return asso;
    }

    public Card removeCard() {
        return popCard();
    }

    public Card getPlayer1ThrowingCard() {
        return throwingCards[0];
    }

    public Card getPlayer2ThrowingCard() {
        return throwingCards[1];
    }

    public void initThrowingCards() {
        throwingCards = new Card[2];
    }

    public void playCard(int i, Card card) {
        throwingCards[i] = card;
    }

    public Card[] getThrowingCards() {
        return throwingCards;
    }

    public void randomizeDeck() {
        Collections.shuffle(cards);
    }
}
