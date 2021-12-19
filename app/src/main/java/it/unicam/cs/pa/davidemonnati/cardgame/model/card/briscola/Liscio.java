package it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.BriscolaRank;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.BriscolaSeed;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;

public class Liscio extends Card {
    public Liscio(BriscolaSeed seed, BriscolaRank rank) {
        super(seed, rank, 0);
    }
}
