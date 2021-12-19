package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.*;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.BriscolaRank;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.BriscolaSeed;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola.Asso;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola.Cavallo;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola.Fante;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola.Liscio;
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
        Card card = new Liscio(BriscolaSeed.BASTONI, BriscolaRank.DUE);
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
        assertEquals(4, briscolaDeck.getSize());
        Card removedCard = briscolaDeck.removeCard();
        assertEquals(3, briscolaDeck.getSize());
        assertEquals(-1, briscolaDeck.searchCard(removedCard));
    }

    @Test
    void playCardTest() {
        List<Player> players = getPlayers();
        BriscolaDeck briscolaDeck = BriscolaDeck.empty();
        Card card1 = new Asso(BriscolaSeed.BASTONI);
        Card card2 = new Fante(BriscolaSeed.DENARI);
        briscolaDeck.playCard(players.get(0).getId(), card1);
        briscolaDeck.playCard(players.get(1).getId(), card2);
        assertEquals(card1, briscolaDeck.getPlayer1ThrowingCard());
        assertEquals(card2, briscolaDeck.getPlayer2ThrowingCard());
    }

    private BriscolaDeck getSimpleDeck() {
        BriscolaDeck deck = BriscolaDeck.empty();
        deck.insertCard(new Asso(BriscolaSeed.BASTONI));
        deck.insertCard(new Liscio(BriscolaSeed.COPPE, BriscolaRank.DUE));
        deck.insertCard(new Cavallo(BriscolaSeed.SPADE));
        deck.insertCard(new Fante(BriscolaSeed.DENARI));
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
