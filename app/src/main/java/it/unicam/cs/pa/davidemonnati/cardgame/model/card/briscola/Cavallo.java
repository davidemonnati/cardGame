package it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.BriscolaRank;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.BriscolaSeed;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;

public class Cavallo extends Card {
    public Cavallo(BriscolaSeed seed) {
        super(seed, BriscolaRank.CAVALLO, 3);
    }
}
