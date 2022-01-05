package it.unicam.cs.pa.davidemonnati.cardgame.controller;

import it.unicam.cs.pa.davidemonnati.cardgame.controller.rule.BriscolaRule;
import it.unicam.cs.pa.davidemonnati.cardgame.controller.rule.DefaultRule;
import it.unicam.cs.pa.davidemonnati.cardgame.exception.UnknownGameException;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.BriscolaTable;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.NeapolitanTable;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.Table;
import it.unicam.cs.pa.davidemonnati.cardgame.view.BriscolaView;
import it.unicam.cs.pa.davidemonnati.cardgame.view.ConsoleView;

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

    public GameController<? extends Table> getGame(Turn turn) {
        switch (this) {
            case DEFAULT:
                return new GameController<>(turn, new NeapolitanTable(), new DefaultRule().rule(), new ConsoleView());
            case BRISCOLA:
                BriscolaTable table = new BriscolaTable();
                return new GameController<>(turn, table, new BriscolaRule().rule(), new BriscolaView(table));
            default:
                throw new UnknownGameException();
        }
    }
}
