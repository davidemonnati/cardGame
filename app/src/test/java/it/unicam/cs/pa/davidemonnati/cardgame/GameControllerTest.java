package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.exception.IllegalCardPositionException;
import it.unicam.cs.pa.davidemonnati.cardgame.model.InteractivePlayer;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Player;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.NeapolitanTable;
import it.unicam.cs.pa.davidemonnati.cardgame.view.ConsoleView;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameControllerTest {
    @Test
    void gameControllerCreationTest() {
        NeapolitanTable table = new NeapolitanTable();
        Game gameController = new GameController<>(createTurn(), table, new DefaultRule().rule(),
                new ConsoleView());
        assertNotNull(gameController);
    }

    @Test
    void IllegalCardPositionTest() {
        Exception illegalCardPositionTest = new IllegalCardPositionException();
        String expectedMessage = "ERRORE: La carta che hai selezionato non è presente nella mano";
        assertTrue(illegalCardPositionTest.getMessage().contains(expectedMessage));
    }

    private GameTurn createTurn() {
        return new GameTurn(getPlayers());
    }

    private List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        Player player1 = new InteractivePlayer(0, "Davide");
        Player player2 = new InteractivePlayer(1, "Riccardo");
        players.add(player1);
        players.add(player2);
        return players;
    }
}
