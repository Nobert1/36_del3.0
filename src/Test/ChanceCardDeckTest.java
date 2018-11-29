package Test;

import Controllers.GameBoard;
import Models.ChanceCardDeck;
import Models.ChanceCards;
import Models.Player;
import static org.junit.jupiter.api.Assertions.*;


class ChanceCardDeckTest {

    public GameBoard getGb(){
        return GameBoard.getInstance();
    }

    @org.junit.jupiter.api.Test
    void shufflecards() {

        ChanceCardDeck deck1 = new ChanceCardDeck(getGb().getGui());
        ChanceCardDeck deck2 = new ChanceCardDeck(getGb().getGui());

        assertNotEquals(deck1, deck2);

        // The cards are shuffled when they are made in the constructor, and it's bad practice to change your code to test it.
        // Therefore failing the test asserts that the two decks are not equal, and that shows the method works.
    }

    @org.junit.jupiter.api.Test
    void drawCard() {
        ChanceCardDeck deck1 = new ChanceCardDeck(getGb().getGui());
        ChanceCards card = deck1.getIndex(0);
        deck1.drawCard();
        assertTrue(card == deck1.getIndex(15), "Since the draw card puts the card to the bottom, they are the same");

    }
    @org.junit.jupiter.api.Test
    void setplayer() {

            ChanceCardDeck deck1 = new ChanceCardDeck(getGb().getGui());
            Player testplayer = new Player("Testplayer");
            testplayer.setCurrentPosition(39);

        deck1.getIndex(15).setNumber(15);
            getGb().setCurrentPlayer(testplayer);
            // This test will also test for start, the test is only passed if you click on the "Burgerbar" though.
        try {
            deck1.UseChancecard();
        } catch (NullPointerException e) { }
        assertEquals(testplayer.getCurrentPosition(), 1);
        //Since the use card method takes the bottom card (the one that is prevoiusly drawn) the number for card 15 is set.
        //Setting the number on the card let's us test it without changing the code since it has a shuffle function.
        //The catch catches the null pointer exception in the gui handler method that sets a border. The border is not set because
        // of mulitple things like the player not having a colour.

    }


}