package it.unicam.cs.pa.davidemonnati.cardgame.model;

public class Status {
    private boolean status;

    public Status() {
        this.status = true;
    }

    public boolean isStatus() {
        return status;
    }

    public void changeStatus() {
        this.status = !status;
    }
}
