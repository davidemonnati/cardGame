package it.unicam.cs.pa.davidemonnati.cardgame.model.deck;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;

import java.util.Collections;
import java.util.Stack;

/**
 * Rappresenta il mazzo di carte che si trova nel tavolo da cui i giocatori pescano le carte.
 */
public class DefaultTableDeck implements TableDeck {
    private final Stack<Card> cards;

    private DefaultTableDeck(Stack<Card> cards) {
        this.cards = cards;
    }

    public static DefaultTableDeck empty() {
        return new DefaultTableDeck(new Stack<>());
    }

    /**
     * Permette di inserire una carta all'interno del mazzo.
     *
     * @param card carta che vogliamo inserire all'interno del mazzo
     */
    @Override
    public void insert(Card card) {
        cards.push(card);
    }

    /**
     * Permette di rimuovere una carta dal mazzo, ovvero quando un giocatore deve prendere una carta quest'ultima
     * viene eliminata dal mazzo.
     * Visto che utilizzo la struttura LIFO, per eliminare la carta utilizzo direttamente il metodo <i>pop</i> della
     * classe Stack di Java.
     *
     * @return carta che pè stata tolta dal mazzo per essere spostata nella mano del giocatore.
     * @see Stack
     */
    @Override
    public Card removeCard() {
        return cards.pop();
    }

    /**
     * Ritorna una carta dal mazzo senza eliminarla.
     *
     * @param pos posizione della carta che si vuole ottenere
     * @return carta di posizione <i>pos</i>
     */
    @Override
    public Card getCard(int pos) {
        return cards.get(pos);
    }

    /**
     * Serve per randomizzare le carte che ci sono all'interno del mazzo, ovvero per mescolarle.
     * Ho utilizzato il metodo <i>shuffle</i> che troviamo nella classe Collection di Java
     *
     * @see Collections
     */
    @Override
    public void randomizeDeck() {
        Collections.shuffle(cards);
    }

    /**
     * @return numero di carte presenti all'interno del mazzo
     */
    @Override
    public int getSize() {
        return cards.size();
    }

    /**
     * @param card indica la carta che dobbiamo cercare all'interno del mazzo
     * @return posizione della carta che vogliamo cercare nel mazzo
     */
    @Override
    public int search(Card card) {
        return cards.search(card);
    }
}
