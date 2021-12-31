package it.unicam.cs.pa.davidemonnati.cardgame.view;

import it.unicam.cs.pa.davidemonnati.cardgame.model.Hand;
import it.unicam.cs.pa.davidemonnati.cardgame.model.Player;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleView implements View {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public ConsoleView() {
    }

    public void open() {
        sayHello();
    }

    private void sayHello() {
        System.out.println("****************************************************");
        System.out.println("**                                                **");
        System.out.println("**                  CARD GAME                     **");
        System.out.println("**                                                **");
        System.out.println("****************************************************");
        System.out.println();
    }

    public int updateState(Hand hand, Player player) throws IOException, NumberFormatException {
        printPlayerInfo(player);
        return selectCardToPlay(hand);
    }

    @Override
    public void close(List<Player> players, Integer winnerID) {
        System.out.println();
        System.out.println("La partita è terminata!");
        System.out.println("Il vincitore è: " + players.get(winnerID).getUsername());
        System.out.println();
        System.out.println("=============PUNTEGGI GIOCATORI=============");
        players.forEach(player -> System.out.println("Punteggio " + player.getUsername() + ": " + player.getScore()));
        System.out.println("============================================");
    }

    private Integer selectCardToPlay(Hand hand) throws IOException, NumberFormatException {
        List<Card> cards = hand.getCards();
        for (int i = 0; i < cards.size(); i++) {
            System.out.println((i + 1) + " - " + cards.get(i).getRank() + " " + cards.get(i).getSeed());
        }
        System.out.print("Seleziona la carta che si vuole giocare: ");
        Integer selected = (Integer.parseInt(br.readLine()) - 1);
        clearScreen();
        return selected;
    }

    private void printPlayerInfo(Player player) {
        System.out.println("E' il turno di: " + player.getUsername());
        System.out.println("Punteggio: " + player.getScore());
        System.out.println();
    }

    private void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
