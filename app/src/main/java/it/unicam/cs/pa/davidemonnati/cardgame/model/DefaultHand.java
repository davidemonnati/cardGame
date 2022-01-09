package it.unicam.cs.pa.davidemonnati.cardgame.model;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementazione dell'interfaccia {@link Hand}.
 */
public class DefaultHand implements Hand {
    private final List<Card> cards;

    public DefaultHand() {
        this.cards = new ArrayList<>();
    }

    @Override
    public void insert(Card card) {
        cards.add(card);
    }

    @Override
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Gioca una carta di posizione <i>pos</i> dalla mano del giocatore, quindi il metodo ritorna ed elimina la
     * {@link Card} che deciso di giocare. <br />
     *
     * @param pos posizione della carta che si vuole giocare
     * @return carta scelta dal giocatore
     */
    @Override
    public Card playCard(int pos) {
        Card toReturn = cards.get(pos);
        cards.remove(pos);
        return toReturn;
    }

    /**
     * @return numero di {@link Card} che ci sono nella mano
     */
    @Override
    public int getSize() {
        return cards.size();
    }

    @Override
    public int search(Card card) {
        return cards.indexOf(card);
    }
}
