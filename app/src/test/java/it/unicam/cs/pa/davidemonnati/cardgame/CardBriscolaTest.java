package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.*;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola.*;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CardBriscolaTest {
    @Test
    void creationCardTest() {
        Card assoBastoni = new Asso(BriscolaSeed.BASTONI);
        assertNotNull(assoBastoni);
        assertEquals(BriscolaSeed.BASTONI, assoBastoni.getSeed());
        assertEquals(11, assoBastoni.getScore());
        assertEquals(BriscolaRank.ASSO, assoBastoni.getRank());
    }

    @Test
    void creationLiscioCardTest() {
        Card quattroBastoni = new Liscio(BriscolaSeed.BASTONI, BriscolaRank.QUATTRO);
        assertNotNull(quattroBastoni);
        assertEquals(BriscolaSeed.BASTONI, quattroBastoni.getSeed());
        assertEquals(BriscolaRank.QUATTRO, quattroBastoni.getRank());
        assertEquals(0, quattroBastoni.getScore());
    }

    @Test
    void cardsStackTest() {
        Stack<Card> cards = new Stack<>();
        cards.push(new Asso(BriscolaSeed.BASTONI));
        cards.push(new Liscio(BriscolaSeed.SPADE, BriscolaRank.QUATTRO));
        cards.push(new Fante(BriscolaSeed.DENARI));
        cards.push(new Re(BriscolaSeed.COPPE));
        assertEquals(4, cards.size());
    }
}
