package it.unicam.cs.pa.davidemonnati.cardgame.model.deck;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;

/**
 * Contiene i metodi base per la gestione di un <i>Deck</i>
 */
public interface Deck {
    /**
     * Permette di inserire carte nel mazzo.
     *
     * @param card carta che vogliamo inserire
     * @see Card
     */
    void insert(Card card);

    /**
     * Ritorna il numero di carte che sono presenti all'interno del mazzo.
     *
     * @return valore intero che indica quante carte ci sono nel mazzo
     */
    int getSize();

    /**
     * Permette di ricercare una carta all'interno del mazzo.<br />
     * Il metodo ritorna la posizione in cui si trova la carta che stiamo cercando e -1 se la carta non esiste.
     *
     * @param card indica la carta che dobbiamo cercare all'interno del mazzo
     * @return il valore che rappresenta la posizione della carta
     */
    int search(Card card);
}
