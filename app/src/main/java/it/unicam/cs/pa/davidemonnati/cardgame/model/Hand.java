package it.unicam.cs.pa.davidemonnati.cardgame.model;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.Deck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.player.Player;

import java.util.List;

/**
 * Rappresenta la mano di un giocatore.
 */
public interface Hand extends Deck {
    /**
     * Permette di giocare una carta a scelta che si ha nella mano, passando la posizione come parametro.
     * Quando viene giocata una carta, quest'ultima viene eliminata dalla mano.
     *
     * @param pos posizione della carta che si vuole giocare
     * @return valore che rappresenta la carta di posizione <i>pos</i> che si vuole ritornare
     */
    Card playCard(int pos);

    /**
     * Ritorna tutta la lista delle carte nella mano del {@link Player}
     *
     * @return lista di carte che appartengono alla mano
     * @see Card
     */
    List<Card> getCards();
}
