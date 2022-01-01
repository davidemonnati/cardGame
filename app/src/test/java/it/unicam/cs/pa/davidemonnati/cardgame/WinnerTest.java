package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.player.InteractivePlayer;
import it.unicam.cs.pa.davidemonnati.cardgame.model.player.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinnerTest {
    @Test
    void winnerPlayerTest() {
        List<Player> players = getPlayers();
        DefaultWinner defaultWinner = new DefaultWinner();
        Integer idWinner = defaultWinner.check().apply(players);
        assertEquals(1, idWinner);
    }

    private List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        Player player1 = new InteractivePlayer(0, "Davide");
        Player player2 = new InteractivePlayer(1, "Riccardo");
        player1.setScore(34);
        player2.setScore(65);
        players.add(player1);
        players.add(player2);
        return players;
    }
}
