package it.unicam.cs.pa.davidemonnati.cardgame.model;

public interface Card {
    CarteBriscola.Color getColor();

    CarteBriscola.Seed getSeedValue();

    CarteBriscola.Rank getRankValue();
}
