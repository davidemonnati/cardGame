package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.player.InteractivePlayer;
import it.unicam.cs.pa.davidemonnati.cardgame.model.player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest {
    @Test
    void playerCreationTest() {
        Player davide = new InteractivePlayer(0, "Davide");
        assertNotNull(davide);
        assertEquals(0, davide.getId());
        assertEquals("Davide", davide.getUsername());
    }

    @Test
    void scoreTest() {
        Player davide = new InteractivePlayer(0, "Davide");
        davide.setScore(10);
        assertEquals(10, davide.getScore());
        davide.setScore(5);
        assertEquals(15, davide.getScore());
    }
}
