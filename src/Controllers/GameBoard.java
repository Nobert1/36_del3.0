package Controllers;

import Models.Dice;
import Models.Fields;
import Models.Player;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;

import java.awt.*;

public class GameBoard{

    private static final GameBoard INSTANS = new GameBoard();
    public GUI gui;
    private Dice die;
    private int players;
    private GUI_Player[] guiArray;
    private Player[] playerArray;
    private GUI_Player currentPlayer;
    private Player player;
    private static final Fields[] fields = Fields.getFields();



    private GameBoard(){
        this.gui = new GUI();
        this.die = new Dice();
        this.players = setPlayers();
        this.guiArray = new GUI_Player[players];
        this.playerArray = new Player[players];


    }


    public void startGame(){
        setPlayerNames();
        //fields = Fields.makeFields();
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

    public void setPlayerNames(){
        for (int i = 0; i < players; i++) {
            String name = gui.getUserString("What would you like your name to be?");
            playerArray[i] = new Player(name);
            String[] arr = {"CAR", "RACECAR", "UFO", "TRACTOR"};
            String a = gui.getUserButtonPressed("Which icon would you like to have?", arr);
            String[] arr1 = {"White", "Black", "Red", "Blue"};
            String color = gui.getUserButtonPressed("Which colour would you like?", arr1);
            Color c;
            switch(color){
                case"White": c = Color.WHITE;
                    break;
                case"Black": c = Color.BLACK;
                    break;
                case"Red": c = Color.RED;
                    break;
                case"Blue": c = Color.BLUE;
                    break;
                default: c = Color.BLACK;
            }
            GUI_Car Car = new GUI_Car(c, c, GUI_Car.Type.getTypeFromString(a), GUI_Car.Pattern.DOTTED);
            GUI_Player spiller = new GUI_Player(name, 24-2*players, Car, 0);
            guiArray[i] = spiller;
            gui.getFields()[0].setCar(guiArray[i], true);
            gui.addPlayer(spiller);

        }
        currentPlayer = guiArray[0];
        player = playerArray[0];
    }

    public void playerTurn(){


        gui.showMessage("It is " + currentPlayer.getName() + "'s turn. Press enter to roll the dice.");
        die.roll();
        gui.setDie(die.getValue());
        movePlayer();

    }

    public void movePlayer(){

        gui.getFields()[currentPlayer.getPlacement()].setCar(currentPlayer, false);
        currentPlayer.setPlacement(currentPlayer.getPlacement() + die.getValue());
        gui.getFields()[currentPlayer.getPlacement()].setCar(currentPlayer, true);

        player.setCurrentposition(currentPlayer.getPlacement());

        applySquareLogic();
        //getPlayerTurn();
    }
    public void applySquareLogic() {

        int i = currentPlayer.getPlacement();
        fields[i].OutputToGUI();
        fields[i].FieldFunctionality();

        getPlayerTurn();

    }

    public void getPlayerTurn(){
        if (currentPlayer == guiArray[0]) {
            currentPlayer = guiArray[1];
            player = playerArray[1];

        } else if (currentPlayer == guiArray[1]) {
            currentPlayer = guiArray[2%guiArray.length];
            player = playerArray[2%playerArray.length];

        } else if (currentPlayer == guiArray[2]) {
            currentPlayer = guiArray[3%guiArray.length];
            player = playerArray[3%playerArray.length];

        } else if (currentPlayer == guiArray[3]) {
            currentPlayer = guiArray[0];
            player = playerArray[0];
        }
        playerTurn();
    }


    public static GameBoard getINSTANS() {
        return INSTANS;
    }

    public static Fields[] getFIELD(){
        return fields;
    }

    public GUI_Player getCurrentPlayer(){
        return currentPlayer;
    }

    public Player getPlayer() {
        return player;
    }

}

