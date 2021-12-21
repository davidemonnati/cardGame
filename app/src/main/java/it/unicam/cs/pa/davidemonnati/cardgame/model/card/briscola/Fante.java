package it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;

public class Fante extends Card {
    public Fante(BriscolaSeed seed) {
        super(seed, BriscolaRank.FANTE, 2);
    }
}
