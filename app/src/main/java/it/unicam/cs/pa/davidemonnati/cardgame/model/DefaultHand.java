package it.unicam.cs.pa.davidemonnati.cardgame.model;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;

import java.util.ArrayList;
import java.util.List;

public class DefaultHand implements Hand {
    private final List<Card> cards;

    public DefaultHand() {
        this.cards = new ArrayList<>();
    }

    @Override
    public void takeCard(Card card) {
        cards.add(card);
    }

    @Override
    public Card playCard(int pos) {
        Card toReturn = cards.get(pos);
        cards.remove(pos);
        return toReturn;
    }

    @Override
    public int getSize() {
        return cards.size();
    }

    @Override
    public int search(Card card) {
        return cards.indexOf(card);
    }
}
