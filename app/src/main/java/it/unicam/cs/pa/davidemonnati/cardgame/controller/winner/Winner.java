package it.unicam.cs.pa.davidemonnati.cardgame.controller.winner;

import it.unicam.cs.pa.davidemonnati.cardgame.model.player.Player;

import java.util.List;
import java.util.function.Function;

/**
 * Permette di stabilire quale è il vincitore della partita.
 */
@FunctionalInterface
public interface Winner {
    /**
     * @return Function che riceve come parametro la lista dei giocatori che hanno partecipato alla partita
     * e restituisce un valore di tipo <i>Integer</i> che rappresenta l'ID del vincitore.
     */
    Function<List<Player>, Integer> check();
}
