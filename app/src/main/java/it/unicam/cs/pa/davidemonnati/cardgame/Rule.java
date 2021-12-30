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
     * Ogni volta che si applica la regola verrà restituito il nuovo stato dell'istanza di {@link GameTurn}
     *
     * @return nuovo stato dell'istanza {@link GameTurn}
     * @see Table
     * @see GameTurn
     * @see Player
     */
    BiFunction<? extends Table, GameTurn, GameTurn> rule();
}
