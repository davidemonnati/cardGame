package it.unicam.cs.pa.davidemonnati.cardgame.model;

public interface Player {
    String getUsername();

    int getId();

    PlayerDeck getPlayerDeck();

    void setPlayerDeck(PlayerDeck playerDeck);

    void setScore(int score);

    int getScore();

    void resetScore();
}
