package it.unicam.cs.pa.davidemonnati.cardgame.model.deck;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;

/**
 * Interfaccia che contiene metodi per la gestione di un <i>Deck</i>> base.
 */
public interface TableDeck extends DeckOperations {
    /**
     * Permette di inserire carte all'interno del mazzo
     * @param card carta che vogliamo inserire all'interno del mazzo
     * @see Card
     */
    void insert(Card card);

    /**
     * Permette di prendere una carta dal mazzo.<br>
     * Nel momento in cui la carta viene presa, per essere spostata in altri mazzi
     * verrà eliminata dal <i>Deck</i>
     * @return La carta che vogliamo togliere dal mazzo
     * @see Card
     */
    Card removeCard();

    /**
     * Mescola le carte che ci sono all'interno del mazzo.
     */
    void randomizeDeck();
}