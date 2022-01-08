package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.controller.Turn;
import it.unicam.cs.pa.davidemonnati.cardgame.controller.rule.BriscolaRule;
import it.unicam.cs.pa.davidemonnati.cardgame.controller.winner.DefaultWinner;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.Cavallo;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.Liscio;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.NeapolitanRank;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.NeapolitanSeed;
import it.unicam.cs.pa.davidemonnati.cardgame.model.player.InteractivePlayer;
import it.unicam.cs.pa.davidemonnati.cardgame.model.player.Player;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.BriscolaTable;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.Table;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BriscolaRuleTest <T extends Table> {
    private final BriscolaTable briscolaTable;
    private final Turn turn;
    private final BiConsumer<BriscolaTable, Turn> rule;
    private final Card briscola;

    public BriscolaRuleTest() {
        this.briscolaTable = new BriscolaTable();
        this.turn = Turn.getInstance(createPlayers(), new DefaultWinner());
        this.rule = new BriscolaRule(3).rule();
        this.briscola = new Cavallo(NeapolitanSeed.SPADE);
    }

    @AfterEach
    void initTest() {
        assertNotNull(briscolaTable);
        assertNotNull(turn);
        assertNotNull(rule);
        assertNotNull(briscola);
    }

    @Test
    void giocataTest() {
        NeapolitanSeed briscola = briscolaTable.getBriscolaSeed();
        Card player1Card = new Liscio(NeapolitanSeed.BASTONI, NeapolitanRank.QUATTRO);
        Card player2Card = new Liscio(NeapolitanSeed.DENARI, NeapolitanRank.RE);
        briscolaTable.playCard(0, player1Card);
        briscolaTable.playCard(1, player2Card);
        assertEquals(0, turn.getCurrentPlayer());
        rule.accept(briscolaTable, turn);
        List<Player> players = turn.getPlayers();
        if (((player1Card.getSeed() != briscola) && (player2Card.getSeed() != briscola)) ||
                ((player1Card.getSeed() == briscola) && (player2Card.getSeed() == briscola))) {
            if (player1Card.getRank().ordinal() >= player2Card.getRank().ordinal()) {
                turn.setScore(turn.getCurrentPlayer(), (player1Card.getScore() + player2Card.getScore()));
                assertEquals(0, turn.getCurrentPlayer());
            } else {
                turn.setScore(turn.getOpponentPlayer(), (player1Card.getScore() + player2Card.getScore()));
                turn.setTurn(turn.getOpponentPlayer());
                assertEquals(1, turn.getOpponentPlayer());
            }
        } else if (player1Card.getSeed() == briscola) {
            turn.setScore(turn.getCurrentPlayer(), (player1Card.getScore() + player2Card.getScore()));
            assertEquals(0, turn.getCurrentPlayer());
        } else if (player2Card.getSeed() == briscola) {
            turn.setScore(turn.getOpponentPlayer(), (player1Card.getScore() + player2Card.getScore()));
            turn.setTurn(turn.getOpponentPlayer());
            assertEquals(1, turn.getOpponentPlayer());
        }
    }

    private List<Player> createPlayers() {
        List<Player> players = new ArrayList<>();
        Player player1 = new InteractivePlayer(0, "Davide");
        Player player2 = new InteractivePlayer(1, "Riccardo");
        players.add(player1);
        players.add(player2);
        return players;
    }
}
