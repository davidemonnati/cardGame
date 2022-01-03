package it.unicam.cs.pa.davidemonnati.cardgame.model.table;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.NeapolitanSeed;

/**
 * Rappresenta un tavolo per giocare a Briscola
 */
public class BriscolaTable extends NeapolitanTable {
    private Card briscola;

    public BriscolaTable() {
        super();
        setBriscola();
    }

    /**
     * Imposta la variabile <i>briscola</i> con l'ultima carta nel mazzo.
     */
    private void setBriscola() {
        this.briscola = tableDeck.getCard(tableDeck.getSize() - 1);
    }

    /**
     * @return seme della briscola
     */
    public NeapolitanSeed getBriscolaSeed() {
        return briscola.getSeed();
    }
}
