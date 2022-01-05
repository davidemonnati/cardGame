/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package it.unicam.cs.pa.davidemonnati.cardgame;

import it.unicam.cs.pa.davidemonnati.cardgame.controller.Game;
import it.unicam.cs.pa.davidemonnati.cardgame.controller.Turn;
import it.unicam.cs.pa.davidemonnati.cardgame.controller.GamesList;
import it.unicam.cs.pa.davidemonnati.cardgame.exception.BadUsernameFormatException;
import it.unicam.cs.pa.davidemonnati.cardgame.exception.UnknownGameException;
import it.unicam.cs.pa.davidemonnati.cardgame.exception.UnknownPlayerTypeException;
import it.unicam.cs.pa.davidemonnati.cardgame.model.player.Player;
import it.unicam.cs.pa.davidemonnati.cardgame.model.player.PlayerType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class App {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final Game game;

    public App(Game game) {
        this.game = game;
    }

    public void start() throws Exception {
        game.play();
    }

    public static void main(String[] args) {
        try {
            createGame().start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static App createGame() throws IOException, BadUsernameFormatException, UnknownPlayerTypeException {
        Turn turn = new Turn(createPlayers());
        int selectedGame = selectGame();
        return new App(GamesList.values()[selectedGame].getGame(turn));
    }

    /**
     * Consente di creare giocatori per giocare a carte.
     * Il metodo permette all'utente di inserire l'username che vuole dare ad ogni giocatore creato e di scegliere il
     * tipo di {@link Player} richiamando il metodo <i>selectPlayerType()</i>.
     *
     * @return Lista dei giocatori creata
     * @throws IOException                Errori di I/O
     * @throws BadUsernameFormatException Eccezione che viene lanciata quando il numero dei caratteri
     *                                    che formano l'username è troppo elevata, il massimo è di 15 caratteri
     * @throws UnknownPlayerTypeException Eccezione che viene lanciata quando il tipo di player scelto non è corretto
     */
    private static List<Player> createPlayers() throws IOException, BadUsernameFormatException, UnknownPlayerTypeException {
        List<Player> players = new ArrayList<>();
        System.out.println();
        for (int i = 0; i < 2; i++) {
            System.out.println("Creazione player " + (i + 1) + ": ");
            System.out.print("Inserisci username: ");
            String username = br.readLine();
            if (username.length() > 15)
                throw new BadUsernameFormatException();
            players.add(PlayerType.valueOf(selectPlayerType()).getPlayer(i, username));
            System.out.println("\n");
        }
        return players;
    }

    /**
     * Consente all'utente di scegliere quale tipo di giocatore vuole creare.
     *
     * @return tipo di giocatore scelto dall'utente in formato <i>String</i>
     * @throws IOException errori di I/O
     * @see PlayerType
     */
    private static String selectPlayerType() throws IOException {
        System.out.print("Seleziona il tipo di giocatore (Interactive/Random): ");
        return br.readLine().toUpperCase(Locale.ROOT);
    }

    /**
     * Consente al giocatore di scegliere a quale gioco di carte giocare.
     *
     * @return intero che rappresenta la posizione del gioco nel menù
     * @throws IOException errori di I/0
     * @see GamesList
     */
    private static int selectGame() throws IOException {
        System.out.println("Lista giochi:");
        System.out.println("1 - Gioco default");
        System.out.println("2 - Briscola");
        System.out.println();
        System.out.print("Seleziona il gioco a cui vuoi giocare: ");
        int selected = Integer.parseInt(br.readLine());
        if (selected > GamesList.values().length || selected < 1)
            throw new UnknownGameException();
        return (selected - 1);
    }
}
