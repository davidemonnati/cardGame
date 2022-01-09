package it.unicam.cs.pa.davidemonnati.cardgame.model.deck;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;

import java.util.Stack;

/**
 * Rappresenta le carte che il giocatore ha preso in seguito ad una vincita.
 */
public class DefaultPlayerDeck implements PlayerDeck {
    Stack<Card> cards;

    public DefaultPlayerDeck() {
        this.cards = new Stack<>();
    }

    /**
     * @param card carta che vogliamo inserire dentro al mazzo
     */
    @Override
    public void insert(Card card) {
        this.cards.push(card);
    }

    /**
     * @return numero di carte che ci sono all'interno del mazzo
     */
    @Override
    public int getSize() {
        return cards.size();
    }

    /**
     * Serve a ricercare una carta dentro al mazzo, il metodo deve ritornare la posizione se la carta è presente,
     * ritorna come valore -1 altrimenti.<br />
     * Ho implementato la ricerca utilizzando il metodo <i>search()</i> della classe {@link Stack} di java.
     *
     * @param card indica la carta che dobbiamo cercare all'interno del mazzo
     * @return posizione della carta che vogliamo cercare nel mazzo
     * @see Stack
     */
    @Override
    public int search(Card card) {
        return cards.search(card);
    }
}
