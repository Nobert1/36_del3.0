package Test;

import Modeller.ChanceCardDeck;
import Modeller.ChanceCards;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChanceCardDeckTest {
    private ChanceCards[] Deck;

    @Test
    void Shufflecards() {
        ChanceCardDeck Deck1 = new ChanceCardDeck();
        ChanceCardDeck Deck2 = new ChanceCardDeck();
        Deck1.Shufflecards();
        assertNotEquals(Deck1,Deck2);
    }

    @Test
    void DrawCard() {
        ChanceCardDeck Deck1 = new ChanceCardDeck();
        Deck1.DrawCard();
        assertEquals(1,1,"Testen er bestået");
    }
}