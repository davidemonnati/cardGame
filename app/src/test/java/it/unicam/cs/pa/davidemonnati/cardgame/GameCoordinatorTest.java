package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameCoordinatorTest {
    @Test
    void createCardsGameTest() {
        Player player1 = getPlayers().get(0);
        Player player2 = getPlayers().get(1);
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
        Player player1 = getPlayers().get(0);
        Player player2 = getPlayers().get(1);
        player1.setPlayerDeck(getSamplePlayerDeck());
        assertEquals(player1.getPlayerDeck().getCards().size(), 3);
        Card cardToPlay = player1.getPlayerDeck().getCards().get(pos);
        throwCard(player1, pos);
        assertEquals(player1.getPlayerDeck().getCards().size(), 2);
        assertEquals(player1.getPlayerDeck().getCards().search(cardToPlay), -1);
    }

    @Test
    void gameRuleTest() {
        GameController gameController = new GameController();
        List<Player> players = getPlayers();
        players.get(0).setPlayerDeck(getSamplePlayerDeck());
        players.get(1).setPlayerDeck(getSamplePlayerDeck());
        gameController.playCard(players.get(0), 0);
        gameController.playCard(players.get(1), 2);
        rule(gameController, players);

        assertEquals(players.get(0).getScore(), 0);
        assertEquals(players.get(1).getScore(), 5);
    }

    private int opponentPlayer(int i) {
        return (i + 1) % 2;
    }

    private List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        Player player1 = new DefaultPlayer(0, "Davide");
        Player player2 = new DefaultPlayer(1, "Riccardo");
        players.add(player1);
        players.add(player2);
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

    private void rule(GameController gameController, List<Player> players) {
        Card player1ThrowedCard = gameController.getBriscolaDeck().getPlayer1ThrowingCard();
        Card player2ThrowedCard = gameController.getBriscolaDeck().getPlayer2ThrowingCard();
        int scoreCard1 = player1ThrowedCard.getRankValue().getScore();
        int scoreCard2 = player2ThrowedCard.getRankValue().getScore();
        if (scoreCard1 > scoreCard2) {
            players.get(0).setScore(scoreCard1 + scoreCard2);
        } else {
            players.get(1).setScore(scoreCard1 + scoreCard2);
        }
        gameController.getBriscolaDeck().initThrowingCards();
    }
}
