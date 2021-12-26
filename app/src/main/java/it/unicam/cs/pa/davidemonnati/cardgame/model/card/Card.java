package it.unicam.cs.pa.davidemonnati.cardgame.model.card;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.napolitan.NapolitanRank;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.napolitan.NapolitanSeed;

import java.util.Objects;

public abstract class Card {
    private final NapolitanSeed seed;
    private final NapolitanRank rank;
    private final int score;

    public Card(NapolitanSeed seed, NapolitanRank rank, int score) {
        this.seed = seed;
        this.rank = rank;
        this.score = score;
    }

    public NapolitanSeed getSeed() {
        return seed;
    }

    public int getScore() {
        return score;
    }

    public NapolitanRank getRank() {
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
