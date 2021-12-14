package it.unicam.cs.pa.davidemonnati.cardgame.model;

public class DefaultPlayer implements Player {
    private final int id;
    private final String username;
    private PlayerDeck playerDeck;
    private int score;

    public DefaultPlayer(int id, String name) {
        this.id = id;
        this.username = name;
        this.playerDeck = PlayerDeck.empty();
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public PlayerDeck getPlayerDeck() {
        return playerDeck;
    }

    @Override
    public int getPlayerDeckSize() {
        return playerDeck.getSize();
    }

    @Override
    public void setPlayerDeck(PlayerDeck playerDeck) {
        this.playerDeck = playerDeck;
    }

    @Override
    public void setScore(int score) {
        this.score += score;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void resetScore() {
        score = 0;
    }
}
