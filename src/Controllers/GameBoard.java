package Controllers;

import Models.*;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;

public class GameBoard {

    private static GameBoard Instans = new GameBoard();
    public GUI gui;
    private Dice die;
    private int players;

    public GUI_Player[] guiArray;
    private Player[] playerArray;
    private GUI_Player currentGUIPlayer;
    private Player player;
    private static final Board FIELDSINSTANS = new Board();
// Board skal være statisk ellers får vi en exception der hedder Initalization. Dvs at det board er ikke oprettet når programmet gerne
    // Vil benytte sig af det, der er muligvis et fix.

    public GameBoard() {

        this.gui = new GUI();
        this.die = new Dice();
        this.players = setPlayers();
        this.guiArray = new GUI_Player[players];
        this.playerArray = new Player[players];


    }


    public void startGame() {

        setPlayerNames();
        playerTurn();
    }


    public int setPlayers() {
        while (true) {
            players = gui.getUserInteger(" How many players? Max 4 players ");
            if (players > 1 && players < 5) {
                break;
            } else {
                gui.showMessage("Not a valid number");
            }
        }

        return players;
    }


    public void setPlayerNames() {
        for (int i = 0; i < players; i++) {
            String name = gui.getUserString("What would you like your name to be?");
            playerArray[i] = new Player(name);
            String[] arr = {"CAR", "RACECAR", "UFO", "TRACTOR"};
            String a = gui.getUserButtonPressed("Which icon would you like to have?", arr);
            String[] arr1 = {"White", "Black", "Red", "Blue"};
            String color = gui.getUserButtonPressed("Which colour would you like?", arr1);
            Color c;
            switch (color) {
                case "White":
                    c = Color.WHITE;
                    break;
                case "Black":
                    c = Color.BLACK;
                    break;
                case "Red":
                    c = Color.RED;
                    break;
                case "Blue":
                    c = Color.BLUE;
                    break;
                default:
                    c = Color.BLACK;
            }
            GUI_Car Car = new GUI_Car(c, c, GUI_Car.Type.getTypeFromString(a), GUI_Car.Pattern.DOTTED);
            GUI_Player spiller = new GUI_Player(name, 24 - 2 * players, Car, 0);
            guiArray[i] = spiller;
            gui.getFields()[0].setCar(guiArray[i], true);
            gui.addPlayer(spiller);

        }
        currentGUIPlayer = guiArray[0];
        player = playerArray[0];
    }

    public void playerTurn() {


        gui.showMessage("It is " + currentGUIPlayer.getName() + "'s turn. Press enter to roll the dice.");
        die.roll();
        gui.setDie(die.getValue());
        movePlayer();

    }

    public void movePlayer() {

        gui.getFields()[currentGUIPlayer.getPlacement()].setCar(currentGUIPlayer, false);
        player.setCurrentposition(player.getCurrentPosition() + die.getValue());
        checkforStart();
        gui.getFields()[player.getCurrentPosition()].setCar(currentGUIPlayer, true);


        applySquareLogic();

        //getPlayerTurn();
    }

    public void applySquareLogic() {

        int i = currentGUIPlayer.getPlacement();
        //BOARDINSTANS[i].getFields();
        FIELDSINSTANS.getField(i).OutputToGUI();
        FIELDSINSTANS.getField(i).FieldFunctionality();

        getPlayerTurn();
        updatePlayerBalances();
    }

    public void getPlayerTurn() {
        if (currentGUIPlayer == guiArray[0]) {
            currentGUIPlayer = guiArray[1];
            player = playerArray[1];

        } else if (currentGUIPlayer == guiArray[1]) {
            currentGUIPlayer = guiArray[2 % guiArray.length];
            player = playerArray[2 % playerArray.length];

        } else if (currentGUIPlayer == guiArray[2]) {
            currentGUIPlayer = guiArray[3 % guiArray.length];
            player = playerArray[3 % playerArray.length];

        } else if (currentGUIPlayer == guiArray[3]) {
            currentGUIPlayer = guiArray[0];
            player = playerArray[0];
        }
        playerTurn();
    }


    public GUI_Player getCurrentGUIPlayer() {
        return currentGUIPlayer;
    }

    public Player getPlayer() {
        return player;
    }

    public Board getFIELDSINSTANS() {
        return FIELDSINSTANS;
    }

    public static GameBoard getInstance() {
        return Instans;
    }

    public String print() {
        String output = "";
        for (int i = 0; i < getGuiArray().length; i++) {
            output += guiArray[i].getName() + "\n";
        }
        return output;
    }

    public GUI_Player[] getGuiArray() {
        return guiArray;
    }

    public void updatePlayerBalances() {

        for (int i = 0; i < playerArray.length; i++)
            guiArray[i].setBalance(playerArray[i].getAccount().getBalance());
    }

    public void checkforStart() {
        if (player.getCurrentPosition() > 24) {
            player.getAccount().deposit(2);
            player.setCurrentposition(player.getCurrentPosition() % 24);
        }
    }
    }



