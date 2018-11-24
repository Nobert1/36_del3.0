package Models;
import Models.BankAccount;
import Models.ChanceCards;
import gui_fields.GUI_Player;
import gui_main.GUI;
import java.util.Scanner;
import java.util.Random;

/**
 * Currently still needs some work, how we implement it in the Gameboard also needs some looking at before we
 * continue with writing methods. We may need to make the instance static like we did with the Board instance of the Fields class.
 * - comment by Gustav
 */

public class ChanceCardDeck {

    private ChanceCards[] Deck;
    private GUI gui;
    private GUI_Player gui_player;
    private BankAccount bankAccount;

    private final int maxValue = 20;


    public ChanceCardDeck() {

        Deck = new ChanceCards[20];
        Deck[0] = new ChanceCards("Give this card to the CAR and draw one more chancecard. CAR: On your next turn you have to move to any free square, and buy it. If none of the squares are free you have to buy one from another player", "CHANCE", 1);
        Deck[1] = new ChanceCards("Move to START and recive 2$", "CHANCE",2 );
        Deck[2] = new ChanceCards("Move up to 5 fields forward", "CHANCE", 3);
        Deck[3] = new ChanceCards("Move to an orange square, if the field is not owned you get it for free, otherwise you have to pay the owner rent", "CHANCE",4);
        Deck[4] = new ChanceCards("Move 1 square forward or take another card", "CHANCE",5);
        Deck[5] = new ChanceCards("Give this card to the ship, and take another one. SHIP: on your next turn you have to sail to any unowned square and buy it. If all of the squares are owned you have to buy one from antoher player", "CHANCE", 6);
        Deck[6] = new ChanceCards("You ate too much candy, pay 2$ to the bank", "CHANCE", 7);
        Deck[7] = new ChanceCards("Move to an orange or green square. If no one owns it you get it for free, else you have to play rent to the owner", "CHANCE", 8);
        Deck[8] = new ChanceCards("Move to an lightblue square, if no one owns it you get it for free! otherwise you have to pay rent to the owner", "CHANCE", 9);
        Deck[9] = new ChanceCards("You are released without any cost, keep this card until you need it.", "CHANCE", 10);
        Deck[10] = new ChanceCards("Move to Strandpromenaden", "CHANCE", 11);
        Deck[11] = new ChanceCards("Give this card to the CAT and draw another one. CAT: On your next turn sneak onto any square and buy it. If all squares are owned you have to buy one from another player", "CHANCE",12 );
        Deck[12] = new ChanceCards("Give this card to the DOG and draw another one. DOG: On your next turn jump onto any square and buy it. If all squares are owned you have to buy one from another player", "CHANCE)", 13);
        Deck[13] = new ChanceCards("It's your birthday! Everyone gives you 1$", "CHANCE",14);
        Deck[14] = new ChanceCards("Move to a pink or darkblue square, if no one owns the square you get it for free! Otherwise you have to pay the owner rent", "CHANCE",15);
        Deck[15] = new ChanceCards("You have made all of your homework, recive 2$ from the bank", "CHANCE",16);
        Deck[16] = new ChanceCards("Move to a red square, if no one owns it you get it for free! Otherwise you have to pay the owner rent.", "CHANCE",17);
        Deck[17] = new ChanceCards("Move to the skate park to do the perfect grind! If no one owns it you get it for free, otherwise pay the owner rent", "CHANCE",18);
        Deck[18] = new ChanceCards("Move to a lightblue or red square, if no one owns it you get it for free, otherwise pay the owner rent.", "CHANCE",19);
        Deck[19] = new ChanceCards("Move to a brown or yellow square, if no one owns it you get it for free, otherwise pay the owner rent.", "CHANCE",20);

        Shufflecards();

        //Konstruktøren skal muligvis have fjernet sit navn og tilføjet en int værdi i stedet som vi kan bruge i case systemmet.
    }

    public void Shufflecards() {
        ChanceCards Cardtemp[] = new ChanceCards[20];

        Random random = new Random();
        int shifts = 0;
        int pos;
        while (shifts < 20) {
            pos = random.nextInt(maxValue);

            if (Cardtemp[pos] == null) {
                Cardtemp[pos] = this.Deck[shifts];
                shifts++;

            }
            this.Deck = Cardtemp;
        }
    }
    public ChanceCards DrawCard(GUI_Player currentplayer, GUI gui) {

        ChanceCards[] korttemp = this.Deck;
        ChanceCards firstCardKort = this.Deck[0];

        for (int i = 0; i < Deck.length; i++) {
            this.Deck[i] = korttemp[(i + 1) % 20];
        }
        Deck[19] = firstCardKort;


        switch (Deck[2].getNumber()) {
            case 1:

                break;
            case 2:
                gui.getFields()[0].setCar(currentplayer, true);
                int newBalance = currentplayer.getBalance() + 2;
                currentplayer.setBalance(newBalance);
                System.out.println("din nye balance er nu" + currentplayer.getBalance());
                break;
            case 3:
                String arr1[] = {"1" , "2" , "3", "4", "5"};
                String userin = gui.getUserButtonPressed("How many fields do you want to move?",arr1);
                switch (userin) {
                    case "1":
                        gui.getFields()[currentplayer.getPlacement()].setCar(currentplayer,false);
                        gui.getFields()[currentplayer.getPlacement() + 1].setCar(currentplayer,true);
                        break;
                    case "2":
                        gui.getFields()[currentplayer.getPlacement()].setCar(currentplayer,false);
                        currentplayer.setPlacement(currentplayer.getPlacement()+2);
                        System.out.println(currentplayer.getPlacement());
                        gui.getFields()[(currentplayer.getPlacement())].setCar(currentplayer,true);

                        break;
                    case "3":
                        gui.getFields()[currentplayer.getPlacement()].setCar(currentplayer,false);
                        gui.getFields()[currentplayer.getPlacement() + 3].setCar(currentplayer,true);
                        break;
                    case "4":
                        gui.getFields()[currentplayer.getPlacement()].setCar(currentplayer,false);
                        gui.getFields()[currentplayer.getPlacement() + 4].setCar(currentplayer,true);
                        break;
                    case "5":
                        gui.getFields()[currentplayer.getPlacement()].setCar(currentplayer,false);
                        gui.getFields()[currentplayer.getPlacement() + 5].setCar(currentplayer,true);
                        break;
                }
                break;
            case 4:
                break;
            case 5:
                gui.getFields()[currentplayer.getPlacement()].setCar(currentplayer,false);
                gui.getFields()[0].setCar(currentplayer, true);
                int newBalance1 = currentplayer.getBalance() - 2;
                currentplayer.setBalance(newBalance1);
                System.out.println("din nye balance er nu" + currentplayer.getBalance());
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;

            // moves the player to strandpromonaden.
            case 10:
                gui.getFields()[currentplayer.getPlacement()].setCar(currentplayer,false);
                gui.getFields()[23].setCar(currentplayer, true);
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                int newBalance2 = currentplayer.getBalance() + 2;
                currentplayer.setBalance(newBalance2);
                break;
            case 17:
                break;
            case 18:
                break;
            case 19:
                break;
            case 20:
                break;
        }
        return Deck[2];
        //return firstCardKort;

    }

    public String toString() {
        String output = "";
        for (int i = 0; i < this.Deck.length; i++) {
            output += this.Deck[i] + "\n";
            System.out.println(this.Deck[i]);
        }
        return output;
    }
}

