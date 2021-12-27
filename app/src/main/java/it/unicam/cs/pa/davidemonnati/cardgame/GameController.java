package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.exception.IllegalCardPositionException;
import it.unicam.cs.pa.davidemonnati.cardgame.model.*;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.neapolitan.*;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.DefaultTableDeck;
import it.unicam.cs.pa.davidemonnati.cardgame.model.deck.TableDeck;
import it.unicam.cs.pa.davidemonnati.cardgame.view.ConsoleView;
import it.unicam.cs.pa.davidemonnati.cardgame.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameController implements Game {
    private final Status status;
    private final List<Player> players;
    private Table table;
    private List<Hand> hands;
    private int currentPlayer;
    private final View view;

    public GameController(List<Player> players) {
        this.status = new Status();
        this.players = players;
        initTableDeck();
        initHands();
        this.currentPlayer = 0;
        this.view = new ConsoleView();
    }

    private void initTableDeck() {
        TableDeck tableDeck = DefaultTableDeck.empty();
        for (int i = 0; i < 4; i++) {
            tableDeck.insert(new Asso(NeapolitanSeed.values()[i]));
            tableDeck.insert(new Tre(NeapolitanSeed.values()[i]));
            tableDeck.insert(new Fante(NeapolitanSeed.values()[i]));
            tableDeck.insert(new Cavallo(NeapolitanSeed.values()[i]));
            tableDeck.insert(new Re(NeapolitanSeed.values()[i]));

            tableDeck.insert(new Liscio(NeapolitanSeed.values()[i], NeapolitanRank.DUE));
            tableDeck.insert(new Liscio(NeapolitanSeed.values()[i], NeapolitanRank.QUATTRO));
            tableDeck.insert(new Liscio(NeapolitanSeed.values()[i], NeapolitanRank.CINQUE));
            tableDeck.insert(new Liscio(NeapolitanSeed.values()[i], NeapolitanRank.SEI));
            tableDeck.insert(new Liscio(NeapolitanSeed.values()[i], NeapolitanRank.SETTE));
        }
        tableDeck.randomizeDeck();
        this.table = new DefaultTable(tableDeck);
    }

    private void initHands() {
        this.hands = new ArrayList<>();
        hands.add(new DefaultHand());
        hands.add(new DefaultHand());
    }

    @Override
    public void play() throws IOException {
        view.open();
        takeFirstCards(3);
        while (status.isStatus()) {
            try {
                int cardToPlay = view.updateState(hands.get(currentPlayer), players.get(currentPlayer));
                doAction(cardToPlay);
            } catch (IOException | IllegalCardPositionException e) {
                System.out.println(e.getMessage());
                System.out.println("Premi un tasto per continuare");
                System.in.read();
            } catch (NumberFormatException e) {
                System.out.println("ERRORE: il valore che hai inserito non è corretto");
                System.out.println("Premi un tasto per continuare");
                System.in.read();
            }
        }
        view.close(players);
    }

    private void doAction(int numCardToPlay) throws IOException, IllegalCardPositionException {
        playCard(numCardToPlay);
        takeCard();
        rule();
        opponentPlayer();
        if (hands.get(currentPlayer).getSize() == 0) {
            status.changeStatus();
        }
    }

    private void takeCard() {
        if (table.tableDeckSize() > 0) {
            Card toTake = table.takeCardFromDeck();
            hands.get(currentPlayer).takeCard(toTake);
        }
    }

    private void takeFirstCards(Integer num) {
        for (int i = 0; i < num; i++) {
            takeCard();
        }
        opponentPlayer();
        for (int i = 0; i < num; i++) {
            takeCard();
        }
        opponentPlayer();
    }

    private void playCard(Integer pos) throws IllegalCardPositionException {
        if ((pos > (hands.get(currentPlayer).getSize() - 1)) || (pos < 0))
            throw new IllegalCardPositionException();
        Card toPlay = hands.get(currentPlayer).playCard(pos);
        table.playCard(currentPlayer, toPlay);
    }

    private void rule() {
        Card player1ThrowedCard = table.getPlayedCards()[0];
        int scoreCard1 = player1ThrowedCard.getScore();
        if (table.getPlayedCards()[1] != null) {
            Card player2ThrowedCard = table.getPlayedCards()[1];
            int scoreCard2 = player2ThrowedCard.getScore();
            if ((player1ThrowedCard.getScore() > player2ThrowedCard.getScore())
                    || (player1ThrowedCard.getScore() == player2ThrowedCard.getScore())) {
                players.get(0).setScore(scoreCard1 + scoreCard2);
                table.insertIntoPlayerDeck(0);
            } else {
                players.get(1).setScore(scoreCard1 + scoreCard2);
                table.insertIntoPlayerDeck(1);
            }
            table.resetPlayedCards();
        }
    }

    private void opponentPlayer() {
        this.currentPlayer = (currentPlayer + 1) % 2;
    }
}
