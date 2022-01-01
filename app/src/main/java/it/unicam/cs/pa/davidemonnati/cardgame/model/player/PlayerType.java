package it.unicam.cs.pa.davidemonnati.cardgame.model.player;

import it.unicam.cs.pa.davidemonnati.cardgame.exception.UnknownPlayerTypeException;

/**
 * Enum in cui sono contenuti tutti i tipi di giocatori.
 */
public enum PlayerType {
    INTERACTIVE, RANDOM;

    /**
     * Serve per la creazione di un {@link Player}
     *
     * @param id       che si vuole associare al {@link Player}
     * @param username da assegnare al {@link Player}
     * @return un nuovo giocatore creato in base ai parametri che sono stati passati al metodo
     */
    public Player getPlayer(int id, String username) throws UnknownPlayerTypeException {
        switch (this) {
            case INTERACTIVE:
                return new InteractivePlayer(id, username);
            case RANDOM:
                return new RandomPlayer(id, username);
            default:
                throw new UnknownPlayerTypeException();
        }
    }
}
