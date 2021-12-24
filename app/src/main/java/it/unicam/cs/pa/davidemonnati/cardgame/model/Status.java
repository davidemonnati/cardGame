package it.unicam.cs.pa.davidemonnati.cardgame.model;

/**
 * Classe che rappresenta lo stato attuale del gioco
 */
public class Status {
    /**
     * La variabile <i>status</i> assume <b>true</b> quando la partita è in corso,
     * <b>false</b> quando è terminata.
     */
    private boolean status;

    /**
     * L'oggetto <i>status</i> viene inizializzato quando viene istanziato il controller <i>Game</i>,
     * per questo motivo di default assume come valore: <b>true</b>.
     */
    public Status() {
        this.status = true;
    }

    /**
     * @return stato attuale
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * Cambia lo stato attuale
     */
    public void changeStatus() {
        this.status = !status;
    }
}
