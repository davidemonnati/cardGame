package it.unicam.cs.pa.davidemonnati.cardgame.view;

import it.unicam.cs.pa.davidemonnati.cardgame.model.Hand;
import it.unicam.cs.pa.davidemonnati.cardgame.model.player.InteractivePlayer;
import it.unicam.cs.pa.davidemonnati.cardgame.model.player.Player;
import it.unicam.cs.pa.davidemonnati.cardgame.model.player.RandomPlayer;
import it.unicam.cs.pa.davidemonnati.cardgame.model.card.Card;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Implementazione dell'interfaccia {@link View}
 */
public class ConsoleView implements View {
    protected final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public ConsoleView() {
    }

    /**
     * Il metodo open serve ad avviare la view e in questo caso si limita semplicemente a stampare il nome del gioco
     * che abbiamo selezionato.
     */
    public void open() {
        System.out.println("****************************************************");
        System.out.println("**                                                **");
        System.out.println("**                  CARD GAME                     **");
        System.out.println("**                                                **");
        System.out.println("****************************************************");
        System.out.println();
    }

    /**
     * Metodo pubblico che serve ad aggiornare lo stato della <i>view</i> chiedendo ogni volta
     * al {@link Player} quale carta vuole giocare. <br />
     * Il metodo stampa l'elenco delle carte che il giocatore ha nella propria mano e chiede quale carta vuole giocare,
     * ritornando infine della carta che è stata selezionata.
     *
     * @param hand   mano del giocatore a cui appartiene il turno
     * @param player per la stampa di username e punteggio
     * @return posizione della carta che il giocatore ha selezionato
     * @throws IOException           Eccezione che viene lanciata quando ci sono errori durante l'inserimento di dati da tastiera
     * @throws NumberFormatException Eccezione che viene lanciata quando ci sono errori durante la conversione del dato
     *                               in input
     */
    public int updateState(Hand hand, Player player) throws IOException, NumberFormatException {
        printInfo(player);
        printHand(hand);
        System.out.print("Seleziona la carta che vuoi giocare: ");
        return selectCardToPlay(hand, player);
    }

    /**
     * Mostra lo stato finale della view, ovvero quando è terminata la partita.
     *
     * @param players  per visualizzare lo stato finale di tutti i giocatori
     * @param winnerID id del giocatore che ha vinto la partita
     */
    @Override
    public void close(List<Player> players, Integer winnerID) {
        System.out.println("La partita è terminata!");
        System.out.println("Il vincitore è: " + players.get(winnerID).getUsername());
        System.out.println();
        System.out.println("=============PUNTEGGI GIOCATORI=============");
        players.forEach(player -> System.out.println("Punteggio " + player.getUsername() + ": " + player.getScore()));
        System.out.println("============================================");
    }

    /**
     * Visualizza tutte le carte che il {@link Player} ha in mano.
     *
     * @param hand mano del giocatore.
     * @see Hand
     */
    protected void printHand(Hand hand) {
        List<Card> cards = hand.getCards();
        for (int i = 0; i < cards.size(); i++)
            System.out.println((i + 1) + " - " + cards.get(i).getRank() + " " + cards.get(i).getSeed());
    }

    /**
     * Consente al giocatore di scegliere una carta da giocare.
     * Nel caso in cui si tratta di un {@link InteractivePlayer}, verrà chiesto all'utente di inserire da tastiera
     * il numero che corrisponde alla posizione della carta che vuole giocare. <br />
     * Se invece il giocatore è un bot, verrà invocato il metodo <i>selectCard()</i> che appartiene
     * alla classe {@link RandomPlayer}, il quale sceglierà la carta mediante l'apposito algoritmo.
     *
     * @param hand   mano del giocatore che sta giocando la partita
     * @param player giocatore a cui appartiene il turno
     * @param <T>    tipo generico che rappresenta la classe del {@link Player} che sta attualmente giocando la partita,
     *               può essere un {@link InteractivePlayer} oppure un {@link RandomPlayer}
     * @return valore intero che indica la posizione della carta nella mano che il giocatore vuole giocare
     * @throws IOException           errori di I/O che riguardano la lettura del valore inserito da tastiera
     * @throws NumberFormatException errore di conversione da String ad Integer
     */
    protected <T extends Player> Integer selectCardToPlay(Hand hand, T player) throws IOException, NumberFormatException {
        int selected = 0;
        if (player instanceof RandomPlayer) {
            selected = ((RandomPlayer) player).selectCard(hand);
            System.out.println(selected + 1);
        } else if (player instanceof InteractivePlayer) {
            selected = (Integer.parseInt(br.readLine()) - 1);
        }
        newLines();
        return selected;
    }

    /**
     * Stampa le info sul giocatore a cui appartiene il turno
     *
     * @param player giocatore a cui appartiene il turno
     */
    protected void printInfo(Player player) {
        System.out.println("E' il turno di: " + player.getUsername());
        System.out.println("Punteggio: " + player.getScore());
        System.out.println();
    }

    /**
     * Stampa due righe vuote.
     */
    protected void newLines() {
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
    }
}
