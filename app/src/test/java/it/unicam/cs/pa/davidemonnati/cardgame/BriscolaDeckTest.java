package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BriscolaDeckTest {
    @Test
    void creationBriscolaDeckTest() {
        BriscolaDeck briscolaDeck = BriscolaDeck.empty();
        assertNotNull(briscolaDeck);
    }

    /*@Test
    void throwingCardsNotNullTest() {
        BriscolaDeck briscolaDeck = BriscolaDeck.empty();
        briscolaDeck.initThrowingCards();
        assertNotNull(briscolaDeck.getPlayer1ThrowingCard());
        assertNotNull(briscolaDeck.getPlayer2ThrowingCard());
        assertNotNull(briscolaDeck.getThrowingCards());
    }*/

    @Test
    void playCardTest() {
        Player player = new DefaultPlayer(0, "Davide");
        BriscolaDeck playerDeck = getDeck();
        player.setPlayerDeck(playerDeck);
        int pos = 2;
        Card cardToPlay = playerDeck.getCard(pos);
        PlayerDeck actualPlayerDeck = player.getPlayerDeck();
        playerDeck.playCard(player.getId(), actualPlayerDeck.removeCard(pos));
        assertEquals(actualPlayerDeck.searchCard(cardToPlay), -1);
        assertEquals(actualPlayerDeck.getSize(), 3);
        assertEquals(playerDeck.getPlayer1ThrowingCard(), cardToPlay);
    }

    private BriscolaDeck getDeck() {
        BriscolaDeck deck = BriscolaDeck.empty();
        deck.insertCard(new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.BASTONI, CarteBriscola.Rank.A));
        deck.insertCard(new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.COPPE, CarteBriscola.Rank.QUATTRO));
        deck.insertCard(new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.SPADE, CarteBriscola.Rank.CAVALLO));
        deck.insertCard(new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.DENARI, CarteBriscola.Rank.FANTE));
        return deck;
    }
}
