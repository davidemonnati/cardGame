package it.unicam.cs.pa.davidemonnati.cardgame.exception;

/**
 * Eccezione che viene lanciata quando si prova a creare un Player che non esiste nell'Enum PlayerType
 * @see it.unicam.cs.pa.davidemonnati.cardgame.model.player.PlayerType
 */
public class UnknownPlayerTypeException extends IllegalArgumentException {
    public UnknownPlayerTypeException() {
        super("Il player che hai cercato di creare non esiste.");
    }
}
