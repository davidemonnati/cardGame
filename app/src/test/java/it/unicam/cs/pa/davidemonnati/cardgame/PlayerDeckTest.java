package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.DefaultPlayerDeck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.PlayerDeck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerDeckTest {
    @Test
    void initPresaTest() {
        PlayerDeck playerDeck = new DefaultPlayerDeck();
        assertNotNull(playerDeck);
    }
}
