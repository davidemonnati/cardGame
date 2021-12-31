package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.Player;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Regola di default dove il vincitore è colui che ha totalizzato il punteggio maggiore.
 */
public class DefaultWinner implements Winner {
    @Override
    public Function<List<Player>, Integer> check() {
        return players -> players.stream()
                .filter(player -> player.getScore().equals(
                        players.stream()
                                .mapToInt(Player::getScore)
                                .max().orElseThrow(NullPointerException::new))
                )
                .collect(Collectors.toList()).get(0).getId();
    }
}
