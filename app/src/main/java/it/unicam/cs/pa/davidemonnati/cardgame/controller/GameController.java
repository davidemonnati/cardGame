package it.unicam.cs.pa.davidemonnati.cardgame.controller;

import it.unicam.cs.pa.davidemonnati.cardgame.controller.rule.Rule;
import it.unicam.cs.pa.davidemonnati.cardgame.exception.IllegalCardPositionException;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Status;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.Table;
import it.unicam.cs.pa.davidemonnati.cardgame.view.View;

import java.io.IOException;

/**
 * Classe generica che ha come responsabilità quella di gestire l'intera partita. <br />
 * Nello specifico andiamo a gestire le azioni base del <i>Player</i> ovvero quella di prendere delle carte e
 * di giocarle, l'avvio e la terminazione della partita.
 *
 * @param <T> tipo generico che rappresenta una classe che estende {@link Table}
 */
public class GameController <T extends Table> implements Game {
    /**
     * Classe singleton.
     */
    private static GameController<? extends Table> instance = null;
    private final Status status;
    private final Turn turn;
    private final T table;
    private final Rule<T> rule;
    private final View view;

    private GameController(Turn turn, T table, Rule<T> rule, View view) {
        this.status = Status.getInstance();
        this.turn = turn;
        this.table = table;
        this.rule = rule;
        this.view = view;
    }

    /**
     * Ritorna l'istanza della classe o la crea se è uguale a <i>null</i>.
     *
     * @param turn oggetto che rappresenta il turno della partita
     * @param table tavolo da gioco
     * @param rule regola da applicare al gioco scelto
     * @param view view per interagire con l'utente
     * @param <T> tipo che estende la classe {@link Table}
     * @return istanza della classe
     */
    public static<T extends Table> GameController<? extends Table>getInstance(Turn turn, T table,
                                                                              Rule<T> rule, View view) {
        if (instance == null) {
            instance = new GameController<>(turn, table, rule, view);
        }
        return instance;
    }

    /**
     * Gestisce l'esecuzione della partita mantenendo un ciclo <i>while</i> attivo finché lo stato della partita è
     * uguale a <i>true</i>. <br />
     * All'interno del <i>while</i> richiamo il metodo <i>doAction()</i> che si occupa di far eseguire alcune azioni
     * all'utente. <br />
     * Quando lo stato diventa <i>false</i> il ciclo viene interrotto e si stabilisce chi è il vincitore.
     *
     * @throws IOException Errori di I/O
     * @see Status
     * @see Turn
     */
    @Override
    public void play() throws IOException {
        view.open();
        takeFirstCards();
        while (status.isStatus()) {
            try {
                doAction();
            } catch (IOException | IllegalCardPositionException e) {
                System.out.println(e.getMessage());
                System.out.println("Premi un tasto per continuare");
                System.in.read();
            } catch (NumberFormatException e) {
                System.out.println("ERRORE: il valore che hai inserito non è corretto");
                System.out.println("Premi un tasto per continuare");
                System.in.read();
            }
        }
        Integer winnerID = turn.winner();
        view.close(turn.getPlayers(), winnerID);
    }

    /**
     * Azioni che vengono eseguite dal giocatore durante il suo turno.<br />
     * Le azioni consistono nel:
     * <ul>
     *     <li>Giocare una carta dalla mano</li>
     *     <li>Prendere la carta dal tavolo</li>
     *     <li>Applicare la regola del gioco per stabilire chi si aggiudica la presa</li>
     * </ul>
     * <p>
     * Infine quando un giocatore ha terminato tutte le carte dalla mano, il gioco termina cambiando lo stato della
     * partita.
     *
     * @throws IOException                  errori di I/O
     * @throws IllegalCardPositionException viene catturato quando l'utente inserisce una posizione non valida
     * @see Rule
     */
    private void doAction() throws IOException, IllegalCardPositionException {
        playCard();
        takeCard();
        rule.rule().accept(table, turn);
        if (turn.getHandSize() == 0) {
            status.changeStatus();
        }
    }

    /**
     * Permette al giocatore di prendere una carta dal mazzo.
     */
    private void takeCard() {
        if (table.tableDeckSize() > 0) {
            Card toTake = table.takeCardFromDeck();
            turn.takeCard(toTake);
        }
    }

    /**
     * Permette all'utente di prendere le prime carte dal mazzo, che solitamente sono tre, appena viene
     * avviata la partita.
     */
    private void takeFirstCards() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < rule.getCards(); j++) {
                Card toTake = table.takeCardFromDeck();
                turn.takeCard(toTake);
            }
            turn.setOpponentPlayer();
        }
    }

    /**
     * Consente al giocatore di giocare una carta dalla propria mano.<br />
     * Viene invocato il metodo <i>updateState()</i> dalla view che stampa lo stato attuale della partita, la mano del
     * giocatore e richiede al Player di selezionare una carta da giocare.
     *
     * @see View
     * @throws IOException Errore di I/O lanciato dalla view
     * @throws IllegalCardPositionException viene lanciato quando l'utente inserisce una posizione non valida
     */
    private void playCard() throws IOException, IllegalCardPositionException {
        int pos = view.updateState(turn.getHand(), turn.getPlayer());
        Card toPlay = turn.playCard(pos);
        table.playCard(turn.getCurrentPlayer(), toPlay);
    }
}
