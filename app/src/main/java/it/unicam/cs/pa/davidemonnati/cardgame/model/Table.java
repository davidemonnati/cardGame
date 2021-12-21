package it.unicam.cs.pa.davidemonnati.cardgame.model;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.PlayerDeck;

/**
 * Rappresenta il tavolo di gioco, il quale ha la responsabilità di gestire il TableDeck,
 * le carte che vengono giocate dai due giocatori e il mazzo delle carte che sono state aggiudicate
 * dai giocatori.
 */
public interface Table {

    /**
     * Ritorna il numero delle carte che sono presenti all'interno del TableDeck.
     *
     * @return valore intero corrispondente al numero di carte che ci sono nel TableDeck
     * @see it.unicam.cs.pa.davidemonnati.cardgame.model.deck.TableDeck
     */
    int tableDeckSize();

    /**
     * Permette ad un giocatore di prendere una carta dal mazzo.
     * In seguito alla presa la carta verrà eliminata dal TableDeck
     *
     * @return la prima carta che si trova in cima al mazzo
     * @see it.unicam.cs.pa.davidemonnati.cardgame.model.deck.TableDeck
     */
    Card takeCardFromDeck();

    /**
     * Permette ad un {@link Player} di giocare una {@link Card}.
     * La {@link Card} giocata verrà passata come parametro ed inserita all'interno della posizione
     * corrispondente all'id del {@link Player}
     *
     * @param currentPlayer id del player che deve giocare la carta
     * @param card          carta che il giocatore vuole giocare
     */
    void playCard(int currentPlayer, Card card);

    /**
     * @return array contenete le {@link Card} che i {@link Player} hanno giocato
     */
    Card[] getPlayedCards();

    /**
     * In seguito ad una vincita inserisce le {@link Card} giocate che ci sono sul {@link Table} all'interno
     * del mazzo del {@link Player} che ha vinto la mano.
     *
     * @param currentPlayer id del {@link Player} che ha vinto la mano
     */
    void insertIntoPlayerDeck(int currentPlayer);

    /**
     * Ritorna il mazzo di un giocatore.
     *
     * @param playerId id del {@link Player} di cui si vuole ritornare tutto il deck
     * @return PlayerDeck del giocatore
     * @see it.unicam.cs.pa.davidemonnati.cardgame.model.deck.DefaultPlayerDeck
     */
    PlayerDeck getPlayerDeck(int playerId);
}
