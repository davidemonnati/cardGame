package it.unicam.cs.pa.davidemonnati.cardgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameCoordinatorTest {
    @Test
    void createCardsGameTest() {
        GameCoordinator cardsGame = new GameCoordinator();
        assertNotNull(cardsGame);
    }

    @Test void opponentPlayerTest(){
        int i =0;
        i = opponentPlayer(i);
        assertEquals(i, 1);
        i = opponentPlayer(i);
        assertEquals(i,0);
    }

    private int opponentPlayer(int i){
        return (i+1)%2;
    }
}
