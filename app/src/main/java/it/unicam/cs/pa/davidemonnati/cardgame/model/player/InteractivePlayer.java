package it.unicam.cs.pa.davidemonnati.cardgame.model.player;

/**
 * Rappresenta un {@link Player} di tipo <i>Interactive</i>, ovvero un giocatore reale.<br />
 * Un {@link Player} di tipo interactive ha esattamente gli stessi metodi della classe astratta {@link Player},
 * per questo motivo mi sono limitato di inserire un costruttore in modo da poter creare l'istanza.
 */
public class InteractivePlayer extends Player {
    public InteractivePlayer(Integer id, String name) {
        super(id, name);
    }
}
