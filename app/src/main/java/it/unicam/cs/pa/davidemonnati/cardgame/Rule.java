package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.Player;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.Table;

import java.util.function.BiFunction;

/**
 * Interfaccia che serve a definire la regola di un gioco di carte.
 */
@FunctionalInterface
public interface Rule {
    /**
     * Ogni volta che si applica la regola, verrà restituito il nuovo stato dei giocatori, con
     * i punteggi aggiornati.
     *
     * @return nuovo stato dei giocatori
     * @see Player
     */
    BiFunction<? extends Table, GameTurn, GameTurn> rule();
}
