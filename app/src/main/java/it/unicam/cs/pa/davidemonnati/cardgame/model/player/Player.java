package it.unicam.cs.pa.davidemonnati.cardgame.model.player;

/**
 * Classe astratta che rappresenta un giocatore, il quale può essere esteso per creare diversi
 * tipi di giocatori.
 */
public abstract class Player {
    /**
     * Identifica l'ID del giocatore
     */
    private final int id;
    private final String username;
    private int score = 0;

    public Player(Integer id, String name) {
        this.id = id;
        this.username = name;
    }

    /**
     * @return username del giocatore
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return id del giocatore
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param score punteggio da incrementare a quello esistente
     */
    public void setScore(int score) {
        this.score += score;
    }

    /**
     * @return punteggio del giocatore
     */
    public Integer getScore() {
        return score;
    }
}
