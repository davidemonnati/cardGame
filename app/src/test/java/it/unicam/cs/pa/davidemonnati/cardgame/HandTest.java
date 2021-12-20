package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.DefaultHand;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Hand;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola.BriscolaRank;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola.BriscolaSeed;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola.Asso;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola.Cavallo;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola.Liscio;
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
        Card toSearch = new Asso(BriscolaSeed.BASTONI);
        assertEquals(-1, hand.search(toSearch));
        toSearch = new Cavallo(BriscolaSeed.SPADE);
        hand.playCard(1);
        assertEquals(-1, hand.search(toSearch));
        toSearch = new Liscio(BriscolaSeed.COPPE, BriscolaRank.QUATTRO);
        hand.playCard(0);
        assertEquals(-1, hand.search(toSearch));
    }

    private Hand getHand() {
        Hand hand = new DefaultHand();
        hand.takeCard(getSampleDeck()[0]);
        hand.takeCard(getSampleDeck()[1]);
        hand.takeCard(getSampleDeck()[2]);
        return hand;
    }

    private Card[] getSampleDeck() {
        Card carta1 = new Asso(BriscolaSeed.BASTONI);
        Card carta2 = new Liscio(BriscolaSeed.COPPE, BriscolaRank.QUATTRO);
        Card carta3 = new Cavallo(BriscolaSeed.SPADE);
        return new Card[]{carta1, carta2, carta3};
    }
}
