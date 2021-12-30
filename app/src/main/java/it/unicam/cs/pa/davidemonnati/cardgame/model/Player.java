package it.unicam.cs.pa.davidemonnati.cardgame.model;

public interface Player {
    String getUsername();

    Integer getId();

    void setScore(int score);

    Integer getScore();

    void resetScore();
}
