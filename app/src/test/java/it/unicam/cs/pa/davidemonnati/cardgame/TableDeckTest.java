package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.TableDeck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.DefaultTableDeck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TableDeckTest {
    @Test
    void creationBriscolaDeckTest() {
        TableDeck tableDeck = DefaultTableDeck.empty();
        assertNotNull(tableDeck);
    }

    @Test
    void insertCardTest() {
        Card card = new Liscio(BriscolaSeed.BASTONI, BriscolaRank.DUE);
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
            deck.insert(new Asso(BriscolaSeed.values()[i]));
            deck.insert(new Tre(BriscolaSeed.values()[i]));
            deck.insert(new Fante(BriscolaSeed.values()[i]));
            deck.insert(new Cavallo(BriscolaSeed.values()[i]));
            deck.insert(new Re(BriscolaSeed.values()[i]));

            deck.insert(new Liscio(BriscolaSeed.values()[i], BriscolaRank.DUE));
            deck.insert(new Liscio(BriscolaSeed.values()[i], BriscolaRank.QUATTRO));
            deck.insert(new Liscio(BriscolaSeed.values()[i], BriscolaRank.CINQUE));
            deck.insert(new Liscio(BriscolaSeed.values()[i], BriscolaRank.SEI));
            deck.insert(new Liscio(BriscolaSeed.values()[i], BriscolaRank.SETTE));
        }
        return deck;
    }
}
