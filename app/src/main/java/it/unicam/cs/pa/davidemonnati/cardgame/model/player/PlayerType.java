package it.unicam.cs.pa.davidemonnati.cardgame.model.player;

import it.unicam.cs.pa.davidemonnati.cardgame.exception.UnknownPlayerTypeException;

/**
 * Enum in cui sono contenuti tutti i tipi di giocatori. <br />
 * I giocatori possono essere principalmente di due tipi:
 * <ul>
 *     <li><b>Interactive</b>: quando è il giocatore è un essere umano</li>
 *     <li><b>Random</b>: quando il giocatore è un bot</li>
 * </ul>
 */
public enum PlayerType {
    INTERACTIVE, RANDOM;

    /**
     * Ritorna una nuova istanza di {@link Player}.
     *
     * @param id       che si vuole associare al {@link Player}
     * @param username da assegnare al {@link Player}
     * @return nuova istanza di {@link Player} creata in base ai parametri che sono stati passati al metodo
     * @throws UnknownPlayerTypeException se viene utilizzato un {@link Player} che non esiste nell'enum
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
