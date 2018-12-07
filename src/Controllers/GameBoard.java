package Controllers;

import Models.*;
import View.GUI_Handler;
import gui_codebehind.GUI_FieldFactory;
import gui_fields.GUI_Car;
import gui_fields.GUI_Player;
import gui_main.GUI;
import Models.Board;

import java.awt.*;

/**
 * There is an instans of gameboard so we can refer to the objects and their variables from this class, in other classes
 * without having to make new instanes of the Gameboard every time.
 */
public class GameBoard {

    private static final GameBoard INSTANS = new GameBoard();
    private static Board FI = new Board();
    private GUI_Handler handler = new GUI_Handler();
    private static ChanceCardDeck CD;
    private GUI_FieldFactory fc = new GUI_FieldFactory();
    private Logic logic = new Logic();
    private GUI_Player[] guiArray;
    private Player[] playerArray;
    private GUI_Player currentGUIPlayer;
    private Player currentPlayer;
    private int players;
    private Dice die;
    private GUI gui;

    /**
     * Creates the gameboard instance.
     */
    public GameBoard() {
        gui = new GUI();
        die = new Dice();
        players = askForPlayers();
        guiArray = new GUI_Player[players];
        playerArray = new Player[players];
        CD = new ChanceCardDeck(gui);
    }

    /**
     * Creates the player array from user input. Then starts the loop of turns which terminates once a player is broke.
     * More in method.
     */

    public void startGame() {

        createPlayers();
        movePlayer();

    }


    /**
     * Initalizes the players turn
     */

    public void playerTurn() {

        gui.showMessage("It is " + currentPlayer.getName() + "'s turn. Press enter to roll the dice.");
        die.roll();
        handler.setDice();

    }

    /**
     * Method that is basically the whole games logic on a loop. Until the method CheckforBroke breaks it
     * once a player has a balance of 0.
     */
    public void movePlayer() {

        logic.checkforInJail();
        playerTurn();
        currentPlayer.setCurrentPosition(currentPlayer.getCurrentPosition() + die.getValue());
        logic.checkforStart();
        handler.UpdateBoard();
        logic.applySquareLogic();
        handler.UpdateBoard();
        logic.CheckforBroke();
        logic.getPlayerTurn();
        movePlayer();


    }

    /**
     * The method which is called at the start of the game to define the amount of players.
     */
    public int askForPlayers() {
        do {
            players = gui.getUserInteger(" How many players? Max 4 players. \n Remember youngest goes first!");
            if (players > 1 && players < 5) {
                break;
            } else {
                gui.showMessage("Not a valid number");
            }
        } while (players > 1 && players < 5 );
        return players;
    }

    /**
     * Creates players name and icon, which they choose themselves
     */

    public void createPlayers() {
        String[] arr = {"CAR", "RACECAR", "UFO", "TRACTOR"};
        String[] arr1 = {"White", "Black", "Red", "Blue"};
        for (int i = 0; i < players; i++) {
            String name = gui.getUserString("What would you like your name to be?");
            playerArray[i] = new Player(name);
            String a = gui.getUserButtonPressed("Which icon would you like to have?", arr);
            String color = gui.getUserButtonPressed("Which colour would you like?", arr1);
            Color c;
            String[] arrTemp = new String[arr1.length-1];

            switch (color) {
                case "White":
                    c = Color.WHITE;
                    int z = 0;
                    for(int j = 0; j <arr1.length; j++){
                        if(arr1[j] != "White"){
                            arrTemp[z] = arr1[j];
                            z++;
                        }
                    }
                    break;
                case "Black":
                    c = Color.BLACK;
                    int z1 = 0;
                    for(int k = 0; k <arr1.length; k++){
                        if(arr1[k] != "Black"){
                            arrTemp[z1] = arr1[k];
                            z1++;
                        }
                    }
                    break;
                case "Red":
                    c = Color.RED;
                    int z2 = 0;
                    for(int l = 0; l <arr1.length; l++){
                        if(arr1[l] != "Red"){
                            arrTemp[z2] = arr1[l];
                            z2++;
                        }
                    }
                    break;
                case "Blue":
                    c = Color.BLUE;
                    int z3 = 0;
                    for(int m = 0; m <arr1.length; m++){
                        if(arr1[m] != "Blue"){
                            arrTemp[z3] = arr1[m];
                            z3++;
                        }
                    }
                    break;
                default:
                    c = Color.BLACK;
                    break;
            }

            GUI_Car Car = new GUI_Car(c, c, GUI_Car.Type.getTypeFromString(a), GUI_Car.Pattern.DOTTED);
            GUI_Player spiller = new GUI_Player(name, 24 - 2 * players, Car);
            guiArray[i] = spiller;

            arr1 = new String[arrTemp.length];
            for(int z = 0; z < arrTemp.length; z++){
                arr1[z] = arrTemp[z];

            }
            gui.getFields()[0].setCar(spiller, true);
            gui.addPlayer(spiller);
        }
        currentGUIPlayer = guiArray[0];
        currentPlayer = playerArray[0];

    }

    /**
     * Getters and setters for the other classes to use when they refer to the board.
     */
    public static ChanceCardDeck getCD() { return CD; }

    public GUI getGui() {
        return gui;
    }

    public GUI_Player getCurrentGUIPlayer() { return currentGUIPlayer; }

    public Player getCurrentPlayer() { return currentPlayer; }

    public int getPlayers() { return players; }

    public Board getFI() { return FI; }

    public static GameBoard getInstance() { return INSTANS; }

    public GUI_Player[] getGuiArray() { return guiArray; }

    public void setCurrentPlayer(Player currentPlayer) { this.currentPlayer = currentPlayer; }

    public Player[] getPlayerArray() { return playerArray; }

    public GUI_Handler getHandler() { return handler; }

    public Logic getLogic() { return logic; }

    public void setCurrentGUIPlayer(GUI_Player currentGUIPlayer) { this.currentGUIPlayer = currentGUIPlayer; }

    public Dice getDie() { return die; }

    public void setPlayerArray(Player[] playerArray) {
        this.playerArray = playerArray;
    }
}



