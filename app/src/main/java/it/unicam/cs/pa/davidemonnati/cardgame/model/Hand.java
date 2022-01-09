package it.unicam.cs.pa.davidemonnati.cardgame.model;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.Deck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.player.Player;

import java.util.List;

/**
 * Rappresenta la mano di un giocatore. <br />
 * Posso considerare la mano come se fosse un mazzo, quindi ho esteso l'interfaccia {@link Deck}.
 */
public interface Hand extends Deck {
    /**
     * Permette al {@link Player} di giocare una carta a scelta di posizione <i>pos</i> che ha nella mano,
     * passando la posizione come parametro. <br />
     * La carta giocata verrà eliminata dalla mano.
     *
     * @param pos posizione della carta che si vuole giocare
     * @return valore che rappresenta la carta di posizione <i>pos</i> che si vuole ritornare
     */
    Card playCard(int pos);

    /**
     * Ritorna tutta la lista delle carte nella mano del {@link Player}
     *
     * @return lista di carte che appartengono alla mano
     */
    List<Card> getCards();
}
