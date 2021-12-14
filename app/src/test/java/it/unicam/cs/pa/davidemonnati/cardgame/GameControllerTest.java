package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.DefaultPlayer;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Player;
import it.unicam.cs.pa.davidemonnati.cardgame.model.PlayerDeck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class GameControllerTest {
    // Player player1 = new DefaultPlayer(0, "davide");
    // Player player2 = new DefaultPlayer(1, "riccardo");

    @Test
    void initDeckTest() {
        GameController briscolaCoordinator = new GameController();
        PlayerDeck deck = briscolaCoordinator.getBriscolaDeck();
        assertTrue(deck instanceof PlayerDeck);
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
