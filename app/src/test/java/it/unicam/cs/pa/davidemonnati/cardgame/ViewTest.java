package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.exception.BadUsernameFormatException;
import it.unicam.cs.pa.davidemonnati.cardgame.view.ConsoleView;
import it.unicam.cs.pa.davidemonnati.cardgame.view.View;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ViewTest {
    @Test
    void creationViewTest() {
        View view = new ConsoleView();
        assertNotNull(view);
    }

    @Test
    void BadUsernameFormatExceptionTest() {
        Exception badUsernameFormatException = new BadUsernameFormatException();
        String expectedMessage = "ERRORE: l'username può contenere al massimo 15 caratteri.";
        assertTrue(badUsernameFormatException.getMessage().contains(expectedMessage));
    }
}
