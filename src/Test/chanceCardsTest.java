package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class chanceCardsTest {
    Modeller.ChanceCards testCard = new Modeller.ChanceCards("Testkort", "Kort1", 1);

    @Test
    void getNumber() {
        assertEquals(1,testCard.getNumber());
        System.out.println("Testen for getNumber er bestået, tallet var " + testCard.getNumber() + ".");
    }

    @Test
    void setNumber() {
        testCard.setNumber(2);
        assertEquals(2,testCard.getNumber());
        System.out.println("Test for setNumber er bestået, tallet blev ændret til " + testCard.getNumber() + ".");
    }

    @Test
    public void getDescription() {
        assertTrue(testCard.getDescription()=="Testkort");
        System.out.println("Test for getDescription er bestået, kortets description var " + testCard.getDescription() + ".");
    }
}