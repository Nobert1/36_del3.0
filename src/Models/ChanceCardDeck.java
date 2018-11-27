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
    private ChanceCards[] deck;

    private GUI_Player gui_player;
    private final int maxValue = 20;

    public ChanceCardDeck(GUI gui) {

        deck = new ChanceCards[20];
        deck[0] = new ChanceCards("Give this card to the CAR and draw one more chancecard. CAR: On your next turn you have to move to any free square, and buy it. If none of the squares are free you have to buy one from another player", "CHANCE", 1);
        deck[1] = new ChanceCards("Move to START and recive 2$", "CHANCE", 2);
        deck[2] = new ChanceCards("Move up to 5 fields forward", "CHANCE", 3);
        deck[3] = new ChanceCards("Move to an orange square, if the field is not owned you get it for free, otherwise you have to pay the owner rent", "CHANCE", 4);
        deck[4] = new ChanceCards("Move 1 square forward or take another card", "CHANCE", 5);
        deck[5] = new ChanceCards("Give this card to the ship, and take another one. SHIP: on your next turn you have to sail to any unowned square and buy it. If all of the squares are owned you have to buy one from antoher player", "CHANCE", 6);
        deck[6] = new ChanceCards("You ate too much candy, pay 2$ to the bank", "CHANCE", 7);
        deck[7] = new ChanceCards("Move to an orange or green square. If no one owns it you get it for free, else you have to play rent to the owner", "CHANCE", 8);
        deck[8] = new ChanceCards("Move to an lightblue square, if no one owns it you get it for free! otherwise you have to pay rent to the owner", "CHANCE", 9);
        deck[9] = new ChanceCards("You are released without any cost, keep this card until you need it.", "CHANCE", 10);
        deck[10] = new ChanceCards("Move to Strandpromenaden", "CHANCE", 11);
        deck[11] = new ChanceCards("Give this card to the CAT and draw another one. CAT: On your next turn sneak onto any square and buy it. If all squares are owned you have to buy one from another player", "CHANCE", 12);
        deck[12] = new ChanceCards("Give this card to the DOG and draw another one. DOG: On your next turn jump onto any square and buy it. If all squares are owned you have to buy one from another player", "CHANCE)", 13);
        deck[13] = new ChanceCards("It's your birthday! Everyone gives you 1$", "CHANCE", 14);
        deck[14] = new ChanceCards("Move to a pink or darkblue square, if no one owns the square you get it for free! Otherwise you have to pay the owner rent", "CHANCE", 15);
        deck[15] = new ChanceCards("You have made all of your homework, recive 2$ from the bank", "CHANCE", 16);
        deck[16] = new ChanceCards("Move to a red square, if no one owns it you get it for free! Otherwise you have to pay the owner rent.", "CHANCE", 17);
        deck[17] = new ChanceCards("Move to the skate park to do the perfect grind! If no one owns it you get it for free, otherwise pay the owner rent", "CHANCE", 18);
        deck[18] = new ChanceCards("Move to a lightblue or red square, if no one owns it you get it for free, otherwise pay the owner rent.", "CHANCE", 19);
        deck[19] = new ChanceCards("Move to a brown or yellow square, if no one owns it you get it for free, otherwise pay the owner rent.", "CHANCE", 20);

       // Shufflecards();

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
                Cardtemp[pos] = this.deck[shifts];
                shifts++;
            }
        }
        this.deck = Cardtemp;
    }

    public void drawCard() {
        ChanceCards[] korttemp = this.deck;
        ChanceCards firstCardKort = this.deck[0];

        for (int i = 0; i < deck.length; i++) {
            this.deck[i] = korttemp[(i + 1) % 20];
        }

        deck[19] = firstCardKort;
        getGb().gui.displayChanceCard(firstCardKort.getDescription());
        UseChancecard();

    }
        public void UseChancecard() {
            int Position = 0;
            String Userinput;
            switch (deck[19].getNumber()) {

            case 1:
                // Give this card to the CAR and draw one more chancecard. CAR: On your next turn you have to move to any free square, and buy it. If none of the squares are free you have to buy one from another player
                break;
            case 2:
                //Move to START and recive 2$
                setPlayer(0);
                getGb().getCurrentPlayer().getAccount().deposit(2);
                // Gotta check if this doesnt give 4.

                break;
            case 3:
                //Move up to 5 fields forward
                move2();
                break;

            case 4:
                // Move to an orange square, if the field is not owned you get it for free, otherwise you have to pay the owner rent
                String oField[] = {getGb().getFI().getField(10).getName(), getGb().getFI().getField(11).getName()};
                System.out.println(getGb().getFI().getField(10).getName());
                System.out.println(getGb().getFI().getField(11).getName());

                Userinput = getGb().gui.getUserButtonPressed("Choose a field to land on: " +
                        getGb().getFI().getField(10).getName() +
                        " eller " + getGb().getFI().getField(11).getName(), oField);

                Position = 0;
                switch (Userinput) {
                    case "Rullebretparken \n Skateparken":
                        Position = 10;
                        break;
                    case "Svømmebassenget \n Swimmingpoolen":
                        Position = 11;
                        break;
                }
                getGb().getCurrentPlayer().setPayNothing(true);
                setPlayer(Position);
                break;

            case 5:
                // Move 1 square forward or take another card
                String arr2[] = {"Move", "Draw"};
                Userinput = getGb().gui.getUserButtonPressed("Choose one: move one field forward or draw another card", arr2);
                if (Userinput.equals("move")) {
                    getGb().getHandler().removeplayer();
                    getGb().getCurrentPlayer().setCurrentPosition(getGb().getCurrentPlayer().getCurrentPosition() + 1);
                    getGb().getHandler().movePlayer();
                } else {
                    drawCard();
                }
                break;
            case 6:
                // Give this card to the ship, and take another one. SHIP: on your next turn you have to sail to any unowned square and buy it. If all of the squares are owned you have to buy one from antoher player
                break;
            case 7:
                // You ate too much candy, pay 2$ to the bank
                getGb().getCurrentPlayer().getAccount().withdraw(2);
                break;
            case 8:
                // Move to an orange or green square. If no one owns it you get it for free, else you have to play rent to the owner
                String ogField[] = {getGb().getFI().getField(10).getName(),
                        getGb().getFI().getField(11).getName()};
                Userinput = getGb().gui.getUserButtonPressed("Choose a field to land on: " +
                        getGb().getFI().getField(10).getName() +
                        " eller " + getGb().getFI().getField(11).getName(), ogField);

                 Position = 0;
                switch (Userinput) {
                    case "Rullebretparken \n Skateparken":
                        Position = 10;
                        break;
                    case "Svømmebassenget \n Swimmingpoolen":
                        Position = 11;
                        break;
                    case "Bowlinghallen \n Bowlinghallen":
                        Position = 19;
                        break;
                    case "Zoologisk have \n Zoo":
                        Position = 20;
                        break;
                }

                getGb().getCurrentPlayer().setPayNothing(true);
                setPlayer(Position);

                break;

            case 9:
                // Move to an lightblue square, if no one owns it you get it for free! otherwise you have to pay rent to the owner
                String lbField[] = {getGb().getFI().getField(4).getName(), getGb().getFI().getField(5).getName()};
                Userinput = getGb().gui.getUserButtonPressed("Choose a field to land on: " +
                        getGb().getFI().getField(4).getName() +
                        " eller " + getGb().getFI().getField(5).getName(), lbField);
                switch (Userinput) {
                    case "Godtebutikken \n Slikbutikken":
                        Position = 4;
                        break;
                    case "ISKIOSKEN \n ISKIOSKEN":
                        Position = 5;
                        break;
                }
                getGb().getCurrentPlayer().setPayNothing(true);
                setPlayer(Position);
                break;
            case 10:
                getGb().getCurrentPlayer().setJailCard(true);
                break;
            case 11:
                // Move to Strandpromenaden
                setPlayer(23);
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
                String pdField[] = {getGb().getFI().getField(7).getName(),
                        getGb().getFI().getField(8).getName(),
                        getGb().getFI().getField(22).getName(),
                        getGb().getFI().getField(23).getName()};
                Userinput = getGb().gui.getUserButtonPressed("Choose a field to land on: " +
                        getGb().getFI().getField(7).getName() +
                        " , " + getGb().getFI().getField(8).getName() +
                        " , " + getGb().getFI().getField(22).getName() +
                        " eller " + getGb().getFI().getField(23).getName(), pdField);

                switch (Userinput) {
                    case "Spillehallen \n Spillehallen":
                        Position = 7;
                        break;
                    case "Kinoen \n Biografen":
                        Position = 8;
                        break;
                    case "Godtebutikken \n Slikbutikken":
                        Position = 22;
                        break;
                    case "ISKIOSKEN \n ISKIOSKEN":
                        Position = 23;
                        break;
                }
                getGb().getCurrentPlayer().setPayNothing(true);
                setPlayer(Position);
                break;

            case 16:
                // You have made all of your homework, recive 2$ from the bank
                getGb().getCurrentPlayer().getAccount().deposit(2);
                break;

            case 17:
                // Move to a red square, if no one owns it you get it for free! Otherwise you have to pay the owner rent.
                String redField[] = {getGb().getFI().getField(13).getName(),
                        getGb().getFI().getField(14).getName()};

                Userinput = getGb().gui.getUserButtonPressed("Choose a field to land on: " +
                        getGb().getFI().getField(13).getName() +
                        " eller " + getGb().getFI().getField(14).getName(), redField);

                Position = 0;
                switch (Userinput) {
                    case "Spillehallen \n Spillehallen":
                        Position = 13;
                        break;
                    case "Kinoen \n Biografen":
                        Position = 14;
                        break;
                }
                getGb().getCurrentPlayer().setPayNothing(true);
                setPlayer(Position);
                break;

            case 18:
                // Move to the skate park to do the perfect grind! If no one owns it you get it for free, otherwise pay the owner rent
                getGb().getCurrentPlayer().setPayNothing(true);
                setPlayer(10);
                break;

            case 19:
                // Move to a lightblue or red square, if no one owns it you get it for free, otherwise pay the owner rent.
                String lbrField[] = {getGb().getFI().getField(13).getName(),
                        getGb().getFI().getField(14).getName(),
                        getGb().getFI().getField(4).getName(),
                        getGb().getFI().getField(5).getName()};

                String UserInteger = getGb().gui.getUserButtonPressed("Choose a field to land on: " +
                        getGb().getFI().getField(13).getName() +
                        " , " + getGb().getFI().getField(14).getName() +
                        " , " + getGb().getFI().getField(4).getName() +
                        " eller " + getGb().getFI().getField(5).getName(), lbrField);

                switch (UserInteger) {
                    case "Spillehallen \n Spillehallen":
                        Position = 13;
                        break;
                    case "Kinoen \n Biografen":
                        Position = 14;
                        break;
                    case "Godtebutikken \n Slikbutikken":
                        Position = 4;
                        break;
                    case "ISKIOSKEN \n ISKIOSKEN":
                        Position = 5;
                        break;
                }

                getGb().getCurrentPlayer().setPayNothing(true);
                setPlayer(Position);
                break;
            case 20:
                // Move to a brown or yellow square, if no one owns it you get it for free, otherwise pay the owner rent.
                String byField[] = {getGb().getFI().getField(1).getName(),
                        getGb().getFI().getField(2).getName(),
                        getGb().getFI().getField(10).getName(),
                        getGb().getFI().getField(11).getName()};
                String UserInteger1 = getGb().gui.getUserButtonPressed("Choose a field to land on: " +
                        getGb().getFI().getField(1).getName() +
                        " , " + getGb().getFI().getField(2).getName() +
                        " , " + getGb().getFI().getField(10).getName() +
                        " eller " + getGb().getFI().getField(11).getName(), byField);
                Position = 0;
                switch (UserInteger1) {
                    case "GATEKJØKKENET \n BURGERBAREN":
                        Position = 1;
                        break;
                    case "Pizzahuset \n Pizzeriaet":
                        Position = 2;
                        break;
                    case "Rullebretparken \n Skateparken":
                        Position = 10;
                        break;
                    case "Svømmebassenget \n Swimmingpoolen":
                        Position = 11;
                        break;
                }

                getGb().getCurrentPlayer().setPayNothing(true);
                setPlayer(Position);
                break;
        }
    }




    public void move2() {
        // Move up to 5 fields forward
        String arr1[] = {"1","2","3","4","5"};
        String userIn = getGb().gui.getUserButtonPressed("How many fields do you want to move forward?", arr1);
        int move = 0;
        switch (userIn) {
            case "1":
                move = 1;
                break;
            case "2":
                move = 2;
                break;
            case "3":
                move = 3;
                break;
            case "4":
                move = 4;
                break;
            case "5":
                move = 5;
                break;
        }
        getGb().getHandler().removeplayer();
        getGb().getCurrentPlayer().setCurrentPosition(getGb().getCurrentPlayer().getCurrentPosition() + move);
        getGb().getLogic().checkforStart();
        getGb().getHandler().movePlayer();

        // CANNOT USE THE SETPLAYER FUNCTION SINCE IT DOESNT SET A PLAYER, IT MOVES HIM.
        }

    public String toString() {
        String output = "";
        for (int i = 0; i < this.deck.length; i++) {
            output += this.deck[i] + "\n";
            System.out.println(this.deck[i]);
        }
        return output;
    }

    public void setPlayer(int position) {

        getGb().getHandler().removeplayer();
        getGb().getCurrentPlayer().setCurrentPosition(position);
        getGb().getHandler().movePlayer();
        getGb().getFI().getField(position).FieldFunctionality();

    }

    private GameBoard getGb() { return GameBoard.getInstance(); }

}

