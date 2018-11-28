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

    private final int maxValue = 20;
    private int position = 0;

    public ChanceCardDeck(GUI gui) {

        deck = new ChanceCards[20];
        deck[0] = new ChanceCards("Move to START and recive 2$", "CHANCE", 0);
        deck[1] = new ChanceCards("Move up to 5 fields forward", "CHANCE", 1);
        deck[2] = new ChanceCards("Move to an orange square, if the field is not owned you get it for free, otherwise you have to pay the owner rent", "CHANCE", 2);
        deck[3] = new ChanceCards("Move 1 square forward or take another card", "CHANCE", 3);
        deck[4] = new ChanceCards("You ate too much candy, pay 2$ to the bank", "CHANCE", 4);
        deck[5] = new ChanceCards("Move to an orange or green square. If no one owns it you get it for free, else you have to play rent to the owner", "CHANCE", 5);
        deck[6] = new ChanceCards("Move to an lightblue square, if no one owns it you get it for free! otherwise you have to pay rent to the owner", "CHANCE", 6);
        deck[7] = new ChanceCards("You are released without any cost, keep this card until you need it.", "CHANCE", 7);
        deck[8] = new ChanceCards("Move to Strandpromenaden", "CHANCE", 8);
        deck[9] = new ChanceCards("It's your birthday! Everyone gives you 1$", "CHANCE", 9);
        deck[10] = new ChanceCards("Move to a pink or darkblue square, if no one owns the square you get it for free! Otherwise you have to pay the owner rent", "CHANCE", 10);
        deck[11] = new ChanceCards("You have made all of your homework, recive 2$ from the bank", "CHANCE", 11);
        deck[12] = new ChanceCards("Move to a red square, if no one owns it you get it for free! Otherwise you have to pay the owner rent.", "CHANCE", 12);
        deck[13] = new ChanceCards("Move to the skate park to do the perfect grind! If no one owns it you get it for free, otherwise pay the owner rent", "CHANCE", 13);
        deck[14] = new ChanceCards("Move to a lightblue or red square, if no one owns it you get it for free, otherwise pay the owner rent.", "CHANCE", 14);
        deck[15] = new ChanceCards("Move to a brown or yellow square, if no one owns it you get it for free, otherwise pay the owner rent.", "CHANCE", 15);

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
            this.deck[i] = korttemp[(i + 1) % 16];
        }

        deck[15] = firstCardKort;
        getGb().gui.displayChanceCard(firstCardKort.getDescription());

    }
    public void UseChancecard() {
        String Userinput;
        position = 0;
        switch (deck[15].getNumber()) {

            case 0:
                //Move to START and recive 2$
                setPlayer(0);
                // Changed the method, this will give him the two bucks, i just changed it in general since
                // everytime someone passes start on the other functions they need 2$ as well.
                break;
            case 1:
                //Move up to 5 fields forward
                move2();
                break;
            case 2:
                // Move to an orange square, if the field is not owned you get it for free, otherwise you have to pay the owner rent
                String oField[] = {"skateparken", "swimmingpoolen"};
                Userinput = getGb().gui.getUserButtonPressed("Choose a field to land on: " +
                                                             "skateparken eller swimmingpoolen", oField);

                switch (Userinput) {
                    case "skateparken":
                        position += 10;
                        break;
                    case "swimmingpoolen":
                        position += 11;
                        break;
                }
                getGb().getCurrentPlayer().setPayNothing(true);
                setPlayer(position);
                break;

            case 3:
                // Move 1 square forward or take another card

                String arr2[] = {"Move", "Draw"};
                Userinput = getGb().gui.getUserButtonPressed("Choose one: move one field forward or draw another card", arr2);
                if (Userinput.equals(arr2[0])) {
                    position += 1;
                    movePlayer(position);
                } else {
                    drawCard();
                }
                break;

            case 4:
                // You ate too much candy, pay 2$ to the bank
                getGb().getCurrentPlayer().getAccount().withdraw(2);
                break;
            case 5:
                // Move to an orange or green square. If no one owns it you get it for free, else you have to play rent to the owner
                String ogField[] = {"skateparken", "swimmingpoolen", "bowlinghallen", "zoologisk have" };
                Userinput = getGb().gui.getUserButtonPressed("Choose a field to land on: " +
                        "skateparken, swimmingpoolen, bowlinghallen eller zoologisk have", ogField);

                switch (Userinput) {
                    case "skateparken":
                        position += 10;
                        break;
                    case "swimmingpoolen":
                        position += 11;
                        break;
                    case "bowlinghallen":
                        position += 19;
                        break;
                    case "zoologisk have":
                        position += 20;
                        break;
                }
                getGb().getCurrentPlayer().setPayNothing(true);
                setPlayer(position);
                break;
            case 6:
                // Move to an lightblue square, if no one owns it you get it for free! otherwise you have to pay rent to the owner
                String lbField[] = {"slikbutikken", "iskiosken"};
                Userinput = getGb().gui.getUserButtonPressed("Choose a field to land on: " +
                                                             "slikbutikken eller iskiosken", lbField);
                switch (Userinput) {
                    case "slikbutikken":
                        position += 4;
                        break;
                    case "iskiosken":
                        position += 5;
                        break;
                }
                getGb().getCurrentPlayer().setPayNothing(true);
                setPlayer(position);
                break;
            case 7:
                // You are released without any cost, keep this card until you need it.
                getGb().getCurrentPlayer().setJailCard(true);
                break;
            case 8:
                // Move to Strandpromenaden
                setPlayer(23);
                break;

            case 9:
                // It's your birthday! Everyone gives you 1$
                for(int i = 0; i < getGb().getPlayerArray().length; i++) {
                    getGb().getPlayerArray()[i].getAccount().withdraw(1);
                    getGb().getCurrentPlayer().getAccount().deposit(1);
                }
                break;
            case 10:
                // Move to a pink or darkblue square, if no one owns the square you get it for free! Otherwise you have to pay the owner rent
                String pdField[] = {"museet", "bibloteket", "vandlandet", "strandpromenaden"};
                Userinput = getGb().gui.getUserButtonPressed("Choose a field to land on: " +
                                                             "museet, bibloteket, vandlandet eller strandpromenaden", pdField);
                switch (Userinput) {
                    case "museet":
                        position += +7;
                        break;
                    case "bibloteket":
                        position += 8;
                        break;
                    case "vandlandet":
                        position += 22;
                        break;
                    case "strandpromenaden":
                        position += 23;
                        break;
                }
                getGb().getCurrentPlayer().setPayNothing(true);
                setPlayer(position);
                break;
            case 11:
                // You have made all of your homework, recive 2$ from the bank
                getGb().getCurrentPlayer().getAccount().deposit(2);
                break;
            case 12:
                // Move to a red square, if no one owns it you get it for free! Otherwise you have to pay the owner rent.
                String redField[] = {"spillehallen", "biografen"};

                Userinput = getGb().gui.getUserButtonPressed("Choose a field to land on: " +
                                                             "spillehallen eller biografen", redField);
                switch (Userinput) {
                    case "spillehallen":
                        position += 13;
                        break;
                    case "biografen":
                        position += 14;
                        break;
                }
                getGb().getCurrentPlayer().setPayNothing(true);
                setPlayer(position);
                break;

            case 13:
                // Move to the skate park to do the perfect grind! If no one owns it you get it for free, otherwise pay the owner rent
                getGb().getCurrentPlayer().setPayNothing(true);
                setPlayer(10);
                break;
            case 14:
                // Move to a lightblue or red square, if no one owns it you get it for free, otherwise pay the owner rent.
                String lbrField[] = {"spillehallen", "biografen", "slikbutikken", "iskiosken"};
                String UserInteger = getGb().gui.getUserButtonPressed("Choose a field to land on: " +
                                        "spillehallen, biografen, slikbutikken eller iskiosken", lbrField);

                switch (UserInteger) {
                    case "spillehallen":
                        position += 13;
                        break;
                    case "biografen":
                        position += 14;
                        break;
                    case "slikbutikken":
                        position += 4;
                        break;
                    case "iskiosken":
                        position += 5;
                        break;
                }
                getGb().getCurrentPlayer().setPayNothing(true);
                setPlayer(position);
                break;
            case 15:
                // Move to a brown or yellow square, if no one owns it you get it for free, otherwise pay the owner rent.
                String byField[] = {"burgerbaren", "pizzariaet", "legetøjsbutikken", "dyrehandlen"};
                String UserInteger1 = getGb().gui.getUserButtonPressed("Choose a field to land on: " +
                        "burgerbaren, pizzariaet, legetøjsbutikken eller dyrehandlen", byField);

                switch (UserInteger1) {
                    case "burgerbaren":
                        position = 1;
                        break;
                    case "pizzariaet":
                        position = 2;
                        break;
                    case "legetøjsbutikken":
                        position = 16;
                        break;
                    case "dyrehandlen":
                        position = 17;
                        break;
                }
                getGb().getCurrentPlayer().setPayNothing(true);
                setPlayer(position);
                break;
        }
    }

    public void move2() {
        // Move up to 5 fields forward
        String arr1[] = {"1","2","3","4","5"};
        String userIn = getGb().gui.getUserButtonPressed("How many fields do you want to move forward?", arr1);

        switch (userIn) {
            case "1":
                position += 1;
                break;
            case "2":
                position += 2;
                break;
            case "3":
                position += 3;
                break;
            case "4":
                position += 4;
                break;
            case "5":
                position += 5;
                break;
        }
        movePlayer(position);

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

    public void movePlayer(int position) {

        getGb().getCurrentPlayer().setCurrentPosition(getGb().getCurrentPlayer().getCurrentPosition() + position);
        getGb().getLogic().checkforStart();

    }

    public void setPlayer(int position) {
        if (getGb().getCurrentPlayer().getCurrentPosition() == 0) {
            getGb().getCurrentPlayer().getAccount().deposit(2);
            getGb().gui.showMessage("You are landing on go. Collect 2 dollars.");

        }
        if (getGb().getCurrentPlayer().getCurrentPosition() > position) {
            getGb().getCurrentPlayer().getAccount().deposit(2);
            getGb().gui.showMessage("You are passing go. Collect 2 dollars.");
        }

        getGb().getCurrentPlayer().setCurrentPosition(position);
        getGb().getFI().getField(position).FieldFunctionality();

    }
    private GameBoard getGb() { return GameBoard.getInstance(); }

}

