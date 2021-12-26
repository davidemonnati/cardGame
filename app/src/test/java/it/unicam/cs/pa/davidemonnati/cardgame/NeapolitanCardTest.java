package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.*;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.napolitan.*;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NeapolitanCardTest {
    @Test
    void creationCardTest() {
        Card assoBastoni = new Asso(NapolitanSeed.BASTONI);
        assertNotNull(assoBastoni);
        assertEquals(NapolitanSeed.BASTONI, assoBastoni.getSeed());
        assertEquals(11, assoBastoni.getScore());
        assertEquals(NapolitanRank.ASSO, assoBastoni.getRank());
    }

    @Test
    void creationLiscioCardTest() {
        Card quattroBastoni = new Liscio(NapolitanSeed.BASTONI, NapolitanRank.QUATTRO);
        assertNotNull(quattroBastoni);
        assertEquals(NapolitanSeed.BASTONI, quattroBastoni.getSeed());
        assertEquals(NapolitanRank.QUATTRO, quattroBastoni.getRank());
        assertEquals(0, quattroBastoni.getScore());
    }

    @Test
    void cardsStackTest() {
        Stack<Card> cards = new Stack<>();
        cards.push(new Asso(NapolitanSeed.BASTONI));
        cards.push(new Liscio(NapolitanSeed.SPADE, NapolitanRank.QUATTRO));
        cards.push(new Fante(NapolitanSeed.DENARI));
        cards.push(new Re(NapolitanSeed.COPPE));
        assertEquals(4, cards.size());
    }
}
