package it.unicam.cs.pa.davidemonnati.cardgame.model.player;

import it.unicam.cs.pa.davidemonnati.cardgame.model.Hand;

import java.util.Random;

/**
 * Rappresenta un {@link Player} di tipo random, ovvero un giocatore gestito dal computer.
 */
public class RandomPlayer extends Player {
    public RandomPlayer(Integer id, String name) {
        super(id, name);
    }

    /**
     * Metodo che permette al bot di selezionare automaticamente la carta da giocare.
     *
     * @param hand il mazzo di carte del giocatore
     * @return la posizione della carta da giocare scelta in base all'algoritmo
     */
    public int selectCard(Hand hand) {
        Random random = new Random();
        return random.nextInt(((hand.getSize() - 1)) + 1);
    }
}
