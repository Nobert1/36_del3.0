package Test;
import Controllers.GameBoard;
import Models.Fields.Properties;
import Models.Player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PropertiesTest {

    Properties Testprop1 = new Properties(1, "test prop1", 1, 1);
    Properties Testprop2 = new Properties(2, "test prop2", 1, 1);
    Player testPlayer1 = new Player("TestPlayer1");
    Player testPlayer2 = new Player("TestPlayer2");

    public GameBoard getGb(){
        return GameBoard.getInstance();
    }


    @org.junit.jupiter.api.Test
    void setOwned() {
       Testprop1.setOwned(true);
       assertTrue(Testprop1.getOwned() == true);
    }

    @org.junit.jupiter.api.Test
    void newOwner() {

        Testprop1.setOwned(true);
        Testprop1.setOwner(testPlayer1);
        Testprop1.newOwner();


        assertEquals(testPlayer1.getAccount().getBalance(), 19);

        //This test will open the GUI since the player balance is based on what is typed in at the GUI. This test will be passed
        // with two players, since it gives a balance of 20.
    }

    @org.junit.jupiter.api.Test
    void getOwner() {
        Testprop1.setOwner(testPlayer1);
        assertEquals(testPlayer1, testPlayer1);
    }

    @org.junit.jupiter.api.Test
    void payRent() {

        Testprop1.setOwned(true);
        Testprop2.setOwned(true);
        Testprop2.setOwner(testPlayer1);
        Testprop1.setOwner(testPlayer1);

        testPlayer2.setCurrentPosition(2);
        getGb().setCurrentPlayer(testPlayer2);
        Testprop2.FieldFunctionality();

        assertEquals(18, testPlayer2.getAccount().getBalance(), "Since this tests double rent, the test is passed");


        //This test will open the GUI since the player balance is based on what is typed in at the GUI. This test will be passed
        // with two players, since it gives a balance of 20.
    }
        @org.junit.jupiter.api.Test
    void PaySingleRent() {

        Testprop1.setOwned(true);
        Testprop1.setOwner(testPlayer1);

        getGb().setCurrentPlayer(testPlayer2);
        Testprop1.FieldFunctionality();

        assertEquals(19, testPlayer2.getAccount().getBalance(), "Since this tests double rent, the test is passed");

        //This test will open the GUI since the player balance is based on what is typed in at the GUI. This test will be passed
        // with two players, since it gives a balance of 20.
    }
    @org.junit.jupiter.api.Test
    void Paynothing() {
        Testprop1.setOwned(true);
        Testprop1.setOwner(testPlayer1);
        testPlayer1.setPayNothing(true);
        Testprop1.newOwner();
        assertEquals(testPlayer1.getAccount().getBalance(), 20);
    }
}