package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.DefaultPlayer;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Player;
import it.unicam.cs.pa.davidemonnati.cardgame.model.PlayerDeck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GameCoordinatorTest {
    // Player player1 = new DefaultPlayer(0, "davide");
    // Player player2 = new DefaultPlayer(1, "riccardo");

    @Test
    void testInitDeck() {
        GameCoordinator briscolaCoordinator = new GameCoordinator();
        PlayerDeck deck = briscolaCoordinator.getBriscolaDeck();
        assertTrue(deck instanceof PlayerDeck);
        assertEquals(deck.getSize(), 40);
    }

    @Test
    void setAssoTest() {
        GameCoordinator gameCoordinator = new GameCoordinator();
        Card actual = gameCoordinator.getBriscolaDeck().getCards().get(39);
        gameCoordinator.setAsso();
        assertEquals(gameCoordinator.getBriscolaDeck().getAsso(), actual);
    }

    @Test
    void testTakeCard() { // carta che viene presa dal giocatore
        Player player = getPlayer();
        GameCoordinator gameCoordinator = new GameCoordinator();
        gameCoordinator.setAsso();
        Card actual = gameCoordinator.getBriscolaDeck().getCards().get(38);
        player = gameCoordinator.takeCard(player);
        assertTrue(player.getPlayerDeck().getCards().search(actual) >= 0);
        assertEquals(gameCoordinator.getBriscolaDeck().getCards().size(), 38);
    }

    @Test
    void testTakeMultipleCards() {
        int cards = 3;
        Player player = getPlayer();
        GameCoordinator gameCoordinator = new GameCoordinator();
        player = gameCoordinator.takeMultipleCards(cards, player);
        assertEquals(player.getPlayerDeck().getCards().size(), cards);
    }

    private Player getPlayer() {
        return new DefaultPlayer(0, "Davide");
    }
}
