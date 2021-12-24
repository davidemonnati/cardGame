package it.unicam.cs.pa.davidemonnati.cardgame.view;

import it.unicam.cs.pa.davidemonnati.cardgame.model.Hand;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Player;

import java.io.IOException;
import java.util.List;

/**
 * Rappresenta l'interfaccia con cui l'utente andrà ad utilizzare l'applicazione.
 */
public interface View {
    /**
     * Metodo che serve per avviare la view
     *
     * @throws IOException lancia l'eccezione quando ci sono errori di I/O
     */
    void open() throws IOException;

    /**
     * Aggiorna lo stato della view chiedendo ogni volta al {@link Player} quale carta vuole giocare.
     *
     * @param hand   la mano del giocatore per mostrare quali carte ha
     * @param player per mostrare username e punteggio
     * @return valore intero che rappresenta la carta che si vuole giocare, nella mano
     * @throws IOException lancia l'eccezione quando ci sono errori di I/O
     * @see Hand
     */
    int updateState(Hand hand, Player player) throws IOException;

    /**
     * Mostra lo stato finale della view, ovvero quando è terminata la partita.
     *
     * @param players per visualizzare lo stato finale di tutti i giocatori
     */
    void close(List<Player> players);
}
