package it.unicam.cs.pa.davidemonnati.cardgame;

/**
 * Eccezione che viene lanciata quando viene selezionata una carta che non è presente nella mano.
 */
public class IllegalCardPositionException extends Exception {
    /**
     * Messaggio di errore mostrato.
     */
    public IllegalCardPositionException() {
        super("ERRORE: La carta che hai selezionato non è presente nella mano\n" +
                "Premi invio per continuare");
    }
}
