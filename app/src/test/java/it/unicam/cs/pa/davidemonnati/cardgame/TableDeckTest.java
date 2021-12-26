package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.TableDeck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.DefaultTableDeck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.napolitan.*;
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
        Card card = new Liscio(NapolitanSeed.BASTONI, NapolitanRank.DUE);
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

    private TableDeck getCompleteDeck() {
        TableDeck deck = DefaultTableDeck.empty();
        for (int i = 0; i < 4; i++) {
            deck.insert(new Asso(NapolitanSeed.values()[i]));
            deck.insert(new Tre(NapolitanSeed.values()[i]));
            deck.insert(new Fante(NapolitanSeed.values()[i]));
            deck.insert(new Cavallo(NapolitanSeed.values()[i]));
            deck.insert(new Re(NapolitanSeed.values()[i]));

            deck.insert(new Liscio(NapolitanSeed.values()[i], NapolitanRank.DUE));
            deck.insert(new Liscio(NapolitanSeed.values()[i], NapolitanRank.QUATTRO));
            deck.insert(new Liscio(NapolitanSeed.values()[i], NapolitanRank.CINQUE));
            deck.insert(new Liscio(NapolitanSeed.values()[i], NapolitanRank.SEI));
            deck.insert(new Liscio(NapolitanSeed.values()[i], NapolitanRank.SETTE));
        }
        return deck;
    }
}
