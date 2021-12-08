package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.BriscolaDeck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.PlayerDeck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TableDeckTest {

    @Test
    void creationTableDeckTest() {
        PlayerDeck deck = BriscolaDeck.empty();
        assertNotNull(deck);
    }
}
