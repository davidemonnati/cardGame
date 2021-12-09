package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.DefaultPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest {

    @Test
    void playerCreationTest() {
        DefaultPlayer davide = new DefaultPlayer(0, "Davide");
        assertNotNull(davide);
        assertEquals(davide.getId(), 0);
        assertEquals(davide.getUsername(), "Davide");
    }

    @Test
    void scoreTest() {
        DefaultPlayer davide = new DefaultPlayer(0, "Davide");
        davide.setScore(10);
        assertEquals(davide.getScore(), 10);
        davide.setScore(5);
        assertEquals(davide.getScore(), 15);
        davide.resetScore();
        assertEquals(davide.getScore(), 0);
    }
}
