package it.unicam.cs.pa.davidemonnati.cardgame.exception;

/**
 * Eccezione che viene lanciata quando il formato dell'username non è corretto.
 */
public class BadUsernameFormatException extends Exception {
    public BadUsernameFormatException() {
        super("ERRORE: l'username può contenere al massimo 15 caratteri.");
    }
}
