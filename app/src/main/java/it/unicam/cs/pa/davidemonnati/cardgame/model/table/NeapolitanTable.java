package it.unicam.cs.pa.davidemonnati.cardgame.model.table;

import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.*;

/**
 * Rappresenta il tavolo per giocare con le carte napoletane.
 */
public class NeapolitanTable extends Table {
    public NeapolitanTable() {
        initDeck();
    }

    /**
     * Inizializza il mazzo con tutte le carte da gioco napoletane.
     */
    private void initDeck() {
        for (int i = 0; i < 4; i++) {
            tableDeck.insert(new Asso(NeapolitanSeed.values()[i]));
            tableDeck.insert(new Tre(NeapolitanSeed.values()[i]));
            tableDeck.insert(new Fante(NeapolitanSeed.values()[i]));
            tableDeck.insert(new Cavallo(NeapolitanSeed.values()[i]));
            tableDeck.insert(new Re(NeapolitanSeed.values()[i]));

            tableDeck.insert(new Liscio(NeapolitanSeed.values()[i], NeapolitanRank.DUE));
            tableDeck.insert(new Liscio(NeapolitanSeed.values()[i], NeapolitanRank.QUATTRO));
            tableDeck.insert(new Liscio(NeapolitanSeed.values()[i], NeapolitanRank.CINQUE));
            tableDeck.insert(new Liscio(NeapolitanSeed.values()[i], NeapolitanRank.SEI));
            tableDeck.insert(new Liscio(NeapolitanSeed.values()[i], NeapolitanRank.SETTE));
        }
        tableDeck.randomizeDeck();
    }
}
