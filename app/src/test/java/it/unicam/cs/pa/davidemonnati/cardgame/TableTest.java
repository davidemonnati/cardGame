package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.DefaultHand;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Hand;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.Asso;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.Fante;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.NeapolitanSeed;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.NeapolitanTable;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.Table;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TableTest {
    @Test
    void creationTableTest() {
        Table table = new NeapolitanTable();
        assertNotNull(table);
    }

    @Test
    void playCardTest() {
        Table table = new NeapolitanTable();
        Card card1 = new Asso(NeapolitanSeed.BASTONI);
        Card card2 = new Fante(NeapolitanSeed.DENARI);
        table.playCard(0, card1);
        table.playCard(1, card2);
        assertEquals(card1, table.getPlayedCards()[0]);
        assertEquals(card2, table.getPlayedCards()[1]);
    }

    @Test
    void testManagePlayerDeck() {
        Table table = new NeapolitanTable();
        List<Hand> hands = new ArrayList<>();
        hands.add(new DefaultHand());
        hands.add(new DefaultHand());
        for (int i = 0; i < 3; i++) {
            takeCard(table, hands.get(0));
            takeCard(table, hands.get(1));
        }

        table.playCard(0, hands.get(0).playCard(0));
        table.playCard(1, hands.get(1).playCard(0));
        assertEquals(0, table.getPlayerDeck(0).getSize());
        table.insertIntoPlayerDeck(0);
        assertEquals(2, table.getPlayerDeck(0).getSize());
    }

    private void takeCard(Table table, Hand hand) {
        if (table.tableDeckSize() > 0) {
            Card toTake = table.takeCardFromDeck();
            hand.takeCard(toTake);
        }
    }
}
