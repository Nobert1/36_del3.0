package Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import Modeller.Dice;
import org.junit.jupiter.api.*;

class DiceTest {

    @RepeatedTest(1000)
    void testRoll() {

        Dice testDice = new Dice();
        Dice testDice2 = new Dice();


        int d2 = 0, d3 = 0, d4 = 0, d5 = 0, d6 = 0, d7 = 0, d8 = 0, d9 = 0, d10 = 0, d11 = 0, d12 = 0;

        for (int d = 1; d <= 1000; d++) {
            int t = testDice.roll() + testDice2.roll();
            switch (t) {
                case 2:
                    d2++;
                    break;
                case 3:
                    d3++;
                    break;
                case 4:
                    d4++;
                    break;
                case 5:
                    d5++;
                    break;
                case 6:
                    d6++;
                    break;
                case 7:
                    d7++;
                    break;
                case 8:
                    d8++;
                    break;
                case 9:
                    d9++;
                    break;
                case 10:
                    d10++;
                    break;
                case 11:
                    d11++;
                    break;
                case 12:
                    d12++;
                    break;
                default:
                    break;

            }
        }
        assertTrue(d2>=  1*27.7777777778*0.60 &&  d2<= 1*27.7777777778*1.40
                        &&  d3>=  2*27.7777777778*0.60 &&  d3<= 2*27.7777777778*1.40
                        &&  d4>=  3*27.7777777778*0.60 &&  d4<= 3*27.7777777778*1.40
                        &&  d5>=  4*27.7777777778*0.60 &&  d5<= 4*27.7777777778*1.40
                        &&  d6>=  5*27.7777777778*0.60 &&  d6<= 5*27.7777777778*1.40
                        &&  d7>=  6*27.7777777778*0.60 &&  d7<= 6*27.7777777778*1.40
                        &&  d8>=  5*27.7777777778*0.60 &&  d8<= 5*27.7777777778*1.40
                        &&  d9>=  4*27.7777777778*0.60 &&  d9<= 4*27.7777777778*1.40
                        &&  d10>= 3*27.7777777778*0.60 && d10<= 3*27.7777777778*1.40
                        &&  d11>= 2*27.7777777778*0.60 && d11<= 2*27.7777777778*1.40
                        &&  d12>= 1*27.7777777778*0.60 && d12<= 1*27.7777777778*1.40
                , "Terningen er tilfældig");
    }
}