package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.BriscolaDeck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.DefaultPlayer;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Player;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.BriscolaRank;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.BriscolaSeed;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.briscola.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GameControllerTest {
    private final BriscolaDeck tableDeck;

    public GameControllerTest() {
        this.tableDeck = BriscolaDeck.empty();
    }

    @Test
    void gameControllerCreationTest() {
        GameController gameController = new GameController(getPlayers());
        assertNotNull(gameController);
    }

    @Test
    void createDeckTest() {
        initTableDeck();
        assertEquals(40, tableDeck.getSize());
    }

    private List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        Player player1 = new DefaultPlayer(0, "Davide");
        Player player2 = new DefaultPlayer(1, "Riccardo");
        players.add(player1);
        players.add(player2);
        return players;
    }

    private void initTableDeck() {
        for (int i = 0; i < 4; i++) {
            tableDeck.insertCard(new Asso(BriscolaSeed.values()[i]));
            tableDeck.insertCard(new Tre(BriscolaSeed.values()[i]));
            tableDeck.insertCard(new Fante(BriscolaSeed.values()[i]));
            tableDeck.insertCard(new Cavallo(BriscolaSeed.values()[i]));
            tableDeck.insertCard(new Re(BriscolaSeed.values()[i]));

            tableDeck.insertCard(new Liscio(BriscolaSeed.values()[i], BriscolaRank.DUE));
            tableDeck.insertCard(new Liscio(BriscolaSeed.values()[i], BriscolaRank.QUATTRO));
            tableDeck.insertCard(new Liscio(BriscolaSeed.values()[i], BriscolaRank.CINQUE));
            tableDeck.insertCard(new Liscio(BriscolaSeed.values()[i], BriscolaRank.SEI));
            tableDeck.insertCard(new Liscio(BriscolaSeed.values()[i], BriscolaRank.SETTE));
        }
        tableDeck.randomizeDeck();
    }
}
