package it.unicam.cs.pa.davidemonnati.cardgame.model.card;

public abstract class Card {
    private final BriscolaSeed seed;
    private final BriscolaRank rank;
    private final int score;

    public Card(BriscolaSeed seed, BriscolaRank rank, int score) {
        this.seed = seed;
        this.rank = rank;
        this.score = score;
    }

    public BriscolaSeed getSeed() {
        return seed;
    }

    public int getScore() {
        return score;
    }

    public BriscolaRank getRank() {
        return rank;
    }
}
