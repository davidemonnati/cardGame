package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.model.*;

public class GameCoordinator {
    private final BriscolaDeck tableDeck;

    public GameCoordinator() {
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
        PlayerDeck deck = player.getPlayerDeck();
        deck.insertCard(tableDeck.removeCard());
        player.setPlayerDeck(deck);
        return player;
    }

    /*public Player playCard(Player player, int i) {
        PlayerDeck playerDeck = player.getPlayerDeck();
        Card toPull = playerDeck.getCards().remove(i);

        return player;
    }*/

    private void initDeck() {
        for (int i = 0; i < 4; i++) {
            tableDeck.insertCard(new CarteBriscola(CarteBriscola.Seed.values()[i], CarteBriscola.Rank.A));

            for (int j = 1; j < 10; j++) {
                tableDeck.insertCard(new CarteBriscola(CarteBriscola.Seed.values()[i], CarteBriscola.Rank.values()[j]));
            }
        }
    }

    public void setAsso() {
        tableDeck.setAsso();
    }
}
