package it.unicam.cs.pa.davidemonnati.cardgame.model.player;

/**
 * Classe astratta che rappresenta un giocatore base. <br />
 * I giocatori possono essere estesi in modo da poter creare più tipi di giocatori diversi.
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
     * Incrementa il punteggio con un valore che vogliamo passare in input.
     *
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
