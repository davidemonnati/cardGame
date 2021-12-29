package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.exception.IllegalCardPositionException;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Status;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.Table;
import it.unicam.cs.pa.davidemonnati.cardgame.view.ConsoleView;
import it.unicam.cs.pa.davidemonnati.cardgame.view.View;

import java.io.IOException;
import java.util.function.BiFunction;

public class GameController implements Game {
    private final Status status;
    private GameTurn turn;
    private final Table table;
    private final BiFunction<Table, GameTurn, GameTurn> rule;
    private final View view;

    public GameController(GameTurn turn, Table table, BiFunction<Table, GameTurn, GameTurn> rule) {
        this.status = new Status();
        this.turn = turn;
        this.table = table;
        this.rule = rule;
        this.view = new ConsoleView();
    }

    @Override
    public void play() throws IOException {
        view.open();
        takeFirstCards(3);
        while (status.isStatus()) {
            try {
                int cardToPlay = view.updateState(turn.getHand(), turn.getPlayer());
                doAction(cardToPlay);
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
        view.close(turn.getPlayers());
    }

    private void doAction(int numCardToPlay) throws IOException, IllegalCardPositionException {
        playCard(numCardToPlay);
        takeCard();
        this.turn = rule.apply(table, turn);
        if (turn.getHandSize() == 0) {
            status.changeStatus();
        }
    }

    private void takeCard() {
        if (table.tableDeckSize() > 0) {
            Card toTake = table.takeCardFromDeck();
            turn.takeCard(toTake);
        }
    }

    private void takeFirstCards(Integer num) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < num; j++) {
                Card toTake = table.takeCardFromDeck();
                turn.takeCard(toTake);
            }
            turn.opponentPlayer();
        }
    }

    private void playCard(Integer pos) throws IllegalCardPositionException {
        Card toPlay = turn.playCard(pos);
        table.playCard(turn.getCurrentPlayer(), toPlay);
    }
}
