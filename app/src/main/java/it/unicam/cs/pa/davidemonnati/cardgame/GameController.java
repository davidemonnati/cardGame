package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.*;

public class GameController {
    private final BriscolaDeck tableDeck;

    public GameController() {
        this.tableDeck = BriscolaDeck.empty();
        initDeck();
    }

    public BriscolaDeck getBriscolaDeck() {
        return tableDeck;
    }

    public Player takeMultipleCards(Integer num, Player player) {
        for (int i = 0; i < num; i++) {
            player = takeCard(player);
        }
        return player;
    }

    public Player takeCard(Player player) {
        if (getDeckSize() > 0) {
            PlayerDeck deck = player.getPlayerDeck();
            deck.insertCard(tableDeck.removeCard());
            player.setPlayerDeck(deck);
        }
        return player;
    }

    public void playCard(Player player, Integer pos) {
        PlayerDeck playerDeck = player.getPlayerDeck();
        Card toPlay = playerDeck.removeCard(pos);
        tableDeck.playCard(player.getId(), toPlay);
        player.setPlayerDeck(playerDeck);
    }

    private void initDeck() {
        for (int i = 0; i < 4; i++) {
            tableDeck.insertCard(new CarteBriscola(CarteBriscola.Seed.values()[i], CarteBriscola.Rank.A));

            for (int j = 1; j < 10; j++) {
                tableDeck.insertCard(new CarteBriscola(CarteBriscola.Seed.values()[i], CarteBriscola.Rank.values()[j]));
            }
        }
        tableDeck.randomizeDeck();
    }

    public void setAsso() {
        if (getDeckSize() > 0)
            tableDeck.setAsso();
    }

    public Card getAsso() {
        return tableDeck.getAsso();
    }

    public int getDeckSize() {
        return tableDeck.getSize();
    }
}
