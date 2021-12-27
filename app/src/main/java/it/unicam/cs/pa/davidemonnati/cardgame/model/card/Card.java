package it.unicam.cs.pa.davidemonnati.cardgame.model.card;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.NeapolitanRank;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.NeapolitanSeed;

import java.util.Objects;

public abstract class Card {
    private final NeapolitanSeed seed;
    private final NeapolitanRank rank;
    private final int score;

    public Card(NeapolitanSeed seed, NeapolitanRank rank, int score) {
        this.seed = seed;
        this.rank = rank;
        this.score = score;
    }

    public NeapolitanSeed getSeed() {
        return seed;
    }

    public int getScore() {
        return score;
    }

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
