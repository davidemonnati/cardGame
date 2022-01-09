package it.unicam.cs.pa.davidemonnati.cardgame.model;

/**
 * Classe che rappresenta lo stato attuale del gioco.
 */
public class Status {
    /**
     * Classe singleton.
     */
    private static Status instance = null;
    /**
     * La variabile <i>status</i> assume <b>true</b> quando la partita è in corso,
     * <b>false</b> quando è terminata.
     */
    private boolean status;

    /**
     * L'oggetto <i>status</i> viene inizializzato quando viene istanziato il controller <i>Game</i> quindi quando
     * inizia la partita, per questo motivo di default assume il valore <b>true</b>.
     */
    private Status() {
        this.status = true;
    }

    /**
     * Crea l'istanza della classe se questa è uguale a <i>null</i>, ritorna l'istanza esistete altrimenti.
     *
     * @return istanza della classe
     */
    public static Status getInstance() {
        if (instance == null) {
            instance = new Status();
        }
        return instance;
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
