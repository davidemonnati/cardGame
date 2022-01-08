package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.DefaultHand;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Hand;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.NeapolitanRank;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.NeapolitanSeed;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.Asso;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.Cavallo;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.Liscio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HandTest {

    @Test
    void createHandTest() {
        Hand hand = new DefaultHand();
        assertNotNull(hand);
        assertEquals(0, hand.getSize());
    }

    @Test
    void takeCardTest() {
        Hand hand = getHand();
        assertEquals(3, hand.getSize());
    }

    @Test
    void playCardTest() {
        Hand hand = getHand();
        hand.playCard(0);
        Card toSearch = new Asso(NeapolitanSeed.BASTONI);
        assertEquals(-1, hand.search(toSearch));
        toSearch = new Cavallo(NeapolitanSeed.SPADE);
        hand.playCard(1);
        assertEquals(-1, hand.search(toSearch));
        toSearch = new Liscio(NeapolitanSeed.COPPE, NeapolitanRank.QUATTRO);
        hand.playCard(0);
        assertEquals(-1, hand.search(toSearch));
    }

    private Hand getHand() {
        Hand hand = new DefaultHand();
        hand.insert(getSampleDeck()[0]);
        hand.insert(getSampleDeck()[1]);
        hand.insert(getSampleDeck()[2]);
        return hand;
    }

    private Card[] getSampleDeck() {
        Card carta1 = new Asso(NeapolitanSeed.BASTONI);
        Card carta2 = new Liscio(NeapolitanSeed.COPPE, NeapolitanRank.QUATTRO);
        Card carta3 = new Cavallo(NeapolitanSeed.SPADE);
        return new Card[]{carta1, carta2, carta3};
    }
}
