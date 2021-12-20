package it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;

public class Asso extends Card {
    public Asso(BriscolaSeed seed) {
        super(seed, BriscolaRank.ASSO, 11);
    }
}
