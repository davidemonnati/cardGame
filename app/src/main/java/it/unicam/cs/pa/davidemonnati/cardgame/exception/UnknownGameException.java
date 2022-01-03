package it.unicam.cs.pa.davidemonnati.cardgame.exception;

/**
 * Eccezione che viene lanciata quando si prova a creare un Game che non esiste nell'enum.
 */
public class UnknownGameException extends IllegalArgumentException {
    public UnknownGameException() {
        super("ERRORE: Il gioco che hai selezionato non esiste");
    }
}
