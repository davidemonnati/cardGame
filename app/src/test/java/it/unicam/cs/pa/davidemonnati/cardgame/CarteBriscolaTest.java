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
        assertEquals(CarteBriscola.Color.BLACK, card.getColor());
        assertEquals(CarteBriscola.Seed.COPPE, card.getSeedValue());
        assertEquals(CarteBriscola.Rank.RE, card.getRankValue());
    }

    @Test
    void getColorTest() {
        CarteBriscola card = new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.COPPE, CarteBriscola.Rank.RE);
        assertEquals(CarteBriscola.Color.BLACK, card.getColor());
    }

    @Test
    void getSeedTest() {
        CarteBriscola card = new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.COPPE, CarteBriscola.Rank.RE);
        assertEquals(CarteBriscola.Seed.COPPE, card.getSeedValue());
    }

    @Test
    void getRankTest() {
        CarteBriscola card = new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.COPPE, CarteBriscola.Rank.RE);
        assertEquals(CarteBriscola.Rank.RE, card.getRankValue());
    }

    @Test
    void getScoreTest() {
        CarteBriscola card1 = new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.COPPE, CarteBriscola.Rank.A);
        CarteBriscola card2 = new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.COPPE, CarteBriscola.Rank.CINQUE);
        assertEquals(11, card1.getRankValue().getScore());
        assertEquals(0, card2.getRankValue().getScore());
    }
}
