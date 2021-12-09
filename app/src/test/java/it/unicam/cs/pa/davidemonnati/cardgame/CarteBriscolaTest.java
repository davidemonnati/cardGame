package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.CarteBriscola;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CarteBriscolaTest {
    @Test
    void cardCreationTest() {
        CarteBriscola card = new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.COPPE, CarteBriscola.Rank.RE);
        assertNotNull(card);
        assertEquals(card.getColor(), CarteBriscola.Color.BLACK);
        assertEquals(card.getSeedValue(), CarteBriscola.Seed.COPPE);
        assertEquals(card.getRankValue(), CarteBriscola.Rank.RE);
    }

    @Test
    void getColorTest() {
        CarteBriscola card = new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.COPPE, CarteBriscola.Rank.RE);
        assertEquals(card.getColor(), CarteBriscola.Color.BLACK);
    }

    @Test
    void getSeedTest() {
        CarteBriscola card = new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.COPPE, CarteBriscola.Rank.RE);
        assertEquals(card.getSeedValue(), CarteBriscola.Seed.COPPE);
    }

    @Test
    void getRankTest() {
        CarteBriscola card = new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.COPPE, CarteBriscola.Rank.RE);
        assertEquals(card.getRankValue(), CarteBriscola.Rank.RE);
    }

    @Test
    void getScoreTest() {
        CarteBriscola card1 = new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.COPPE, CarteBriscola.Rank.A);
        CarteBriscola card2 = new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.COPPE, CarteBriscola.Rank.CINQUE);
        assertEquals(card1.getRankValue().getScore(), 11);
        assertEquals(card2.getRankValue().getScore(), 0);
    }
}
