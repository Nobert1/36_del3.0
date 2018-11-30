package Models;
import java.util.Random;

/**
 * Dice class
 */

public class Dice {
    Random random = new Random();
    private final int maxValue = 6;
    private int value;

    public void setValue(int value) {
        this.value = value;
    }

    public Dice() {
        value = 1;
    }
    public int roll() {
        value = random.nextInt(maxValue) + 1;
        return this.value; }

    public int getValue() {
        return value;
    }
}