package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.PlayerDeck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.BriscolaRank;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.BriscolaSeed;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola.Asso;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola.Cavallo;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola.Liscio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerDeckTest {
    @Test
    void createPlayerDeckTest() {
        PlayerDeck deck = PlayerDeck.empty();
        assertNotNull(deck);
    }

    @Test
    void insertCardTest() {
        Card card = new Liscio(BriscolaSeed.BASTONI, BriscolaRank.DUE);
        PlayerDeck deck = PlayerDeck.empty();
        deck.insertCard(card);
        assertEquals(card, deck.getCard(0));
    }

    @Test
    void popRemoveCardTest() {
        PlayerDeck playerDeck = PlayerDeck.empty();
        Card[] cardsToInsert = getSampleDeck();
        for (int i = 0; i < 3; i++) {
            playerDeck.insertCard(cardsToInsert[i]);
            assertTrue(playerDeck.searchCard(cardsToInsert[i]) >= 0);
        }
        assertEquals(3, playerDeck.getSize());

        for (int i = 0; i < 3; i++) {
            playerDeck.removeCard(0);
            assertFalse(playerDeck.searchCard(cardsToInsert[i]) >= 0);
        }
        assertEquals(0, playerDeck.getSize());
    }

    private Card[] getSampleDeck() {
        Card carta1 = new Asso(BriscolaSeed.BASTONI);
        Card carta2 = new Liscio(BriscolaSeed.COPPE, BriscolaRank.QUATTRO);
        Card carta3 = new Cavallo(BriscolaSeed.SPADE);
        return new Card[]{carta1, carta2, carta3};
    }
}
