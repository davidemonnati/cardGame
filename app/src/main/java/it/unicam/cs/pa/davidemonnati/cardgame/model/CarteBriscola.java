package it.unicam.cs.pa.davidemonnati.cardgame.model;

public class CarteBriscola implements Card {
    public enum Seed {
        DENARI, SPADE, COPPE, BASTONI
    }

    public enum Rank {
        A, DUE, TRE, QUATTRO, CINQUE, SEI, SETTE, FANTE, CAVALLO, RE;

        public int getScore() {
            switch (this) {
                case A:
                    return 11;
                case TRE:
                    return 10;
                case RE:
                    return 4;
                case CAVALLO:
                    return 3;
                case FANTE:
                    return 2;
            }
            return 0;
        }
    }

    public enum Color {
        BLACK
    }

    private final Color color;
    private final Seed seed;
    private final Rank rank;

    public CarteBriscola(Color color, Seed seed, Rank rank) {
        this.color = color;
        this.seed = seed;
        this.rank = rank;
    }

    public CarteBriscola(Seed seed, Rank rank) {
        this(Color.BLACK, seed, rank);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Seed getSeedValue() {
        return seed;
    }

    @Override
    public Rank getRankValue() {
        return rank;
    }

    @Override
    public int getCardScore() {
        return rank.getScore();
    }
}
