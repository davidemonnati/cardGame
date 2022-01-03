package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.exception.UnknownGameException;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.BriscolaTable;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.NeapolitanTable;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.Table;
import it.unicam.cs.pa.davidemonnati.cardgame.view.BriscolaView;
import it.unicam.cs.pa.davidemonnati.cardgame.view.ConsoleView;

public enum GamesList {
    DEFAULT, BRISCOLA;

    public GameController<? extends Table> getGame(GameTurn turn) {
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
