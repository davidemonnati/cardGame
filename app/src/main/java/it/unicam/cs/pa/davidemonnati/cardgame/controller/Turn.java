package it.unicam.cs.pa.davidemonnati.cardgame.controller;

import it.unicam.cs.pa.davidemonnati.cardgame.controller.winner.DefaultWinner;
import it.unicam.cs.pa.davidemonnati.cardgame.controller.winner.Winner;
import it.unicam.cs.pa.davidemonnati.cardgame.exception.IllegalCardPositionException;
import it.unicam.cs.pa.davidemonnati.cardgame.model.DefaultHand;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Hand;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che si occupa di gestire i turni del gioco.
 * All'interno della classe troviamo la variabile intera <i>currentPlayer</i> che stabilisce a quale giocatore
 * appartiene il turno corrente.
 * Tutte le operazioni che vengono effettuate si riferiscono al player che sta giocando la partita.
 */
public class Turn {
    private static Turn instance = null;
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

    private Turn(List<Player> players) {
        this.players = players;
        initHands();
        this.currentPlayer = 0;
    }

    public static Turn getInstance(List<Player> players) {
        if (instance == null) {
            instance = new Turn(players);
        }
        return instance;
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
    public void setOpponentPlayer() {
        this.currentPlayer = opponentPlayer();
    }

    /**
     * @return ritorna il {@link Player} opposto senza modificare <i>currentPlayer</i>
     */
    public int getOpponentPlayer() {
        return opponentPlayer();
    }

    /**
     * @return id {@link Player} opposto
     */
    private int opponentPlayer() {
        return (this.currentPlayer + 1) % 2;
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

    /**
     * Metodo che serve a definire quale giocatore ha vinto la partita e ritorna il suo ID.
     *
     * @return l'id del giocatore che ha vinto la partita.
     */
    public Integer winner() {
        Winner winner = new DefaultWinner();
        return winner.check().apply(players);
    }
}
