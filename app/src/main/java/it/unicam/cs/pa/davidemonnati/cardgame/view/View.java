package it.unicam.cs.pa.davidemonnati.cardgame.view;

import it.unicam.cs.pa.davidemonnati.cardgame.model.Hand;
import it.unicam.cs.pa.davidemonnati.cardgame.model.player.Player;

import java.io.IOException;
import java.util.List;

/**
 * Rappresenta l'interfaccia con cui l'utente andrà ad utilizzare l'applicazione.
 */
public interface View {
    /**
     * Metodo che serve per avviare la view
     */
    void open();

    /**
     * Aggiorna lo stato della view chiedendo ogni volta al {@link Player} quale carta vuole giocare.
     *
     * @param hand   la mano del giocatore per mostrare quali carte ha
     * @param player per mostrare username e punteggio
     * @return valore intero che rappresenta la carta che si vuole giocare, nella mano
     * @throws IOException           Eccezione che viene lanciata quando ci sono errori durante l'inserimento di dati da tastiera
     * @throws NumberFormatException Eccezione che viene lanciata quando ci sono errori durante la conversione del dato
     *                               in input
     * @see Hand
     */
    int updateState(Hand hand, Player player) throws IOException, NumberFormatException;

    /**
     * Mostra lo stato finale della view, ovvero quando è terminata la partita.
     *
     * @param players per visualizzare lo stato finale di tutti i giocatori
     */
    void close(List<Player> players, Integer winnerID);
}
