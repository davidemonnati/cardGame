package it.unicam.cs.pa.davidemonnati.cardgame.controller.rule;

import it.unicam.cs.pa.davidemonnati.cardgame.controller.Turn;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.NeapolitanSeed;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.BriscolaTable;

import java.util.function.BiConsumer;

/**
 * Regola per giocare a Briscola
 */
public class BriscolaRule implements Rule {
    @Override
    public BiConsumer<BriscolaTable, Turn> rule() {
        return (table, turn) -> {
            NeapolitanSeed briscola = table.getBriscolaSeed();
            Card card1 = table.getPlayedCards()[turn.getCurrentPlayer()];
            if (table.getPlayedCards()[turn.getOpponentPlayer()] != null) {
                Card card2 = table.getPlayedCards()[turn.getOpponentPlayer()];
                if (((card1.getSeed() != briscola) && (card2.getSeed() != briscola)) ||
                        ((card1.getSeed() == briscola) && (card2.getSeed() == briscola))) {
                    if (card1.getRank().ordinal() >= card2.getRank().ordinal()) {
                        presa(turn, table);
                    } else {
                        presa(turn, table);
                        turn.setTurn(turn.getOpponentPlayer());
                    }
                    table.resetPlayedCards();
                } else if (card1.getSeed() == briscola) {
                    presa(turn, table);
                } else if (card2.getSeed() == briscola) {
                    presa(turn, table);
                    turn.setTurn(turn.getOpponentPlayer());
                }
                table.resetPlayedCards();
            } else {
                turn.setOpponentPlayer();
            }
        };
    }

    /**
     * Metodo che viene invocato ogni volta che un giocatore vince la mano.
     *
     * @param turn  turno attuale
     * @param table lo stato del tavolo attuale
     */
    private void presa(Turn turn, BriscolaTable table) {
        int scoreCard1 = table.getPlayedCards()[0].getScore();
        int scoreCard2 = table.getPlayedCards()[1].getScore();
        turn.setScore(turn.getCurrentPlayer(), (scoreCard1 + scoreCard2));
        table.insertIntoPlayerDeck(turn.getCurrentPlayer());
    }
}
