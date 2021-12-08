package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.CarteBriscola;
import it.unicam.cs.pa.davidemonnati.cardgame.model.PlayerDeck;
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
        Card card = new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.BASTONI, CarteBriscola.Rank.DUE);
        PlayerDeck deck = PlayerDeck.empty();
        deck.insertCard(card);
        assertEquals(deck.getCards().get(0), card);
    }

    @Test
    void popCardTest() {
        PlayerDeck playerDeck = PlayerDeck.empty();
        Card[] cardsToInsert = getSampleDeck();
        for (int i = 0; i < 3; i++) {
            playerDeck.insertCard(cardsToInsert[i]);
            assertTrue(playerDeck.getCards().search(cardsToInsert[i]) >= 0);
        }

        for (int i = 0; i < 3; i++) {
            playerDeck.removeCard(0);
            assertFalse(playerDeck.getCards().search(cardsToInsert[i]) >= 0);
        }
        assertEquals(playerDeck.getSize(), 0);
    }

    private Card[] getSampleDeck() {
        Card carta1 = new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.BASTONI, CarteBriscola.Rank.A);
        Card carta2 = new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.COPPE, CarteBriscola.Rank.QUATTRO);
        Card carta3 = new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.SPADE, CarteBriscola.Rank.CAVALLO);
        Card[] toInsert = new Card[]{carta1, carta2, carta3};
        return toInsert;
    }
}
