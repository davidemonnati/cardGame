package it.unicam.cs.pa.davidemonnati.cardgame.model;

public class InteractivePlayer implements Player {
    private final int id;
    private final String username;
    private int score;

    public InteractivePlayer(int id, String name) {
        this.id = id;
        this.username = name;
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
