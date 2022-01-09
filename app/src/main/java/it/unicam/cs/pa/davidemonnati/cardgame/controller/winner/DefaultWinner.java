package it.unicam.cs.pa.davidemonnati.cardgame.controller.winner;

import it.unicam.cs.pa.davidemonnati.cardgame.model.player.Player;

import java.util.List;
import java.util.function.Function;

/**
 * Regola di default dove il vincitore è colui che ha totalizzato il punteggio maggiore.
 * @see Function
 */
public class DefaultWinner implements Winner {
    @Override
    public Function<List<Player>, Integer> check() {
        return players -> players.stream()
                .filter(player -> player.getScore().equals(
                        players.stream()
                                .mapToInt(Player::getScore)
                                .max().orElseThrow(NullPointerException::new))
                ).toList().get(0).getId();
    }
}
