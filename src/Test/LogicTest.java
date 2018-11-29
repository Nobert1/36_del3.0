package Test;

import Controllers.GameBoard;
import Models.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LogicTest {

    public GameBoard getGb(){ return GameBoard.getInstance(); }

    Player testplayer = new Player("test");
    Player testplayer2 = new Player("test");


    @Test
    void checkforInJail() {
        Player[] arr = {testplayer2, testplayer};
        getGb().setPlayerArray(arr);
        getGb().setCurrentPlayer(testplayer);
        testplayer.setInJail(true);
        getGb().getLogic().checkforInJail();

     assertEquals(19, testplayer.getAccount().getBalance(), "Since he is in jail, 1 dollar should be withdrawn.");





    }

    @Test
    void checkforBroke() {

        getGb().setCurrentPlayer(testplayer);
        testplayer.getAccount().withdraw(20);

        assertTrue(testplayer.getBroke() == true);
    }

    @Test
    void checkforStart() {
// Stack flow error?!?!?!?!?

        getGb().setCurrentPlayer(testplayer);
        testplayer.setCurrentPosition(18);
        checkforStart();

        assertEquals(22, getGb().getCurrentPlayer().getAccount().getBalance());
    }

    @Test
    void getPlayerTurn() {
        //stack flow error.
        Player[] arr = {testplayer2, testplayer};
        getGb().setPlayerArray(arr);
        getGb().setCurrentPlayer(testplayer2);
        getPlayerTurn();
        assertEquals(getGb().getCurrentPlayer(), testplayer);
    }

    @Test
    void applySquareLogic() {
        // Not gonna be tested, since it only calls other methods.
    }
}