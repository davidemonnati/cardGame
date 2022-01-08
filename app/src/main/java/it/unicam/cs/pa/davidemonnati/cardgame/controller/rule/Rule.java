package it.unicam.cs.pa.davidemonnati.cardgame.controller.rule;

import it.unicam.cs.pa.davidemonnati.cardgame.controller.Turn;
import it.unicam.cs.pa.davidemonnati.cardgame.model.player.Player;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.Table;

import java.util.function.BiConsumer;

/**
 * Interfaccia che ha il compito di rappresentare la regola di un gioco da carte e le sue proprietà
 * @param <T> oggetto che estende la classe {@link Table}
 */
public interface Rule <T extends Table> {
    /**
     * @return numero delle carte che ogni giocatore deve avere all'inizio della partita.
     */
    int getCards();

    /**
     * Ad ogni turno la regola permette di stabilire quale giocatore deve prendere le carte, chi si aggiudica la mano
     * e quindi chi riceve il punteggio.
     * Infine verrà modificato currentPlayer dentro {@link Turn} in modo da stabilire a chi apparterrà
     * il turno durante la prossima mossa.
     *
     * @return BiConsumer che accetta in input un parametro di tipo <i>T</i> e un {@link Turn} per eseguire
     * la regola di gioco sulle carte che sono state giocate.
     * @see Table
     * @see Turn
     * @see Player
     */
    BiConsumer<T, Turn> rule();
}
