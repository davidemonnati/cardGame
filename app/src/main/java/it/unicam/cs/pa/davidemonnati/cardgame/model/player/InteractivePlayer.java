package it.unicam.cs.pa.davidemonnati.cardgame.model.player;

/**
 * Rappresenta un {@link Player} di tipo <i>Interactive</i>, ovvero un giocatore reale.
 * Questa classe dipende dalla classe astratta {@link Player}
 */
public class InteractivePlayer extends Player {
    public InteractivePlayer(Integer id, String name) {
        super(id, name);
    }
}
