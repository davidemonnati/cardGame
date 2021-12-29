package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.exception.IllegalCardPositionException;
import it.unicam.cs.pa.davidemonnati.cardgame.model.DefaultHand;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Hand;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Player;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che si occupa di gestire i turni del gioco.
 * All'interno della classe troviamo la variabile intera <i>currentPlayer</i> che stabilisce a quale giocatore
 * appartiene il turno corrente.
 * Tutte le operazioni che vengono effettuate si riferiscono al player che sta giocando la partita.
 */
public class GameTurn {
    /**
     * Lista giocatori.
     */
    private final List<Player> players;
    /**
     * Lista con le mani dei giocatori.
     */
    private List<Hand> hands;
    /**
     * ID del player a cui appartiene il turno di gioco.
     */
    private int currentPlayer;

    public GameTurn(List<Player> players) {
        this.players = players;
        initHands();
        this.currentPlayer = 0;
    }

    /**
     * Inizializza le mani dei giocatori.
     */
    private void initHands() {
        this.hands = new ArrayList<>();
        hands.add(new DefaultHand());
        hands.add(new DefaultHand());
    }

    /**
     * Ad ogni turno, serve al giocatore identificato con <i>currentPlayer</i> di prendere una carta in mano.
     *
     * @param card carta che il giocatore prende in mano
     */
    public void takeCard(Card card) {
        hands.get(currentPlayer).takeCard(card);
    }

    /**
     * Consente al giocatore di giocare una carta dalla propria mano.
     *
     * @param pos posizione della carta che il giocatore vuole giocare
     * @return ritorna la carta corrispondente a <i>pos</i> nella mano di <i>currentPlayer</i>
     * @throws IllegalCardPositionException se la posizione della carta non è corretta
     */
    public Card playCard(Integer pos) throws IllegalCardPositionException {
        if ((pos > (hands.get(currentPlayer).getSize() - 1)) || (pos < 0))
            throw new IllegalCardPositionException();
        return hands.get(currentPlayer).playCard(pos);
    }

    /**
     * @return id del player corrente.
     */
    public int getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Consente di cambiare turno impostando l'id del giocatore
     *
     * @param playerID id giocatore
     */
    public void setTurn(int playerID) {
        this.currentPlayer = playerID;
    }

    /**
     * Imposta la variabile <i>currentPlayer</i> con l'id del giocatore opposto.
     */
    public void opponentPlayer() {
        this.currentPlayer = (currentPlayer + 1) % 2;
    }

    /**
     * @return lista giocatori
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * @return giocatore che corrisponde alla posizione <i>currentPlayer</i> nella lista <i>players</i>
     */
    public Player getPlayer() {
        return players.get(currentPlayer);
    }

    /**
     * @return la mano che corrisponde al giocatore corrente
     */
    public Hand getHand() {
        return hands.get(currentPlayer);
    }

    /**
     * @return numero di carte che ha <i>currentPlayer</i> nella propria mano.
     */
    public int getHandSize() {
        return hands.get(currentPlayer).getSize();
    }

    /**
     * Imposta il punteggio ad un giocatore.
     *
     * @param playerID id del player che sta giocando la partita
     * @param score    punteggio che si deve incrementare al giocatore
     */
    public void setScore(int playerID, int score) {
        players.get(playerID).setScore(score);
    }
}