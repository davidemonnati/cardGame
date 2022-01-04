package it.unicam.cs.pa.davidemonnati.cardgame.controller.rule;

import it.unicam.cs.pa.davidemonnati.cardgame.controller.Turn;
import it.unicam.cs.pa.davidemonnati.cardgame.model.player.Player;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.Table;

import java.util.function.BiConsumer;

/**
 * Interfaccia che serve a definire la regola di un gioco di carte.
 */
@FunctionalInterface
public interface Rule {
    /**
     * Ogni volta che si applica la regola verrà restituito il nuovo stato dell'istanza di {@link Turn}
     *
     * @return BiConsumer che accetta in input un {@link Table} e un {@link Turn} per eseguire la regola di gioco
     * sulle carte che sono state giocate.
     * @see Table
     * @see Turn
     * @see Player
     */
    BiConsumer<? extends Table, Turn> rule();
}
