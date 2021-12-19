package it.unicam.cs.pa.davidemonnati.cardgame.model;

public interface Player {
    String getUsername();

    int getId();

    void setScore(int score);

    int getScore();

    void resetScore();
}
