package it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.BriscolaRank;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.BriscolaSeed;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;

public class Tre extends Card {
    public Tre(BriscolaSeed seed) {
        super(seed, BriscolaRank.TRE, 10);
    }
}
