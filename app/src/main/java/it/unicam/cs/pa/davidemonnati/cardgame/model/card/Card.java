package it.unicam.cs.pa.davidemonnati.cardgame.model.card;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.NeapolitanRank;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.NeapolitanSeed;

import java.util.Objects;

/**
 * Rappresenta una singola carta da gioco.
 * Tutte le carte da gioco normalmente sono rappresentate dai seguenti valori:
 * <ul>
 *     <li>Seme</li>
 *     <li>Rango</li>
 * </ul>
 *
 * Per poter istanziare questa classe astratta è necessario estenderla.
 */
public abstract class Card {
    private final NeapolitanSeed seed;
    private final NeapolitanRank rank;
    private final int score;

    public Card(NeapolitanSeed seed, NeapolitanRank rank, int score) {
        this.seed = seed;
        this.rank = rank;
        this.score = score;
    }

    /**
     * @return seme della carta
     */
    public NeapolitanSeed getSeed() {
        return seed;
    }

    /**
     * @return punteggio della carta
     */
    public int getScore() {
        return score;
    }

    /**
     * @return rank della carta
     */
    public NeapolitanRank getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return score == card.score && seed == card.seed && rank == card.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seed, rank, score);
    }
}
