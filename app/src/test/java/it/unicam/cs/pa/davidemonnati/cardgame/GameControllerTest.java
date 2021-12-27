package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.exception.IllegalCardPositionException;
import it.unicam.cs.pa.davidemonnati.cardgame.model.InteractivePlayer;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Player;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.*;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.DefaultTableDeck;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GameControllerTest {
    private final DefaultTableDeck tableDeck;

    public GameControllerTest() {
        this.tableDeck = DefaultTableDeck.empty();
    }

    @Test
    void gameControllerCreationTest() {
        Game gameController = new GameController(getPlayers());
        assertNotNull(gameController);
    }

    @Test
    void createDeckTest() {
        initTableDeck();
        assertEquals(40, tableDeck.getSize());
    }

    @Test
    void IllegalCardPositionTest() {
        Exception illegalCardPositionTest = new IllegalCardPositionException();
        String expectedMessage = "ERRORE: La carta che hai selezionato non è presente nella mano";
        assertTrue(illegalCardPositionTest.getMessage().contains(expectedMessage));
    }

    private List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        Player player1 = new InteractivePlayer(0, "Davide");
        Player player2 = new InteractivePlayer(1, "Riccardo");
        players.add(player1);
        players.add(player2);
        return players;
    }

    private void initTableDeck() {
        for (int i = 0; i < 4; i++) {
            tableDeck.insert(new Asso(NeapolitanSeed.values()[i]));
            tableDeck.insert(new Tre(NeapolitanSeed.values()[i]));
            tableDeck.insert(new Fante(NeapolitanSeed.values()[i]));
            tableDeck.insert(new Cavallo(NeapolitanSeed.values()[i]));
            tableDeck.insert(new Re(NeapolitanSeed.values()[i]));

            tableDeck.insert(new Liscio(NeapolitanSeed.values()[i], NeapolitanRank.DUE));
            tableDeck.insert(new Liscio(NeapolitanSeed.values()[i], NeapolitanRank.QUATTRO));
            tableDeck.insert(new Liscio(NeapolitanSeed.values()[i], NeapolitanRank.CINQUE));
            tableDeck.insert(new Liscio(NeapolitanSeed.values()[i], NeapolitanRank.SEI));
            tableDeck.insert(new Liscio(NeapolitanSeed.values()[i], NeapolitanRank.SETTE));
        }
        tableDeck.randomizeDeck();
    }
}
