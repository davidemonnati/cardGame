package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.*;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola.*;
import it.unicam.cs.pa.davidemonnati.cardgame.model.DefaultHand;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.DefaultTableDeck;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TableTest {
    @Test
    void creationTableTest() {
        Table table = new Table(DefaultTableDeck.empty());
        assertNotNull(table);
    }

    @Test
    void playCardTest() {
        Table table = new Table(DefaultTableDeck.empty());
        Card card1 = new Asso(BriscolaSeed.BASTONI);
        Card card2 = new Fante(BriscolaSeed.DENARI);
        table.playCard(0, card1);
        table.playCard(1, card2);
        assertEquals(card1, table.getThrowingCards()[0]);
        assertEquals(card2, table.getThrowingCards()[1]);
    }

    @Test
    void testManagePlayerDeck() {
        Table table = new Table(getCompleteDeck());
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

    private DefaultTableDeck getCompleteDeck() {
        DefaultTableDeck tableDeck = DefaultTableDeck.empty();
        for (int i = 0; i < 4; i++) {
            tableDeck.insert(new Asso(BriscolaSeed.values()[i]));
            tableDeck.insert(new Tre(BriscolaSeed.values()[i]));
            tableDeck.insert(new Fante(BriscolaSeed.values()[i]));
            tableDeck.insert(new Cavallo(BriscolaSeed.values()[i]));
            tableDeck.insert(new Re(BriscolaSeed.values()[i]));

            tableDeck.insert(new Liscio(BriscolaSeed.values()[i], BriscolaRank.DUE));
            tableDeck.insert(new Liscio(BriscolaSeed.values()[i], BriscolaRank.QUATTRO));
            tableDeck.insert(new Liscio(BriscolaSeed.values()[i], BriscolaRank.CINQUE));
            tableDeck.insert(new Liscio(BriscolaSeed.values()[i], BriscolaRank.SEI));
            tableDeck.insert(new Liscio(BriscolaSeed.values()[i], BriscolaRank.SETTE));
        }
        return tableDeck;
    }

    private void takeCard(Table table, Hand hand) {
        if (table.tableDeckSize() > 0) {
            Card toTake = table.takeCardFromDeck();
            hand.takeCard(toTake);
        }
    }
}