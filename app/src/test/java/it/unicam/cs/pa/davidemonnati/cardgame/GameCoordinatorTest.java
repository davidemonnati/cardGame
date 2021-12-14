package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameCoordinatorTest {
    @Test
    void createCardsGameTest() {
        //Player player1 = new DefaultPlayer(0, "Davide");
        //Player player2 = new DefaultPlayer(1, "Riccardo");
        Player player1 = getPlayers()[0];
        Player player2 = getPlayers()[1];
        GameCoordinator cardsGame = new GameCoordinator(player1, player2);
        assertNotNull(cardsGame);
    }

    @Test
    void opponentPlayerTest() {
        int i = 0;
        i = opponentPlayer(i);
        assertEquals(i, 1);
        i = opponentPlayer(i);
        assertEquals(i, 0);
    }

    @Test
    void throwingCardTest() {
        int pos = 1;
        Player player1 = getPlayers()[0];
        Player player2 = getPlayers()[1];
        player1.setPlayerDeck(getSamplePlayerDeck());
        assertEquals(player1.getPlayerDeck().getCards().size(), 3);
        Card cardToPlay = player1.getPlayerDeck().getCards().get(pos);
        throwCard(player1, pos);
        assertEquals(player1.getPlayerDeck().getCards().size(), 2);
        assertEquals(player1.getPlayerDeck().getCards().search(cardToPlay), -1);
    }

    private int opponentPlayer(int i) {
        return (i + 1) % 2;
    }

    private Player[] getPlayers() {
        Player player1 = new DefaultPlayer(0, "Davide");
        Player player2 = new DefaultPlayer(1, "Riccardo");
        Player[] players = new Player[]{player1, player2};
        return players;
    }

    private PlayerDeck getSamplePlayerDeck() {
        PlayerDeck playerDeck = PlayerDeck.empty();
        Card carta1 = new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.DENARI, CarteBriscola.Rank.FANTE);
        Card carta2 = new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.COPPE, CarteBriscola.Rank.A);
        Card carta3 = new CarteBriscola(CarteBriscola.Color.BLACK, CarteBriscola.Seed.BASTONI, CarteBriscola.Rank.CAVALLO);
        playerDeck.insertCard(carta1);
        playerDeck.insertCard(carta2);
        playerDeck.insertCard(carta3);
        return playerDeck;
    }

    private void throwCard(Player player, Integer pos) {
        GameController gameController = new GameController();
        gameController.playCard(player, pos);
    }
}
