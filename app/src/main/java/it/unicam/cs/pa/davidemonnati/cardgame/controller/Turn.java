package it.unicam.cs.pa.davidemonnati.cardgame.controller;

import it.unicam.cs.pa.davidemonnati.cardgame.controller.winner.Winner;
import it.unicam.cs.pa.davidemonnati.cardgame.exception.IllegalCardPositionException;
import it.unicam.cs.pa.davidemonnati.cardgame.model.DefaultHand;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Hand;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che si occupa di gestire i turni del gioco. <br />
 * All'interno della classe troviamo la variabile intera <i>currentPlayer</i> che stabilisce a quale giocatore
 * appartiene il turno attuale.
 */
public class Turn {
    /**
     * Classe singleton.
     */
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

    /**
     * Regola che serve a stabilire il vincitore della partita
     */
    private final Winner winner;

    private Turn(List<Player> players, Winner winner) {
        this.players = players;
        initHands();
        this.currentPlayer = 0;
        this.winner = winner;
    }

    /**
     * Ritorna l'istanza della classe o la crea se è uguale a <i>null</i>.
     *
     * @param players lista dei giocatori
     * @param winner  regola per stabilire che è il vincitore
     * @return istanza della classe
     */
    public static Turn getInstance(List<Player> players, Winner winner) {
        if (instance == null) {
            instance = new Turn(players, winner);
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
     * Serve al giocatore identificato con <i>currentPlayer</i> di prendere una carta in mano.
     *
     * @param card carta che il giocatore prende in mano
     */
    public void takeCard(Card card) {
        hands.get(currentPlayer).insert(card);
    }

    /**
     * Consente al {@link Player} di giocare una carta dalla propria mano.
     *
     * @param pos posizione della carta che il giocatore vuole giocare
     * @return ritorna la carta di posizione<i>pos</i> nella mano di <i>currentPlayer</i>
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
     * Consente di cambiare turno impostando l'id di un altro giocatore
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
     * Setta il punteggio ad un giocatore.
     *
     * @param playerID id del player che sta giocando la partita
     * @param score    punteggio che si deve incrementare al giocatore
     */
    public void setScore(int playerID, int score) {
        players.get(playerID).setScore(score);
    }

    /**
     * Metodo che applica la <i>Function</i> che è contenuta all'interno della classe {@link Winner}, che serve
     * a stabilire quale giocatore ha vinto la partita, ritornando il suo <i>id</i>.
     *
     * @return l'id del giocatore che ha vinto la partita.
     * @see java.util.function.Function
     */
    public Integer winner() {
        return winner.check().apply(players);
    }
}
