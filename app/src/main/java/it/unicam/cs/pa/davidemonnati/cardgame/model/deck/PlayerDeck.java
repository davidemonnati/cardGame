package it.unicam.cs.pa.davidemonnati.cardgame.model.deck;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;

public interface PlayerDeck extends DeckOperations {
    /**
     * Permette di inserire carte all'interno del mazzo
     *
     * @param card carta che vogliamo inserire all'interno del mazzo
     * @see Card
     */
    void insert(Card card);
}
