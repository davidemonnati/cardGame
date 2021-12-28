package it.unicam.cs.pa.davidemonnati.cardgame.model.table;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.DefaultPlayerDeck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.DefaultTableDeck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.PlayerDeck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.TableDeck;

import java.util.ArrayList;
import java.util.List;

/**
 * Rappresenta il tavolo di gioco, il quale ha la responsabilità di gestire il TableDeck,
 * le carte che vengono giocate dai due giocatori e il mazzo delle carte che sono state aggiudicate
 * dai giocatori.
 */
public abstract class Table {
    protected final TableDeck tableDeck;
    private Card[] playedCards;
    private List<PlayerDeck> playerDecks;

    public Table() {
        this.tableDeck = DefaultTableDeck.empty();
        resetPlayedCards();
        initPlayerDeck();
    }

    private void initPlayerDeck() {
        this.playerDecks = new ArrayList<>();
        this.playerDecks.add(new DefaultPlayerDeck());
        this.playerDecks.add(new DefaultPlayerDeck());
    }

    /**
     * Ritorna il numero delle carte che sono presenti all'interno del TableDeck.
     *
     * @return valore intero corrispondente al numero di carte che ci sono nel TableDeck
     * @see it.unicam.cs.pa.davidemonnati.cardgame.model.deck.TableDeck
     */
    public int tableDeckSize() {
        return tableDeck.getSize();
    }

    /**
     * Permette ad un giocatore di prendere una carta dal mazzo.
     * In seguito alla presa la carta verrà eliminata dal TableDeck
     *
     * @return la prima carta che si trova in cima al mazzo
     * @see it.unicam.cs.pa.davidemonnati.cardgame.model.deck.TableDeck
     */
    public Card takeCardFromDeck() {
        return tableDeck.removeCard();
    }

    /**
     * Permette ad un <i>Player</i> di giocare una {@link Card}.
     * La {@link Card} giocata verrà passata come parametro ed inserita all'interno della posizione
     * corrispondente all'id del <i>Player</i>
     *
     * @param currentPlayer id del player che deve giocare la carta
     * @param card          carta che il giocatore vuole giocare
     */
    public void playCard(int currentPlayer, Card card) {
        playedCards[currentPlayer] = card;
    }

    /**
     * @return array contenete le {@link Card} che i <i>Player</i> hanno giocato
     */
    public Card[] getPlayedCards() {
        return playedCards;
    }

    /**
     * In seguito ad una vincita inserisce le {@link Card} giocate che ci sono sul {@link Table} all'interno
     * del mazzo del <i>Player</i> che ha vinto la mano.
     *
     * @param currentPlayer id del <i>Player</i> che ha vinto la mano
     */
    public void insertIntoPlayerDeck(int currentPlayer) {
        playerDecks.get(currentPlayer).insert(playedCards[0]);
        playerDecks.get(currentPlayer).insert(playedCards[1]);
    }

    /**
     * Ritorna il mazzo di un giocatore.
     *
     * @param playerId id del <i>Player</i> di cui si vuole ritornare tutto il deck
     * @return PlayerDeck del giocatore
     * @see it.unicam.cs.pa.davidemonnati.cardgame.model.deck.DefaultPlayerDeck
     */
    public PlayerDeck getPlayerDeck(int playerId) {
        return playerDecks.get(playerId);
    }

    /**
     * Ogni volta che il <i>Player</i> si aggiudica la mano è necessario svuotare
     * l'array <i>playedCards</i>.
     * Questo metodo verrà utilizzato anche dal costrutture per inizializzare <i>playedCards</i>
     * la prima volta.
     */
    public void resetPlayedCards() {
        this.playedCards = new Card[2];
    }
}
