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

    @Test
    void initThrowingCardsTest() {
        BriscolaDeck briscolaDeck = BriscolaDeck.empty();
        briscolaDeck.initThrowingCards();
        assertNotNull(briscolaDeck.getThrowingCards());
    }

    @Test
    void playCardTest() {
        Player player = new DefaultPlayer(0, "Davide");
        BriscolaDeck playerDeck = getDeck();
        player.setPlayerDeck(playerDeck);
        int pos = 2;
        Card cardToPlay = playerDeck.getCards().get(pos);
        PlayerDeck actualPLayerDeck = player.getPlayerDeck();
        playerDeck.playCard(player.getId(), actualPLayerDeck.getCards().remove(pos));
        assertEquals(actualPLayerDeck.getCards().search(cardToPlay), -1);
        assertEquals(actualPLayerDeck.getCards().size(), 3);
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
