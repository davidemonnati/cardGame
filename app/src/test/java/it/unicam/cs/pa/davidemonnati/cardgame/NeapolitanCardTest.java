package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.*;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.*;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NeapolitanCardTest {
    @Test
    void creationCardTest() {
        Card assoBastoni = new Asso(NeapolitanSeed.BASTONI);
        assertNotNull(assoBastoni);
        assertEquals(NeapolitanSeed.BASTONI, assoBastoni.getSeed());
        assertEquals(11, assoBastoni.getScore());
        assertEquals(NeapolitanRank.ASSO, assoBastoni.getRank());
    }

    @Test
    void creationLiscioCardTest() {
        Card quattroBastoni = new Liscio(NeapolitanSeed.BASTONI, NeapolitanRank.QUATTRO);
        assertNotNull(quattroBastoni);
        assertEquals(NeapolitanSeed.BASTONI, quattroBastoni.getSeed());
        assertEquals(NeapolitanRank.QUATTRO, quattroBastoni.getRank());
        assertEquals(0, quattroBastoni.getScore());
    }

    @Test
    void cardsStackTest() {
        Stack<Card> cards = new Stack<>();
        cards.push(new Asso(NeapolitanSeed.BASTONI));
        cards.push(new Liscio(NeapolitanSeed.SPADE, NeapolitanRank.QUATTRO));
        cards.push(new Fante(NeapolitanSeed.DENARI));
        cards.push(new Re(NeapolitanSeed.COPPE));
        assertEquals(4, cards.size());
    }
}
