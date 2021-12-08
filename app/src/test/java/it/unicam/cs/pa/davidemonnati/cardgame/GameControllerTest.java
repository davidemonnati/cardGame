package it.unicam.cs.pa.davidemonnati.cardgame;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameControllerTest {
    @Test
    void createCardsGame() {
        GameController cardsGame = new GameController();
        assertNotNull(cardsGame);
    }
}
