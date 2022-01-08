package it.unicam.cs.pa.davidemonnati.cardgame.model.deck;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;

/**
 * Interfaccia che contiene metodi per la gestione di un <i>Deck</i>> base.
 */
public interface TableDeck extends Deck {
    /**
     * Permette di prendere una carta dal mazzo.<br>
     * Nel momento in cui la carta viene presa, per essere spostata in altri mazzi
     * verrà eliminata dal <i>Deck</i>
     * @return La carta che vogliamo togliere dal mazzo
     * @see Card
     */
    Card removeCard();

    /**
     * Ritorna una Carta di posizione <i>pos</i> senza eliminarla dal mazzo
     * @param pos posizione della carta che si vuole ottenere
     * @return ritorna la carta
     * @see Card
     */
    Card getCard(int pos);

    /**
     * Mescola le carte che ci sono all'interno del mazzo.
     */
    void randomizeDeck();
}
