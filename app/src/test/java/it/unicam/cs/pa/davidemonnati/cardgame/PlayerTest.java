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
        assertEquals(0, davide.getId());
        assertEquals("Davide", davide.getUsername());
    }

    @Test
    void scoreTest() {
        DefaultPlayer davide = new DefaultPlayer(0, "Davide");
        davide.setScore(10);
        assertEquals(10, davide.getScore());
        davide.setScore(5);
        assertEquals(15, davide.getScore());
        davide.resetScore();
        assertEquals(0, davide.getScore());
    }
}
