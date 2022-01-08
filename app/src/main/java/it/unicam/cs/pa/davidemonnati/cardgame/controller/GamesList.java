package it.unicam.cs.pa.davidemonnati.cardgame.controller;

import it.unicam.cs.pa.davidemonnati.cardgame.controller.rule.BriscolaRule;
import it.unicam.cs.pa.davidemonnati.cardgame.controller.rule.DefaultRule;
import it.unicam.cs.pa.davidemonnati.cardgame.controller.winner.DefaultWinner;
import it.unicam.cs.pa.davidemonnati.cardgame.exception.UnknownGameException;
import it.unicam.cs.pa.davidemonnati.cardgame.model.player.Player;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.BriscolaTable;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.NeapolitanTable;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.Table;
import it.unicam.cs.pa.davidemonnati.cardgame.view.BriscolaView;
import it.unicam.cs.pa.davidemonnati.cardgame.view.ConsoleView;

import java.util.List;

/**
 * Enum che contiene tutti i possibili giochi a cui si possono giocare.
 * Attualmente i giochi implementati sono i seguenti:
 * <ul>
 *     <li>Default</li>
 *     <li>Briscola</li>
 * </ul>
 */
public enum GamesList {
    DEFAULT, BRISCOLA;

    public GameController<? extends Table> getGame(List<Player> players) {
        Turn turn;
        switch (this) {
            case DEFAULT -> {
                turn = Turn.getInstance(players, new DefaultWinner());
                return GameController.getInstance(turn, new NeapolitanTable(), new DefaultRule(3), new ConsoleView());
            }
            case BRISCOLA -> {
                BriscolaTable table = new BriscolaTable();
                turn = Turn.getInstance(players, new DefaultWinner());
                return GameController.getInstance(turn, table, new BriscolaRule(3), new BriscolaView(table));
            }
            default -> throw new UnknownGameException();
        }
    }
}
