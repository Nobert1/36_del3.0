package Models;
import Controllers.GameBoard;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.util.Random;

/**
 * Currently still needs some work, how we implement it in the Gameboard also needs some looking at before we
 * continue with writing methods. We may need to make the instance static like we did with the Board instance of the Fields class.
 * - comment by Gustav
 */

public class ChanceCardDeck {

    private GameBoard gb = GameBoard.getInstance();
    private ChanceCards[] Deck;
    private GUI gui;
    private GUI_Player gui_player;
    private final int maxValue = 20;


    public ChanceCardDeck() {

        Deck = new ChanceCards[20];
        Deck[0] = new ChanceCards("Give this card to the CAR and draw one more chancecard. CAR: On your next turn you have to move to any free square, and buy it. If none of the squares are free you have to buy one from another player", "CHANCE", 1);
        Deck[1] = new ChanceCards("Move to START and recive 2$", "CHANCE", 2);
        Deck[2] = new ChanceCards("Move up to 5 fields forward", "CHANCE", 3);
        Deck[3] = new ChanceCards("Move to an orange square, if the field is not owned you get it for free, otherwise you have to pay the owner rent", "CHANCE", 4);
        Deck[4] = new ChanceCards("Move 1 square forward or take another card", "CHANCE", 5);
        Deck[5] = new ChanceCards("Give this card to the ship, and take another one. SHIP: on your next turn you have to sail to any unowned square and buy it. If all of the squares are owned you have to buy one from antoher player", "CHANCE", 6);
        Deck[6] = new ChanceCards("You ate too much candy, pay 2$ to the bank", "CHANCE", 7);
        Deck[7] = new ChanceCards("Move to an orange or green square. If no one owns it you get it for free, else you have to play rent to the owner", "CHANCE", 8);
        Deck[8] = new ChanceCards("Move to an lightblue square, if no one owns it you get it for free! otherwise you have to pay rent to the owner", "CHANCE", 9);
        Deck[9] = new ChanceCards("You are released without any cost, keep this card until you need it.", "CHANCE", 10);
        Deck[10] = new ChanceCards("Move to Strandpromenaden", "CHANCE", 11);
        Deck[11] = new ChanceCards("Give this card to the CAT and draw another one. CAT: On your next turn sneak onto any square and buy it. If all squares are owned you have to buy one from another player", "CHANCE", 12);
        Deck[12] = new ChanceCards("Give this card to the DOG and draw another one. DOG: On your next turn jump onto any square and buy it. If all squares are owned you have to buy one from another player", "CHANCE)", 13);
        Deck[13] = new ChanceCards("It's your birthday! Everyone gives you 1$", "CHANCE", 14);
        Deck[14] = new ChanceCards("Move to a pink or darkblue square, if no one owns the square you get it for free! Otherwise you have to pay the owner rent", "CHANCE", 15);
        Deck[15] = new ChanceCards("You have made all of your homework, recive 2$ from the bank", "CHANCE", 16);
        Deck[16] = new ChanceCards("Move to a red square, if no one owns it you get it for free! Otherwise you have to pay the owner rent.", "CHANCE", 17);
        Deck[17] = new ChanceCards("Move to the skate park to do the perfect grind! If no one owns it you get it for free, otherwise pay the owner rent", "CHANCE", 18);
        Deck[18] = new ChanceCards("Move to a lightblue or red square, if no one owns it you get it for free, otherwise pay the owner rent.", "CHANCE", 19);
        Deck[19] = new ChanceCards("Move to a brown or yellow square, if no one owns it you get it for free, otherwise pay the owner rent.", "CHANCE", 20);

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
        }
        this.Deck = Cardtemp;
    }


    public ChanceCards DrawCard() {
        ChanceCards[] korttemp = this.Deck;
        ChanceCards firstCardKort = this.Deck[0];

        for (int i = 0; i < Deck.length; i++) {
            this.Deck[i] = korttemp[(i + 1) % 20];
        }
        Deck[19] = firstCardKort;

        switch (Deck[19].getNumber()) {
            case 1:
                // Give this card to the CAR and draw one more chancecard. CAR: On your next turn you have to move to any free square, and buy it. If none of the squares are free you have to buy one from another player
                break;
            case 2:
                //Move to START and recive 2$
                gui.getFields()[0].setCar(gb.getCurrentGUIPlayer(), false);
                gb.getCurrentGUIPlayer().setBalance(gb.getCurrentGUIPlayer().getBalance() + 2);
                gui.getFields()[0].setCar(gb.getCurrentGUIPlayer(), true);
                break;
            case 3:
                //Move up to 5 fields forward
                move2();
                break;
            case 4:
                // Move to an orange square, if the field is not owned you get it for free, otherwise you have to pay the owner rent
                String oField[] = {gb.getFI().getField(10).getName(), gb.getFI().getField(11).getName()};
                String answer6 = gui.getUserButtonPressed("Choose a field to land on: " +
                                                          gb.getFI().getField(10).getName() +
                                                          " eller " + gb.getFI().getField(11).getName(), oField);
                int answerTo6 = 0;
                switch (answer6) {
                    case "Rullebretparken \n Skateparken":
                        answerTo6 = 10;
                        break;
                    case "Svømmebassenget \n Swimmingpoolen":
                        answerTo6 = 11;
                        break;
                }
                gb.getCurrentGUIPlayer().setPayNothing(true);
                gb.getFI().getField(answerTo6).FieldFunctionality();

                break;
            case 5:
                // Move 1 square forward or take another card
                String arr2[] = {"Move","Draw"};
                String answer1 = gui.getUserButtonPressed("Choose one: move one field forward or draw another card", arr2);
                if(answer1.equals("move")) {
                    gui.getFields()[0].setCar(gb.getCurrentGUIPlayer(), false);
                    gb.getCurrentGUIPlayer().setPlacement(gb.getCurrentGUIPlayer().getPlacement() + 1);
                    gui.getFields()[gb.getCurrentGUIPlayer().getPlacement()].setCar(gb.getCurrentGUIPlayer(), false);
                } else {
                    DrawCard();
                }
                break;
            case 6:
                // Give this card to the ship, and take another one. SHIP: on your next turn you have to sail to any unowned square and buy it. If all of the squares are owned you have to buy one from antoher player
                break;
            case 7:
                // You ate too much candy, pay 2$ to the bank
                gb.getCurrentGUIPlayer().setBalance(gb.getCurrentGUIPlayer().getBalance() + 2);
                break;
            case 8:
                // Move to an orange or green square. If no one owns it you get it for free, else you have to play rent to the owner
                String ogField[] = {gb.getFI().getField(10).getName(),
                                    gb.getFI().getField(11).getName()};
                String answer7 = gui.getUserButtonPressed("Choose a field to land on: " +
                                                          gb.getFI().getField(10).getName() +
                            " eller " + gb.getFI().getField(11).getName(), ogField);
                int answerTo7 = 0;
                switch (answer7) {
                    case "Rullebretparken \n Skateparken":
                        answerTo7 = 10;
                        break;
                    case "Svømmebassenget \n Swimmingpoolen":
                        answerTo7 = 11;
                        break;
                    case "Bowlinghallen \n Bowlinghallen":
                        answerTo7 = 19;
                        break;
                    case "Zoologisk have \n Zoo":
                        answerTo7 = 20;
                        break;
                }
                gb.getCurrentGUIPlayer().setPayNothing(true);
                gb.getFI().getField(answerTo7).FieldFunctionality();
                break;
            case 9:
                // Move to an lightblue square, if no one owns it you get it for free! otherwise you have to pay rent to the owner
                String lbField[] = {gb.getFI().getField(4).getName(), gb.getFI().getField(5).getName()};
                String answer5 = gui.getUserButtonPressed("Choose a field to land on: " +
                                                          gb.getFI().getField(4).getName() +
                                                          " eller " + gb.getFI().getField(5).getName(), lbField);
                int answerTo5 = 0;
                switch (answer5) {
                    case "Godtebutikken \n Slikbutikken":
                        answerTo5 = 4;
                        break;
                    case "ISKIOSKEN \n ISKIOSKEN":
                        answerTo5 = 5;
                        break;
                }
                gb.getCurrentGUIPlayer().setPayNothing(true);
                gb.getFI().getField(answerTo5).FieldFunctionality();
                break;
            case 10:
                //You are released without any cost, keep this card until you need it.
                break;
            case 11:
                // Move to Strandpromenaden
                move1(23);
                break;
            case 12:
                //Give this card to the CAT and draw another one. CAT: On your next turn sneak onto any square and buy it. If all squares are owned you have to buy one from another player
                break;
            case 13:
                //Give this card to the DOG and draw another one. DOG: On your next turn jump onto any square and buy it. If all squares are owned you have to buy one from another player
                break;
            case 14:
                // It's your birthday! Everyone gives you 1$
                //burde bare at være at gå igennem players array og for hver spiller minus 1. derefter + 1 til currentplayer. er skide træt orker ikke mere nu.

                /*for(player : players)*/
                break;
            case 15:
                // Move to a pink or darkblue square, if no one owns the square you get it for free! Otherwise you have to pay the owner rent
                String pdField[] = {gb.getFI().getField(7).getName(),
                                     gb.getFI().getField(8).getName(),
                                     gb.getFI().getField(22).getName(),
                                     gb.getFI().getField(23).getName()};
                String answer = gui.getUserButtonPressed("Choose a field to land on: " +
                                                          gb.getFI().getField(7).getName() +
                                                          " , " + gb.getFI().getField(8).getName() +
                                                          " , " + gb.getFI().getField(22).getName() +
                                                          " eller " + gb.getFI().getField(23).getName(), pdField);
                int answerTo = 0;
                switch (answer) {
                    case "Spillehallen \n Spillehallen":
                        answerTo = 7;
                        break;
                    case "Kinoen \n Biografen":
                        answerTo = 8;
                        break;
                    case "Godtebutikken \n Slikbutikken":
                        answerTo = 22;
                        break;
                    case "ISKIOSKEN \n ISKIOSKEN":
                        answerTo = 23;
                        break;
                }
                gb.getCurrentGUIPlayer().setPayNothing(true);
                gb.getFI().getField(answerTo).FieldFunctionality();
                break;
            case 16:
                // You have made all of your homework, recive 2$ from the bank
                gb.getCurrentGUIPlayer().setBalance(gb.getCurrentGUIPlayer().getBalance() + 2);
                break;
            case 17:
                // Move to a red square, if no one owns it you get it for free! Otherwise you have to pay the owner rent.
                String redField[] = {gb.getFI().getField(13).getName(), gb.getFI().getField(14).getName()};
                String answer2 = gui.getUserButtonPressed("Choose a field to land on: " +
                                                           gb.getFI().getField(13).getName() +
                                                           " eller " + gb.getFI().getField(14).getName(), redField);
                int answerTo2 = 0;
                switch (answer2) {
                    case "Spillehallen \n Spillehallen":
                        answerTo2 = 13;
                        break;
                    case "Kinoen \n Biografen":
                        answerTo2 = 14;
                        break;
                }
                gb.getCurrentGUIPlayer().setPayNothing(true);
                gb.getFI().getField(answerTo2).FieldFunctionality();
                break;
            case 18:
                // Move to the skate park to do the perfect grind! If no one owns it you get it for free, otherwise pay the owner rent
                move1(10);
                gb.getCurrentGUIPlayer().setPayNothing(true);
                gb.getFI().getField(10).FieldFunctionality();
                break;
            case 19:
                // Move to a lightblue or red square, if no one owns it you get it for free, otherwise pay the owner rent.
                String lbrField[] = {gb.getFI().getField(13).getName(),
                                     gb.getFI().getField(14).getName(),
                                     gb.getFI().getField(4).getName(),
                                     gb.getFI().getField(5).getName()};
                String answer3 = gui.getUserButtonPressed("Choose a field to land on: " +
                                                          gb.getFI().getField(13).getName() +
                                                          " , " + gb.getFI().getField(14).getName() +
                                                          " , " + gb.getFI().getField(4).getName() +
                                                          " eller " + gb.getFI().getField(5).getName(), lbrField);
                int answerTo3 = 0;
                switch (answer3) {
                    case "Spillehallen \n Spillehallen":
                        answerTo3 = 13;
                        break;
                    case "Kinoen \n Biografen":
                        answerTo3 = 14;
                        break;
                    case "Godtebutikken \n Slikbutikken":
                        answerTo3 = 4;
                        break;
                    case "ISKIOSKEN \n ISKIOSKEN":
                        answerTo3 = 5;
                        break;
                }
                gb.getCurrentGUIPlayer().setPayNothing(true);
                gb.getFI().getField(answerTo3).FieldFunctionality();
                break;
            case 20:
                // Move to a brown or yellow square, if no one owns it you get it for free, otherwise pay the owner rent.
                String byField[] = {gb.getFI().getField(1).getName(),
                                    gb.getFI().getField(2).getName(),
                                    gb.getFI().getField(10).getName(),
                                    gb.getFI().getField(11).getName()};
                String answer4 = gui.getUserButtonPressed("Choose a field to land on: " +
                                                           gb.getFI().getField(1).getName() +
                                                           " , " + gb.getFI().getField(2).getName() +
                                                           " , " + gb.getFI().getField(10).getName() +
                                                           " eller " + gb.getFI().getField(11).getName(), byField);
                int answerTo4 = 0;
                switch (answer4) {
                    case "GATEKJØKKENET \n BURGERBAREN":
                        answerTo4 = 1;
                        break;
                    case "Pizzahuset \n Pizzeriaet":
                        answerTo4 = 2;
                        break;
                    case "Rullebretparken \n Skateparken":
                        answerTo4 = 10;
                        break;
                    case "Svømmebassenget \n Swimmingpoolen":
                        answerTo4 = 11;
                        break;
                }
                gb.getCurrentGUIPlayer().setPayNothing(true);
                gb.getFI().getField(answerTo4).FieldFunctionality();
                break;
        }
        return firstCardKort;
    }

    /*
    public void switchSystem() {
        switch(i) {
            case
        }
    }*/

    public void move1(int i) {
        gui.getFields()[gb.getCurrentGUIPlayer().getPlacement()].setCar(gb.getCurrentGUIPlayer(), false);
        gui.getFields()[i].setCar(gb.getCurrentGUIPlayer(), true);
    }

    public void move2() {
        // Move up to 5 fields forward
        String arr1[] = {"1","2","3","4","5"};
        String userIn = gui.getUserButtonPressed("How many fields do you want to move forward?", arr1);
        switch (userIn) {
            case "1":
                gui.getFields()[gb.getCurrentGUIPlayer().getPlacement()].setCar(gb.getCurrentGUIPlayer(), false);
                gb.getCurrentGUIPlayer().setPlacement(gb.getCurrentGUIPlayer().getPlacement() + 1);
                gui.getFields()[gb.getCurrentGUIPlayer().getPlacement()].setCar(gb.getCurrentGUIPlayer(), true);
                break;
            case "2":
                gui.getFields()[gb.getCurrentGUIPlayer().getPlacement()].setCar(gb.getCurrentGUIPlayer(), false);
                gb.getCurrentGUIPlayer().setPlacement(gb.getCurrentGUIPlayer().getPlacement() + 2);
                gui.getFields()[gb.getCurrentGUIPlayer().getPlacement()].setCar(gb.getCurrentGUIPlayer(), true);
                break;
            case "3":
                gui.getFields()[gb.getCurrentGUIPlayer().getPlacement()].setCar(gb.getCurrentGUIPlayer(), false);
                gb.getCurrentGUIPlayer().setPlacement(gb.getCurrentGUIPlayer().getPlacement() + 3);
                gui.getFields()[gb.getCurrentGUIPlayer().getPlacement()].setCar(gb.getCurrentGUIPlayer(), true);
                break;
            case "4":
                gui.getFields()[gb.getCurrentGUIPlayer().getPlacement()].setCar(gb.getCurrentGUIPlayer(), false);
                gb.getCurrentGUIPlayer().setPlacement(gb.getCurrentGUIPlayer().getPlacement() + 4);
                gui.getFields()[gb.getCurrentGUIPlayer().getPlacement()].setCar(gb.getCurrentGUIPlayer(), true);
                break;
            case "5":
                gui.getFields()[gb.getCurrentGUIPlayer().getPlacement()].setCar(gb.getCurrentGUIPlayer(), false);
                gb.getCurrentGUIPlayer().setPlacement(gb.getCurrentGUIPlayer().getPlacement() + 5);
                gui.getFields()[gb.getCurrentGUIPlayer().getPlacement()].setCar(gb.getCurrentGUIPlayer(), true);
                break;
        }
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < this.Deck.length; i++) {
            output += this.Deck[i] + "\n";
            System.out.println(this.Deck[i]);
        }
        return output;
    }

    public void Function() {
        switch (Deck[19].getNumber()) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
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
    }
}

