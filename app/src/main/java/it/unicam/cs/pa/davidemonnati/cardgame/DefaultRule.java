package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.table.Table;

import java.util.function.BiFunction;

/**
 * Regola base di gioco, che consiste nel:
 * Il giocatore ha delle carte in mano, a turno si gioca una carta e chi ha buttato la carta con il valore più alto
 * si aggiudica la presa.
 * Questa è solamente una regola di test.
 */
public class DefaultRule implements Rule {
    @Override
    public BiFunction<Table, GameTurn, GameTurn> rule() {
        return (table, turn) -> {
            int scoreCard1 = table.getPlayedCards()[0].getScore();
            if (table.getPlayedCards()[1] != null) {
                int scoreCard2 = table.getPlayedCards()[1].getScore();
                if ((table.getPlayedCards()[0].getScore() > table.getPlayedCards()[1].getScore())
                        || (table.getPlayedCards()[0].getScore() == table.getPlayedCards()[1].getScore())) {
                    turn.setScore(0, (scoreCard1 + scoreCard2));
                    table.insertIntoPlayerDeck(0);
                } else {
                    turn.setScore(1, (scoreCard1 + scoreCard2));
                    table.insertIntoPlayerDeck(1);
                }
                table.resetPlayedCards();
            }
            turn.opponentPlayer();
            return turn;
        };
    }
}
