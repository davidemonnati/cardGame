package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.DefaultPlayer;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Player;
import it.unicam.cs.pa.davidemonnati.cardgame.model.PlayerDeck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class GameControllerTest {
    @Test
    void initDeckTest() {
        GameController briscolaCoordinator = new GameController();
        PlayerDeck deck = briscolaCoordinator.getBriscolaDeck();
        assertEquals(deck.getSize(), 40);
    }

    @Test
    void setAssoTest() {
        GameController gameCoordinator = new GameController();
        Card actual = gameCoordinator.getBriscolaDeck().getCards().get(39);
        gameCoordinator.setAsso();
        assertEquals(gameCoordinator.getBriscolaDeck().getAsso(), actual);
    }

    @Test
    void takeCardEmptyDeckTest() {
        Player player = getPlayer();
        GameController gameCoordinator = new GameController();
        for (int i = 0; i <= 39; i++) { // svuoto il mazzo nel tavolo
            gameCoordinator.takeCard(player);
        }
        assertEquals(gameCoordinator.getDeckSize(), 0);
        gameCoordinator.setAsso();
        assertNull(gameCoordinator.getAsso());
    }

    @Test
    void takeCardTest() { // carta che viene presa dal giocatore
        Player player = getPlayer();
        GameController gameCoordinator = new GameController();
        gameCoordinator.setAsso();
        Card actual = gameCoordinator.getBriscolaDeck().getCards().get(38);
        player = gameCoordinator.takeCard(player);
        assertTrue(player.getPlayerDeck().getCards().search(actual) >= 0);
        assertEquals(gameCoordinator.getBriscolaDeck().getCards().size(), 38);
    }

    @Test
    void takeMultipleCardsTest() {
        int cards = 3;
        Player player = getPlayer();
        GameController gameCoordinator = new GameController();
        player = gameCoordinator.takeMultipleCards(cards, player);
        assertEquals(player.getPlayerDeck().getCards().size(), cards);
    }

    @Test
    void playCardTest() {
        Player player = getPlayer();
        GameController gameCoordinator = new GameController();
        gameCoordinator.takeMultipleCards(3, player);
        Card cardToPlay = player.getPlayerDeck().getCards().get(2);
        gameCoordinator.playCard(player, 2);
        assertEquals(player.getPlayerDeck().getCards().search(cardToPlay), -1);
        assertEquals(gameCoordinator.getBriscolaDeck().getPlayer1ThrowingCard(), cardToPlay);
    }

    private Player getPlayer() {
        return new DefaultPlayer(0, "Davide");
    }
}
