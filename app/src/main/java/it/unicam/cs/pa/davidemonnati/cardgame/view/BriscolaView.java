package it.unicam.cs.pa.davidemonnati.cardgame.view;

import it.unicam.cs.pa.davidemonnati.cardgame.model.player.Player;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.BriscolaTable;

/**
 * View che serve per giocare a briscola.
 * A differenza della {@link ConsoleView} in questo caso dobbiamo mostrare a schermo quale è il seme della briscola.
 */
public class BriscolaView extends ConsoleView {
    private final BriscolaTable briscolaTable;

    public BriscolaView(BriscolaTable briscolaTable) {
        this.briscolaTable = briscolaTable;
    }

    /**
     * Override del metodo <i>open</i> che stampa il nome del gioco a cui stiamo giocando.
     */
    @Override
    public void open() {
        System.out.println("****************************************************");
        System.out.println("**                                                **");
        System.out.println("**                BRISCOLA GAME                   **");
        System.out.println("**                                                **");
        System.out.println("****************************************************");
        System.out.println();
    }

    /**
     * Override del metodo <i>printInfo</i> che in questo caso deve stampare anche il seme della briscola.
     *
     * @param player giocatore del turno attuale.
     */
    @Override
    protected void printInfo(Player player) {
        System.out.println("Briscola: " + briscolaTable.getBriscolaSeed());
        System.out.println("E' il turno di: " + player.getUsername());
        System.out.println("Punteggio: " + player.getScore());
        System.out.println();
    }
}
