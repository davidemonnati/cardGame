package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.exception.IllegalCardPositionException;
import it.unicam.cs.pa.davidemonnati.cardgame.model.DefaultHand;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Hand;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Player;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Status;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;
import it.unicam.cs.pa.davidemonnati.cardgame.model.table.Table;
import it.unicam.cs.pa.davidemonnati.cardgame.view.ConsoleView;
import it.unicam.cs.pa.davidemonnati.cardgame.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameController implements Game {
    private final Status status;
    private final List<Player> players;
    private final Table table;
    private List<Hand> hands;
    private int currentPlayer;
    private final View view;

    public GameController(List<Player> players, Table table) {
        this.status = new Status();
        this.players = players;
        this.table = table;
        initHands();
        this.currentPlayer = 0;
        this.view = new ConsoleView();
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
