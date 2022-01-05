package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatusTest {
    private Status status;

    @BeforeEach
    void creationStatusTest() {
        status = Status.getInstance();
        assertNotNull(status);
        assertTrue(status.isStatus());
    }

    @Test
    void changeStatusTest() {
        assertTrue(status.isStatus());
        status.changeStatus();
        assertFalse(status.isStatus());
    }
}
