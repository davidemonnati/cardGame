package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.TableDeck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.DefaultTableDeck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TableDeckTest {
    @Test
    void creationNeapolitanDeckTest() {
        TableDeck tableDeck = DefaultTableDeck.empty();
        assertNotNull(tableDeck);
    }

    @Test
    void insertCardTest() {
        Card card = new Liscio(NeapolitanSeed.BASTONI, NeapolitanRank.DUE);
        TableDeck deck = DefaultTableDeck.empty();
        deck.insert(card);
        assertEquals(1, deck.getSize());
        assertEquals(card, deck.removeCard());
        assertEquals(0, deck.getSize());
    }

    @Test
    void removeCardTest() {
        TableDeck deck = getCompleteDeck();
        assertEquals(40, deck.getSize());
        Card removedCard = deck.removeCard();
        assertEquals(39, deck.getSize());
        assertEquals(-1, deck.search(removedCard));
    }

    @Test
    void testGetCard() {
        TableDeck deck = getCompleteDeck();
        assertEquals(40, deck.getSize());
        Card card = deck.getCard((deck.getSize()) - 1);
        assertEquals(40, deck.getSize());
        assertEquals(1, deck.search(card)); // LIFO
    }

    @Test
    void createDeckTest() {
        TableDeck tableDeck = getCompleteDeck();
        assertEquals(40, tableDeck.getSize());
    }

    private TableDeck getCompleteDeck() {
        TableDeck deck = DefaultTableDeck.empty();
        for (int i = 0; i < 4; i++) {
            deck.insert(new Asso(NeapolitanSeed.values()[i]));
            deck.insert(new Tre(NeapolitanSeed.values()[i]));
            deck.insert(new Fante(NeapolitanSeed.values()[i]));
            deck.insert(new Cavallo(NeapolitanSeed.values()[i]));
            deck.insert(new Re(NeapolitanSeed.values()[i]));

            deck.insert(new Liscio(NeapolitanSeed.values()[i], NeapolitanRank.DUE));
            deck.insert(new Liscio(NeapolitanSeed.values()[i], NeapolitanRank.QUATTRO));
            deck.insert(new Liscio(NeapolitanSeed.values()[i], NeapolitanRank.CINQUE));
            deck.insert(new Liscio(NeapolitanSeed.values()[i], NeapolitanRank.SEI));
            deck.insert(new Liscio(NeapolitanSeed.values()[i], NeapolitanRank.SETTE));
        }
        return deck;
    }
}
