package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BriscolaDeckTest {
    @Test
    void creationBriscolaDeckTest() {
        BriscolaDeck briscolaDeck = BriscolaDeck.empty();
        assertNotNull(briscolaDeck);
    }

    @Test
    void insertCardTest() {
        Card card = new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.BASTONI, CarteBriscola.Rank.DUE);
        BriscolaDeck deck = BriscolaDeck.empty();
        deck.insertCard(card);
        assertEquals(card, deck.getCard(0));
    }

    @Test
    void assoTest() {
        BriscolaDeck briscolaDeck = getSimpleDeck();
        Card expectedAsso = briscolaDeck.getCard(3);
        briscolaDeck.setAsso();
        assertEquals(expectedAsso, briscolaDeck.getAsso());
    }

    @Test
    void removeCardTest() {
        BriscolaDeck briscolaDeck = getSimpleDeck();
        Card removedCard = briscolaDeck.removeCard();
        assertEquals(3, briscolaDeck.getSize());
        assertEquals(-1, briscolaDeck.searchCard(removedCard));
    }

    @Test
    void playCardTest() {
        Player player = new DefaultPlayer(0, "Davide");
        BriscolaDeck briscolaDeck = BriscolaDeck.empty();
        Card toPlay = new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.BASTONI, CarteBriscola.Rank.A);
        briscolaDeck.playCard(player.getId(), toPlay);
        assertEquals(toPlay, briscolaDeck.getPlayer1ThrowingCard());
    }

    private BriscolaDeck getSimpleDeck() {
        BriscolaDeck deck = BriscolaDeck.empty();
        deck.insertCard(new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.BASTONI, CarteBriscola.Rank.A));
        deck.insertCard(new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.COPPE, CarteBriscola.Rank.QUATTRO));
        deck.insertCard(new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.SPADE, CarteBriscola.Rank.CAVALLO));
        deck.insertCard(new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.DENARI, CarteBriscola.Rank.FANTE));
        return deck;
    }

    private List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        Player player1 = new DefaultPlayer(0, "Davide");
        Player player2 = new DefaultPlayer(1, "Riccardo");
        players.add(player1);
        players.add(player2);
        return players;
    }
}
